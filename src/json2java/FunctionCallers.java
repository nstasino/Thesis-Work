package json2java;

import java.io.*;
import java.io.IOException;
import org.htmlcleaner.XPatherException;

/**
 *
 * @author Nikos Stasinopoulos <nstasinopoulos@gmail.com>
 * @version     Nov 02, 2010
 * @since       1.6
 */
public class FunctionCallers {

    /**
     * Natural Language Processing Unit.<p>
     *
     * Reads the tickets from working_directory/Data folder and performs NLP on each one.<p>
     *
     * @param nTickets Number of tickets to be processed by the NLP
     *
     * @throws IOException
     * @throws XPatherException
     */
    public void runNLP(int nTickets) throws IOException, XPatherException {
        ////////////////////////////////////
        //Natural Language Processing Unit//
        ////////////////////////////////////

        int ticketsToProcess = nTickets;

        //Initialize Parser Factory
        NLParser p = new NLParser(); //Stanford NLParser Object

        //Initialize keywords.txt file
        BufferedWriter init = null;
        init = new BufferedWriter(new FileWriter("keywords.txt", false));
        init.append(Integer.toString(ticketsToProcess) + "\n");
        init.close();

        //Initialize the data.arff file
        new FileWriter("data.arff", false);
        ArffCreator aC = new ArffCreator();
//        aC.createHeader();  //append the Header to .arff

        for (int i = 0; i < ticketsToProcess; i++) {//for each ticket.json to be processed
            System.out.println("\n[" + i + "/" + ticketsToProcess + "]");
            File f = new File(TextPreprocessor.list[i] + "/ticket.json");
            TextPreprocessor.preProcessFile(f); //preprocess the file
            DecodeJSON Decoder = new DecodeJSON();//Factory Object for JSON decoding
            Ticket t = Decoder.decode(f);    //map JSON to the POJO
            Pair pair = p.parse(t, 100);

            aC.ArffCreator(t);     //get the data out of the POJO
//            demo.ArffCreatorForVersions(t,true); //same for the new versions, true to enable Stanford Parser
        }

    }

    /**
     *Performs LDA on corpus of tickets
     *
     * @param nTopics Number of topics to be created by the LDA
     *
     * @param alpha Alpha (a) hyper-parameter for LDA - Gibbs (default value is 50/ nTopics)
     *
     * @param beta Beta (b) hyper-parameter for LDA - Gibbs
     *
     * @param defaultAlpha Flag for alpha default value. False to override, True for alpha  = 50/nTopics
     *
     * @param niters Number of iterations for model creation
     *
     */
    public void LDAAnalysis(int nTopics, double alpha, double beta, boolean defaultAlpha, int niters) {
        TopicEstimator tagger = new TopicEstimator();
        if (defaultAlpha == false) {
            tagger.runLDA(nTopics, "/home/nikos/NetBeansProjects/Thesis-Work/", alpha, beta, niters);
        } else {
            alpha = 50 / nTopics;
            tagger.runLDA(nTopics, "/home/nikos/NetBeansProjects/Thesis-Work/", alpha, beta, niters);
        }//        tagger.LDAThetaReader(2);

    }

