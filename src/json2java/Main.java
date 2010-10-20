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


        int flag = 1;

        switch (flag) {
            case 1:
                System.out.println("Performing Natural Language Processing on data\n\n");
                //NLP Module Call
                f.runNLP(TextPreprocessor.count);
                break;
            case 2:
                System.out.println("Perfoming Latent Dirichlet Allocation on data\n\n");
                //LDA module Call
                f.LDAAnalysis(5, 0.5, 0.1); //(int numberOfTopics
                break;
            case 3:
                System.out.println("Calculating Normalized Google Distance and Assigning Tags\n\n");
                //(int numberOfWordsToKeep, double minimumWordProbability, String userWords -space separated-, int numberOfTopics,
                //String categories I/O files for classification)
                f.NGDCalculate(5, 0.0, "ruby",5, "buglist.txt", "BugTypesAssigned.txt", "SQMetrics.txt", "SQMAssigned.txt");
                break;
            default:
                System.out.println("Creating .arff file for WEKA Import...Please Wait");
                //NLP Module Call
                f.runNLP(TextPreprocessor.count);
                //LDA module Call
                f.LDAAnalysis(2, 0.5, 0.1); //(int numberOfTopics
                //(int numberOfWordsToKeep, double minimumWordProbability, String userWords -space separated-, int numberOfTopics,
                //String categories I/O files for classification)
                f.NGDCalculate(5, 0.0, "ruby", 2, "buglist.txt", "BugTypesAssigned.txt", "SQMetrics.txt", "SQMAssigned.txt");

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

