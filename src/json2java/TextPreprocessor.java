/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package json2java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

/**
 *
 * @author nikos
 * @version     Oct 5, 2010
 * @since       1.6
 */
public class TextPreprocessor {

    public TextPreprocessor() {
    }
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

    public static File preProcessFile(File f) throws IOException {
        StringBuilder contents = new StringBuilder();
        try {
            BufferedReader input = new BufferedReader(new FileReader(f));
            try {
                String line = null; //not declared within while loop
                while ((line = input.readLine()) != null) {
                    contents.append(line);
                    contents.append(System.getProperty("line.separator"));
                }
            } finally {
                input.close();
            }
        } catch (IOException ex) {
        }
        //tweaks go HERE
        //tweaks go HERE
        String newContents = contents.toString().replaceAll("assigned_user\"", "assigned_user_id\"");
        newContents = newContents.replaceAll("milestone\"", "milestone_id\"");
        newContents = newContents.replaceAll("\\p{Cntrl}", "");
        //                                newContents = newContents.replaceAll("\\\\", "*");
        if (f == null) {
            throw new IllegalArgumentException("File should not be null.");
        }
        if (!f.exists()) {
            throw new FileNotFoundException("File does not exist: " + f);
        }
        if (!f.isFile()) {
            throw new IllegalArgumentException("Should not be a directory: " + f);
        }
        if (!f.canWrite()) {
            throw new IllegalArgumentException("File cannot be written: " + f);
        }
        Writer output = new BufferedWriter(new FileWriter(f));
        try {
            //FileWriter always assumes default encoding is OK!
            output.write(newContents);
        } finally {
            output.close();
        }
        return f;
    }

    public String removeAnnoyingChars(String str) {
        if (str != null) {
            str = str.replaceAll("(\r\n|\r|\n|\n\r)", " "); //Clear Paragraph escape sequences
            str = str.replaceAll("'", " "); //Clear apostrophes
            str = str.replaceAll(",", " "); //Clear commas
            str = str.replaceAll("@", " "); //Clear @'s (optional)
            str = str.replaceAll("$", " "); //Clear $'s (optional)
            str = str.replaceAll("\\\\", "**&**"); //Clear special character backslash 4 \'s due to regexp format
            str = str.replaceAll("&amp;", "&");			//change &amp to &
            str = str.replaceAll("&lt", "<");			//change &lt; to <
            str = str.replaceAll("&gt", ">");			//change &gt; to >
//		str = str.replaceAll("<[^<>]*>"," ");		//drop anything in <>
            str = str.replaceAll("&#\\d+;", " ");			//change &#[digits]; to space
            str = str.replaceAll("&quot;", " ");			//change &quot; to space
//		str = str.replaceAll("http://[^ ]+ "," ");	//drop urls
            str = str.replaceAll("-", " ");				//drop non-alphanumeric characters
//		str = str.replaceAll("[^0-9a-zA-Z ]"," "); 	//drop non-alphanumeric characters
//		text = text.replaceAll("\\s+"," ");      		//condense spaces
            return str;
        } else {
            return str;
        }
    }

    public static boolean isDesiredRelation(String str) {
        if (str.contains("subject") || str.contains("object")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isDesiredMember(String str, String memberType) {
        if (str.contains(memberType)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isUnique(ArrayList members, String value) {
        if (members.contains(value)) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkMinMaxLength(String value, int minLength, int maxLength) {
        if (value!=null) {
            if ((value.length() <= maxLength) && (value.length() >= minLength)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
