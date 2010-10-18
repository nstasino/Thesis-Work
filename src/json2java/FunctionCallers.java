package json2java;

import java.io.*;
import java.io.IOException;
import org.htmlcleaner.XPatherException;

/**
 *
 * @author Nikos Stasinopoulos <nstasinopoulos@gmail.com>
 * @version     Oct 16, 2010
 * @since       1.6
 */
public class FunctionCallers {

    public void runNLP(int nTickets) throws IOException, XPatherException {
        ///////////////////////////////
        //Natural Language Processing Unit
        //////////////////////////////

        //Set below ticketsToProcess = i.e. 1000 to run
        int ticketsToProcess = nTickets;

        //Initialize Parser Factory
        NLParser p = new NLParser(); //Stanford NLParser Object

        //Initialize keywords.txt file
        BufferedWriter init = null;
        init = new BufferedWriter(new FileWriter("keywords.txt", false));
        init.append(Integer.toString(ticketsToProcess) + "\n");
        init.close();

        for (int i = 1; i < ticketsToProcess + 1; i++) {//count if for tickets
            System.out.println("\n[" + i + "/" + TextPreprocessor.count + "]");
            File f = new File(TextPreprocessor.list[i] + "/ticket.json");
            TextPreprocessor.preProcessFile(f); //preprocess the file
            DecodeJSON Decoder = new DecodeJSON();
            Ticket t = Decoder.decode(f);    //map JSON to the POJO
//            System.out.println(t.getTicket().getNumber());
            Pair pair = p.parse(t, 100);

//            demo.ArffCreator(t, true);     //get the data out of the POJO, true to enable Stanford Parser
//            demo.ArffCreatorForVersions(t,true); //same for the new versions, true to enable Stanford Parser
        }

    }

    public void LDAAnalysis(int nTopics) {
        TagEstimator tagger = new TagEstimator();
        tagger.runLDA(nTopics, "/home/nikos/NetBeansProjects/Thesis-Work/");
//        tagger.LDAThetaReader(2);

    }

    public void NGDCalculate(int numOfWordsSelect, double minimumProbability, String userWord, int nTopics) throws IOException {
        NGDCalculator n = new NGDCalculator();
        n.readFile();
        String wordvector = n.wordSelector(numOfWordsSelect, minimumProbability);
//               for (String s : n.BugListPopulator()){System.out.println(s);}
        String[] x1 = n.BugTypeDecider(" ".concat(userWord), n.BugListPopulator("buglist.txt"));
        int[] x2 = n.thetaDecider(n.thetaParser("model-final.theta", nTopics));//which bugtype do they belong to?
//        System.out.println(x1[0]);
        for (int i = 0; i < x2.length; i++) {
            System.out.println(x2[i]);
        }



//        n.SQMDecider(" ".concat(userWord), n.BugListPopulator("SQMetrics.txt"));
    }

    public void createArff(int nTickets, int nTopics, int numOfWordsSelect, double minimumProbability, String userWord) throws IOException, XPatherException {
        runNLP(nTickets);
        LDAAnalysis(nTopics);
        NGDCalculator n = new NGDCalculator();
        n.readFile();
        String wordvector = n.wordSelector(numOfWordsSelect, minimumProbability);
//               for (String s : n.BugListPopulator()){System.out.println(s);}
        n.BugTypeDecider(" ".concat(userWord), n.BugListPopulator("buglist.txt"));
        n.SQMDecider(" ".concat(userWord), n.BugListPopulator("SQMetrics.txt"));


        for (int i = 1; i < nTickets + 1; i++) {//count if for tickets
            System.out.println("\n[" + i + "/" + TextPreprocessor.count + "]");
            File f = new File(TextPreprocessor.list[i] + "/ticket.json");
            TextPreprocessor.preProcessFile(f); //preprocess the file
            DecodeJSON Decoder = new DecodeJSON();
            Ticket t = Decoder.decode(f);    //map JSON to the POJO
//            Pair pair = p.parse(t, 200);

//            demo.ArffCreator(t, true);     //get the data out of the POJO, true to enable Stanford Parser
//            demo.ArffCreatorForVersions(t,true); //same for the new versions, true to enable Stanford Parser
        }
    }

    public void dirScanner() {  //Scan directory for tickets

        String directoryName = "Data/tickets/"; // set to current directory
        System.out.println("Scanning dir : " + directoryName);
        File dir = new File(directoryName);
        TextPreprocessor.visitAllDirsAndFiles(dir);
        System.out.println("Finished Scanning dir : " + directoryName);
        System.out.println("Tickets count : " + TextPreprocessor.count + "\n");
    }
}
