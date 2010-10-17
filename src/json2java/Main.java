package json2java;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import java.io.*;
import java.util.Scanner;

import org.htmlcleaner.XPatherException;

/**
 * @author      Nikos Stasinopoulos <nstasinopoulos@gmail.com>
 * @version     2010.0720
 * @since       1.6
 */
public class Main {

    /**
     * Main. Set ticketsToProcess = i.e. 1000 to run
     * Returns Stanford Parser results to Possible{Nouns,Verbs}.txt if appropriate flags are set true
     *
     * @param args
     * @throws JsonMappingException
     * @throws JsonParseException
     * @throws IOException
     * @throws XPatherException
     */
    public static void main(String[] args) throws JsonMappingException, JsonParseException, IOException, XPatherException {

        FunctionCallers f = new FunctionCallers();
        //Directory Scanner Call
        f.dirScanner();


        int flag = 3;

        switch (flag) {
            case 1:
                System.out.println("Performing Natural Language Processing on data\n\n");
                //NLP Module Call
                f.runNLP(25);
                break;
            case 2:
                System.out.println("Perfoming Latent Dirichlet Allocation on data\n\n");
                //LDA module Call
                f.TopicFinder(2);
                break;
            case 3:
                System.out.println("Calculating Normalized Google Distance\n\n");
                NGDCalculator n = new NGDCalculator();
                n.readFile();
                n.wordSelector(5, 0.0);
//               for (String s : n.BugListPopulator()){System.out.println(s);}
//                n.BugTypeDecider("", n.BugListPopulator("buglist.txt"));
                n.SQMDecider("", n.BugListPopulator("SQMetrics.txt"));
// new NGDCalculator().BugListPopulator();
// System.out.println(new NGDCalculator().determineLinesNumberofFile("buglist.txt"));
//                double x = new NGDCalculator().NGD("ruby stack run base logger set migration line fail place seem switch", "portability");
//                System.out.println(x);
                break;
            default:
                break;
        }



//        //Create .ARFF
//        ArffCreator demo = new ArffCreator(); //create class instance
//        demo.createHeader();  //append the Header to .arff







    }
}
//214 problem with diffable attributes - delete ticket from data
//428 not removing \r\n
//line 8989 15439 15441 something wrong w/ date

