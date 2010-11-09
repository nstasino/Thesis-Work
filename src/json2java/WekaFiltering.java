package json2java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;
import weka.filters.unsupervised.attribute.RemoveByName;
import weka.filters.unsupervised.attribute.NumericToNominal;
import weka.filters.unsupervised.attribute.StringToNominal;
import weka.filters.unsupervised.attribute.StringToWordVector;
import weka.filters.unsupervised.attribute.Reorder;

import weka.core.converters.ArffLoader.ArffReader;
import weka.core.converters.ArffSaver;
import weka.core.Instances;

/**
 *
 * @author Nikos Stasinopoulos <nstasinopoulos@gmail.com>
 * @version     Oct 30, 2010
 * @since       1.6
 */
public class WekaFiltering {

    public void filterArff(String inputFileName, String outputFileName) throws Exception {

        //Load Arff
        BufferedReader br = new BufferedReader(new FileReader(inputFileName));
        ArffReader arff = new ArffReader(br);
        Instances data = arff.getData();
        data.setClassIndex(- 1);

//        for (int i = 0; i < data.numAttributes(); i++) {
//            System.out.println(data.attribute(i) + " " + (i + 1));
//        }
//        System.out.println("**********");

        //Remove
        Remove removeAttributes = new Remove();
        removeAttributes.setOptions(returnRemoveOptions());

        removeAttributes.setInputFormat(data);
        data = Filter.useFilter(data, removeAttributes);


//        for (int i = 0; i < data.numAttributes(); i++) {
//            System.out.println(data.attribute(i) + " " + (i + 1));
//        }
//        System.out.println("**********");

        //Numeric To Nominal
        NumericToNominal numToNom = new NumericToNominal();
        numToNom.setOptions(returnNumerictoNominalOptions());


        numToNom.setInputFormat(data);
        data = Filter.useFilter(data, numToNom);
//
//        for (int i = 0; i < data.numAttributes(); i++) {
//            System.out.println(data.attribute(i) + " " + (i + 1));
//        }
//        System.out.println("**********");

        //String To nominal
        StringToNominal strToNom = new StringToNominal();
        strToNom.setOptions(returnStringtoNominalOptions());


        strToNom.setInputFormat(data);
        data = Filter.useFilter(data, strToNom);
//
//        for (int i = 0; i < data.numAttributes(); i++) {
//            System.out.println(data.attribute(i) + " " + (i + 1));
//        }
//        System.out.println("**********");
//

//        //String wordvector*attribute to WordVector type
        StringToWordVector strToWordVector = new StringToWordVector();
        String[] o = wordToVectorOptions(13, "wv_");
        strToWordVector.setOptions(o);

        strToWordVector.setInputFormat(data);
        data = Filter.useFilter(data, strToWordVector);

//        //String title to WordVector type
        strToWordVector = new StringToWordVector();
        o = wordToVectorOptions(10, "title_");
        strToWordVector.setOptions(o);

        strToWordVector.setInputFormat(data);
        data = Filter.useFilter(data, strToWordVector);


//        //String tag to WordVector type
        strToWordVector = new StringToWordVector();
        o = wordToVectorOptions(9, "tag_");
        strToWordVector.setOptions(o);

        strToWordVector.setInputFormat(data);
        data = Filter.useFilter(data, strToWordVector);




        //RemoveByName - regexp
        RemoveByName removeByNameAttributes = new RemoveByName();
        removeByNameAttributes.setOptions(returnRemoveByNameOptions());

        removeByNameAttributes.setInputFormat(data);
        data = Filter.useFilter(data, removeByNameAttributes);



        //remove metrics for data3_no_metrics.arff
        Remove removeMetrics = new Remove();
        removeMetrics.setOptions(returnRemoveMetricsOptions());
        removeMetrics.setInputFormat(data);
        Instances data_no_metrics = Filter.useFilter(data, removeMetrics);
        data_no_metrics.setClass(data_no_metrics.attribute("bugs"));


        //remove metrics and bugs for data3_state_no_metrics_no_bugs.arff

        Remove removeMetrics2 = new Remove();
        removeMetrics2.setOptions(returnRemoveMetricsOptions());
        removeMetrics2.setInputFormat(data);
        Instances data_no_metrics_no_bugs = Filter.useFilter(data, removeMetrics2);
        Remove removeBugs2 = new Remove();
        removeBugs2.setOptions(returnRemoveBugsOptions());
        removeBugs2.setInputFormat(data_no_metrics);
        data_no_metrics_no_bugs = Filter.useFilter(data_no_metrics, removeBugs2);
//        data_no_metrics_no_bugs.setClass(data_no_metrics_no_bugs.attribute("state"));


        //Saver to .arff
Reorder reorder = new Reorder();
reorder.setOptions(returnReorderOptions());
reorder.setInputFormat(data);
data = Filter.useFilter(data, reorder);
reorder.setOptions(returnReorderOptions());
reorder.setInputFormat(data_no_metrics);
data_no_metrics = Filter.useFilter(data_no_metrics, reorder);
reorder.setOptions(returnReorderOptionsForState());
reorder.setInputFormat(data_no_metrics_no_bugs);
data_no_metrics_no_bugs = Filter.useFilter(data_no_metrics_no_bugs, reorder);

        ArffSaver saver = new ArffSaver();
        saver.setInstances(data);
        saver.setFile(new File(outputFileName));
        saver.writeBatch();
        saver.resetWriter();
        saver.setInstances(data_no_metrics);
        saver.setFile(new File("data3_no_metrics.arff"));
        saver.writeBatch();
        saver.resetWriter();
        saver.setInstances(data_no_metrics_no_bugs);
        saver.setFile(new File("data3_state_no_metrics_no_bugs.arff"));
        saver.writeBatch();
        saver.resetWriter();






        //Print Results
        //System.out.println(data);
        System.out.println("**********");
        for (int i = 0; i < data_no_metrics_no_bugs.numAttributes(); i++) {
            System.out.println(data_no_metrics_no_bugs.attribute(i) + " " + (i + 1));
        }
        System.out.println("**********");

    }

