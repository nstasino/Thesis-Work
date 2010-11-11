package json2java;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import java.io.*;


import org.htmlcleaner.XPatherException;

/**
 * @author      Nikos Stasinopoulos <nstasinopoulos@gmail.com>
 * @version     2010.0720
 * @since       1.6
 */
public class Main {

    /**
     * Main Class.
     * Run all steps (ie. 1-4) for the data folder given.
     * Default case performs all steps in a row.
     *
     * Each step calls the appropriate functions from FunctionCallers.java class
     *
     * @param args
     * @throws JsonMappingException
     * @throws JsonParseException
     * @throws IOException
     * @throws XPatherException
     * @throws Exception
     */
    public static void main(String[] args) throws JsonMappingException, JsonParseException, IOException, XPatherException, Exception {

        FunctionCallers f = new FunctionCallers();
        //Directory Scanner Call
        f.dirScanner();


        int flag = 2;
        switch (flag) {
            case 1:
                //NLP Module Call
                System.out.println("Performing Natural Language Processing on data\n\n");
                f.runNLP(TextPreprocessor.count);
                break;
            case 2:
                //LDA module Call
                System.out.println("Perfoming Latent Dirichlet Allocation on data\n\n");
                f.LDAAnalysis(5, 0.5, 0.1, true, 2000); //(int numberOfTopics, alpha beta, boolean runWithDefaultAlphaValue, int niters
                break;
            case 3:
                //NGD module Call
                System.out.println("Calculating Normalized Google Distance and Assigning Tags\n\n");
                //(int numberOfWordsToKeep, double minimumWordProbability, String userWords -space separated-, int numberOfTopics,
                //String categories I/O files for classification)
                f.NGDCalculate(5, 0.0, " ", 5, "buglist.txt", "BugTypesAssigned.txt", "SQMetricsLite.txt", "SQMAssigned.txt");
                break;
            case 4:
                //Final Preprocessing
                System.out.println("Performing Weka Filtering");
                new WekaFiltering().filterArff("data2.arff", "data3.arff");
                break;
            default:

                System.out.println("Creating .arff file for WEKA Import...Please Wait\n");
                System.out.println("Performing Natural Language Processing on data\n\n");
//                NLP Module Call
                f.runNLP(TextPreprocessor.count);

                //LDA module Call
                System.out.println("Perfoming Latent Dirichlet Allocation on data\n\n");
                f.LDAAnalysis(5, 0.5, 0.1, true, 2000); //(int numberOfTopics, alpha beta, boolean runWithDefaultAlphaValue, int niters

                //NGD module Call
                System.out.println("Calculating Normalized Google Distance and Assigning Tags\n\n");
                //(int numberOfWordsToKeep, double minimumWordProbability, String userWords -space separated-, int numberOfTopics,
                //String categories I/O files for classification)
                f.NGDCalculate(5, 0.0, " ", 5, "buglist.txt", "BugTypesAssigned.txt", "SQMetrics.txt", "SQMAssigned.txt");//(int numberOfWordsToKeep, double minimumWordProbability, String userWords -space separated-, int numberOfTopics,

                //Final Preprocessing
                System.out.println("Performing Weka Filtering");
                new WekaFiltering().filterArff("data2.arff", "data3.arff");
                break;

        }

    }
}
