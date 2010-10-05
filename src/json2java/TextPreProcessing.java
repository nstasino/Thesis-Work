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

/**
 *
 * @author nikos
 * @version     Oct 5, 2010
 * @since       1.6
 */
public class TextPreProcessing {

    public TextPreProcessing() {
    }

    public File preProcessFile(File f) throws IOException {
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
            str = str.replaceAll("(\r\n|\r|\n|\n\r)", ""); //Clear Paragraph escape sequences
            str = str.replaceAll("'", ""); //Clear apostrophes
            str = str.replaceAll(",", ""); //Clear commas
            str = str.replaceAll("@", ""); //Clear @'s (optional)
            str = str.replaceAll("$", ""); //Clear $'s (optional)
            str = str.replaceAll("\\\\", "**&**"); //Clear special character backslash 4 \'s due to regexp format
            return str;
        } else {
            return str;
        }
    }

}