    public static String[] returnRemoveOptions() throws Exception {
        String options[];
        options = weka.core.Utils.splitOptions("-R 1,7,8,11,12,13,14,19,21,22");
        return options;
    }

    public static String[] returnRemoveByNameOptions() throws Exception {
        String options[];
        options = weka.core.Utils.splitOptions("-E (wv_|title_|tag_)[a-z0-9]{1,2}");
        return options;
    }

    public static String[] returnNumerictoNominalOptions() throws Exception {
        String options[];
        options = weka.core.Utils.splitOptions("-R 1,2,5,6,12");
        return options;
    }

    public static String[] returnStringtoNominalOptions() throws Exception {
        String options[];
        options = weka.core.Utils.splitOptions("-R 7,8,14,15");

        return options;
    }

    public static String[] wordToVectorOptions(int attributeIndex, String prefix) throws Exception {
        String[] options;

        options = weka.core.Utils.splitOptions("-R " + Integer.toString(attributeIndex) + " -P "
                + prefix + " -W 10 -prune-rate -1.0 -T -N 0 -S -stemmer weka.core.stemmers.LovinsStemmer -M 1 ");
//                + " -W 20 -prune-rate -1.0 "
//                + "-T -N 0 -stemmer weka.core.stemmers.NullStemmer -M 1 ");//good lad knows another path
        return options;
    }

    public static String[] returnRemoveMetricsOptions() throws Exception {
        String options[];
        options = weka.core.Utils.splitOptions("-R 12");
        return options;
    }

    public static String[] returnRemoveBugsOptions() throws Exception {
        String options[];
        options = weka.core.Utils.splitOptions("-R 11");
        return options;
    }

    public static String[] returnReorderOptions() throws Exception {
        String options[];
        options = weka.core.Utils.splitOptions("-R 1-10,12-last,11");
        return options;
    }
     public static String[] returnReorderOptionsForState() throws Exception {
        String options[];
        options = weka.core.Utils.splitOptions("-R 1-7,9-last,8");
        return options;
    }
}
