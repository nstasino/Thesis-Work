package json2java;


import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import java.io.*;
import org.htmlcleaner.XPatherException;

//unused imports
//import java.io.File;
//import java.io.IOException;
//import java.io.FilenameFilter;
//import java.io.FileFilter;
//import org.json.simple.*;
//import java.io.IOException;
//import java.util.ArrayList;
//import json2java.Ticket.Versions;
//import org.json.simple.parser.*;
//import java.lang.String;

/**
 * @author      Nikos Stasinopoulos <nstasinopoulos@gmail.com>
 * @version     2010.0720
 * @since       1.6
 */
public class Main {

    static int count = 0;
    static String[] list = new String[5000];

    /**
     * Method to traverse through all Directories
     *
     * @param dir
     *
     */
    public static void visitAllDirsAndFiles(File dir) {

        if (dir.isDirectory()) {

            File[] files = dir.listFiles();
            for (int i = 0; i < files.length; i++) {
                String fileName = files[i].getName();

                if (fileName.equals("ticket.json")) {
//                    System.out.println("----"); //eye-candy delimiter
//                    System.out.println(count);
                    String path = dir.getAbsolutePath();
                    list[count] = path;
                    count++;
                }

                visitAllDirsAndFiles(new File(dir, fileName)); //recursive call
            }
        }

    }

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


        //Scan directory for tickets
        String directoryName = "Data/tickets/"; // set to current directory
        System.out.println("Scanning dir : " + directoryName);
        File dir = new File(directoryName);
        visitAllDirsAndFiles(dir);
        System.out.println("Finished Scanning dir : " + directoryName);
        System.out.println("Tickets count : " + count);

       //Create .ARFF
        Util demo = new Util(); //create class instance
        demo.createHeader();  //append the Header to .arff

        //Flush txt files
        new FileWriter("possibleNounKeywords.txt", false);
        new FileWriter("possibleVerbKeywords.txt", false);

//        Parser p = new json2java.Parser(); //Stanford Parser Object

        //Set below ticketsToProcess = i.e. 1000 to run
        int ticketsToProcess = 2;

        for (int i = 1; i < ticketsToProcess; i++) {//count if for tickets
            System.out.println("\n[" + i + "/" + count + "]");
            File f = new File(list[i] + "/ticket.json");
            demo.preProcessFile(f); //preprocess the file
            DecodeJSON testDecode = new DecodeJSON();
            Ticket t = testDecode.decode(f);    //map JSON to the POJO
            demo.ArffCreator(t,true);     //get the data out of the POJO, true to enable Stanford Parser
//            demo.ArffCreatorForVersions(t,true); //same for the new versions, true to enable Stanford Parser
            }
double x = new Google().NGD("ταβλετr", "ipad");

System.out.println(x);
    }
}
//214 problem with diffable attributes - delete ticket from data
//428 not removing \r\n
//line 8989 15439 15441 something wrong w/ date