    /**
     *Calculates NGD similarity for both BugType and SQ feature<br>
     *Stores value in bugsperticket.txt and metricsperticket.txt for each ticket<br>
     *
     *
     * @param numOfWordsSelect
     * @param minimumProbability
     * @param userWord
     * @param nTopics
     * @param INPUTBugTypeFilename
     * @param OUTPUTBugTypeFilename
     * @param INPUTSQMetricFilename
     * @param OUTPUTSQMetricFilename
     * @throws IOException
     */
    public void NGDCalculate(int numOfWordsSelect, double minimumProbability, String userWord, int nTopics, String INPUTBugTypeFilename, String OUTPUTBugTypeFilename, String INPUTSQMetricFilename, String OUTPUTSQMetricFilename) throws IOException {
        NGDCalculator n = new NGDCalculator();//Create Factory Object
        n.readFile();//Reads from model-final.twords file for topic-words assignment

        BufferedWriter bw = null;
        BufferedWriter bw2 = null;
        bw = new BufferedWriter(new FileWriter("bugsperticket.txt", false));//Reset txt file
        bw = new BufferedWriter(new FileWriter("bugsperticket.txt", true));
        bw2 = new BufferedWriter(new FileWriter("metricsperticket.txt", false));//Reset txt file
        bw2 = new BufferedWriter(new FileWriter("metricsperticket.txt", true));
        String wordvector = n.wordSelector(numOfWordsSelect, minimumProbability);//Selects most probable words
//        System.out.println(wordvector);

        //xBug string vector contains 
        String[] xBug = n.BugTypeDecider(" ".concat(userWord), n.BugListPopulator(INPUTBugTypeFilename), OUTPUTBugTypeFilename);
        int[] xBugDecide = n.thetaDecider(n.thetaParser("model-final.theta", nTopics));//which bugtype do they belong to?
        String[] BugsPerTicket = new String[xBugDecide.length];
//        System.out.println(BugsPerTicket.length);
        for (int i = 0; i < xBugDecide.length; i++) {
            BugsPerTicket[i] = xBug[xBugDecide[i]];
//            System.out.println(BugsPerTicket[i]);
            bw.append(BugsPerTicket[i]);
            bw.append("\n");

        }
        bw.close();
        String[] xMetric = n.SQMDecider(" ".concat(userWord), n.BugListPopulator(INPUTSQMetricFilename), OUTPUTSQMetricFilename);
        int[] xMetricDecide = n.thetaDecider(n.thetaParser("model-final.theta", nTopics));//which SQ Metric do they belong to?
        String[] SQMPerTicket = new String[xMetricDecide.length];
        for (int i = 0; i < xMetricDecide.length; i++) {
//            System.out.println(xMetric[xMetricDecide[i]]);
            SQMPerTicket[i] = xMetric[xMetricDecide[i]];
            bw2.append(SQMPerTicket[i]);
            bw2.append("\n");
        }
        bw2.close();

        new ArffCreator().enhanceArff("data.arff", "data2.arff", BugsPerTicket, SQMPerTicket, true);

    }

    /**
     *
     * @param nTickets
     * @param nTopics
     * @param numOfWordsSelect
     * @param minimumProbability
     * @param userWord
     * @param alpha
     * @param beta
     * @param niters
     * @throws IOException
     * @throws XPatherException
     */
    public void createArff(int nTickets, int nTopics, int numOfWordsSelect, double minimumProbability, String userWord, double alpha, double beta, int niters) throws IOException, XPatherException {
        runNLP(nTickets);
        LDAAnalysis(nTopics, alpha, beta, true, niters);
        NGDCalculator n = new NGDCalculator();
        n.readFile();
        String wordvector = n.wordSelector(numOfWordsSelect, minimumProbability);
//               for (String s : n.BugListPopulator()){System.out.println(s);}
        n.BugTypeDecider(" ".concat(userWord), n.BugListPopulator("buglist.txt"), "BugTypesAssigned.txt");


        for (int i = 0; i < nTickets; i++) {//count if for tickets
            System.out.println("\n[" + i + "/" + nTickets + "]");
            File f = new File(TextPreprocessor.list[i] + "/ticket.json");
            TextPreprocessor.preProcessFile(f); //preprocess the file
            DecodeJSON Decoder = new DecodeJSON();
            Ticket t = Decoder.decode(f);    //map JSON to the POJO
//            Pair pair = p.parse(t, 200);

//            demo.ArffCreator(t, true);     //get the data out of the POJO, true to enable Stanford Parser
//            demo.ArffCreatorForVersions(t,true); //same for the new versions, true to enable Stanford Parser
        }
    }

    /**
     *
     */
    public void dirScanner() {  //Scan directory for tickets

        String directoryName = "Data/tickets/"; // set to current directory
        System.out.println("Scanning dir : " + directoryName);
        File dir = new File(directoryName);
        TextPreprocessor.visitAllDirsAndFiles(dir);
        System.out.println("Finished Scanning dir : " + directoryName);
        System.out.println("Tickets count : " + TextPreprocessor.count + "\n");
    }
}
