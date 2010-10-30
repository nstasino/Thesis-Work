/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package json2java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;
import weka.filters.unsupervised.attribute.NumericToNominal;
import weka.filters.unsupervised.attribute.StringToNominal;
import weka.filters.unsupervised.attribute.StringToWordVector;

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
//
//        for (int i = 0; i < data.numAttributes(); i++) {
//            System.out.println(data.attribute(i) + " " + (i + 1));
//        }
//        System.out.println("**********");

        //Print Results
//        System.out.println(data);

        //Save Results
        ArffSaver saver = new ArffSaver();
        saver.setInstances(data);
        saver.setFile(new File(outputFileName));
        saver.writeBatch();


    }

    public static String[] returnRemoveOptions() throws Exception {
        String options[];
        options = weka.core.Utils.splitOptions("-R 1,7,8,11,12,13,14,19,21,22");
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

        options = weka.core.Utils.splitOptions("-R " + Integer.toString(attributeIndex) + " -P " + prefix
                + " -W 3 -prune-rate -1.0 "
                + "-T -N 0 -stemmer weka.core.stemmers.NullStemmer -M 1 ");//good lad knows another path
        return options;
    }
}
