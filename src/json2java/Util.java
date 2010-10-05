package json2java;

import java.io.*;
//import java.util.*;
import json2java.Parser.Pair;
import org.htmlcleaner.XPatherException;

/**
 * Auxiliary -or not- functions for the project
 * Must Clear the fuzz
 *
 * @author      Nikos Stasinopoulos <nstasinopoulos@gmail.com>
 * @version     2010.0720
 * @since       1.6
 */
public class Util extends TextPreProcessing {

    Parser p = new Parser(); //Stanford Parser Object

    /**
     * Inserts a standard header using the appendHeader() function
     *
     * @see json2java.Util#appendHeader(java.lang.String)
     */
    public void createHeader() {

        appendHeader("test");
    }

    /**
     * Get values of the mapped JSON properties and write them to the .arff file
     * !! Call only for the original version of the ticket (described with versionId= -1 ) 
     * 
     * @param t Ticket object
     * @param b
     * @throws IOException
     * @throws XPatherException 
     * 
     */
    public void ArffCreator(Ticket t, Boolean b) throws IOException, XPatherException {

        t.getTicket().setVersionId(-1); //Denotes original version of the ticket

        appendToArff("" + t.getTicket().getAssigned_user_id(), "test");
//            appendToArff(" ,'" + removeAnnoyingChars(t.getTicket().getAttachments()) + "'", "test");
        appendToArff("," + t.getTicket().getAttachments_count(), "test");
        appendToArff(",'" + removeAnnoyingChars(t.getTicket().getBody()) + "'", "test");
        appendToArff(",'" + removeAnnoyingChars(t.getTicket().getBody_html()) + "'", "test");
        appendToArff("," + t.getTicket().isClosed(), "test");
        appendToArff(",'" + t.getTicket().getCreated_at() + "'", "test");
        appendToArff("," + t.getTicket().getCreator_id(), "test");
        appendToArff(",'" + removeAnnoyingChars(t.getTicket().getCreator_name()) + "'", "test");
        appendToArff(",'" + removeAnnoyingChars(t.getTicket().getLatest_body()) + "'", "test");
        appendToArff("," + removeAnnoyingChars(t.getTicket().getMilestone_due_on()), "test");
        appendToArff("," + t.getTicket().getMilestone_id(), "test");
        appendToArff(",'" + removeAnnoyingChars(t.getTicket().getMilestone_title()) + "'", "test");
        appendToArff("," + t.getTicket().getNumber(), "test");
        appendToArff(",'" + removeAnnoyingChars(t.getTicket().getOriginal_body()) + "'", "test");
        appendToArff(",'" + removeAnnoyingChars(t.getTicket().getOriginal_body_html()) + "'", "test");
        appendToArff(",'" + removeAnnoyingChars(t.getTicket().getPermalink()) + "'", "test");
        appendToArff("," + t.getTicket().getPriority(), "test");
        appendToArff("," + t.getTicket().getProject_id(), "test");
        appendToArff(",'" + removeAnnoyingChars(t.getTicket().getRaw_data()) + "'", "test");
        appendToArff(",'" + removeAnnoyingChars(t.getTicket().getState()) + "'", "test");
        appendToArff(",'" + removeAnnoyingChars(t.getTicket().getTag()) + "'", "test");
        appendToArff(",'" + removeAnnoyingChars(t.getTicket().getTitle()) + "'", "test");
        appendToArff("," + t.getTicket().getUpdated_at(), "test");
        appendToArff(",'" + removeAnnoyingChars(t.getTicket().getUrl()) + "'", "test");
        appendToArff("," + t.getTicket().getUser_id(), "test");
        appendToArff(",'" + removeAnnoyingChars(t.getTicket().getUser_name()) + "'", "test");
        appendToArff("," + t.getTicket().getVersionId() + "", "test");

        if (b == true) {
            //Stanford Parse untagged text and write to Possible{Nouns,Verbs}.txt
            Pair pair = p.parse(t);
//           System.out.println(-1);
            appendToArff(",'" + pair.nouns.toString() + "'", "test");
//                           System.out.println( pair.getNouns() );
            appendToArff(",'" + pair.verbs.toString() + "'\n", "test");
//           System.out.println(p.parse(t).nouns.toString());

        }


//            String pojoAsString = Decode.toJson(t, true);
//           System.out.println("POJO as string:\n" + pojoAsString + "\n");


    }

    /**
     * Get values of the mapped JSON properties and write them to the .arff file
     * !! Call only for the subsequent version of the ticket (described with versionId - i )
     *
     * @param t Ticket object
     * @param b
     * @throws IOException
     * @throws XPatherException
     *
     */
    public void ArffCreatorForVersions(Ticket t, Boolean b) throws IOException, XPatherException {


        int versionsNumber = t.getTicket().getVersions().size();

        for (int i = 0; i < versionsNumber; i++) { //iteration for all versions

            t.getTicket().getVersions().get(i).setVersionId(i);

            appendToArff("" + t.getTicket().getVersions().get(i).getAssigned_user_id(), "test");
//            appendToArff(" ,'" + removeAnnoyingChars(t.getTicket().getAttachments()) + "'", "test");
            appendToArff("," + t.getTicket().getVersions().get(i).getAttachments_count(), "test");
            appendToArff(",'" + removeAnnoyingChars(t.getTicket().getVersions().get(i).getBody()) + "'", "test");
            appendToArff(",'" + removeAnnoyingChars(t.getTicket().getVersions().get(i).getBody_html()) + "'", "test");
            appendToArff("," + t.getTicket().getVersions().get(i).isClosed(), "test");
            appendToArff(",'" + t.getTicket().getVersions().get(i).getCreated_at() + "'", "test");
            appendToArff("," + t.getTicket().getVersions().get(i).getCreator_id(), "test");
            appendToArff(",'" + removeAnnoyingChars(t.getTicket().getVersions().get(i).getCreator_name()) + "'", "test");
            appendToArff(",'" + removeAnnoyingChars(t.getTicket().getVersions().get(i).getLatest_body()) + "'", "test");
            appendToArff("," + removeAnnoyingChars(t.getTicket().getVersions().get(i).getMilestone_due_on()), "test");
            appendToArff("," + t.getTicket().getVersions().get(i).getMilestone_id(), "test");
            appendToArff(",'" + removeAnnoyingChars(t.getTicket().getVersions().get(i).getMilestone_title()) + "'", "test");
            appendToArff("," + t.getTicket().getVersions().get(i).getNumber(), "test");
            appendToArff(",'" + removeAnnoyingChars(t.getTicket().getVersions().get(i).getOriginal_body()) + "'", "test");
            appendToArff(",'" + removeAnnoyingChars(t.getTicket().getVersions().get(i).getOriginal_body_html()) + "'", "test");
            appendToArff(",'" + removeAnnoyingChars(t.getTicket().getVersions().get(i).getPermalink()) + "'", "test");
            appendToArff("," + t.getTicket().getVersions().get(i).getPriority(), "test");
            appendToArff("," + t.getTicket().getVersions().get(i).getProject_id(), "test");
            appendToArff(",'" + removeAnnoyingChars(t.getTicket().getVersions().get(i).getRaw_data()) + "'", "test");
            appendToArff(",'" + removeAnnoyingChars(t.getTicket().getVersions().get(i).getState()) + "'", "test");
            appendToArff(",'" + removeAnnoyingChars(t.getTicket().getVersions().get(i).getTag()) + "'", "test");
            appendToArff(",'" + removeAnnoyingChars(t.getTicket().getVersions().get(i).getTitle()) + "'", "test");
            appendToArff("," + t.getTicket().getVersions().get(i).getUpdated_at(), "test");
            appendToArff(",'" + removeAnnoyingChars(t.getTicket().getVersions().get(i).getUrl()) + "'", "test");
            appendToArff("," + t.getTicket().getVersions().get(i).getUser_id(), "test");
            appendToArff(",'" + removeAnnoyingChars(t.getTicket().getVersions().get(i).getUser_name()) + "'", "test");
            appendToArff("," + t.getTicket().getVersions().get(i).getVersionId() + "", "test");

            //Do the Stanford Parsing for each version

            if (b == true) {  //Stanford Parse untagged text and write to Possible{Nouns,Verbs}.txt
                Pair pair = p.parseVer(t.getTicket().getVersions().get(i));
//                System.out.println(i + "\n***********");
                appendToArff(",'" + pair.getNouns() + "'", "test");
//                System.out.println(t.getTicket().getVersions().get(i).getBody_html());
                System.out.println(pair.getNouns());
                appendToArff(",'" + pair.getVerbs() + "'\n", "test");
                System.out.println(pair.getVerbs());

            }


        }

    }

    /**
     * Write a line to the .arff file
     * 
     * @param stringToAppend
     * @param filename String
     */
    protected void appendToArff(String stringToAppend, String filename) {
        BufferedWriter out = null;
//stringToAppend = stringToAppend.replaceAll(",", "");

        try {
            out = new BufferedWriter(new FileWriter(filename + ".arff", true));
            out.append(stringToAppend);
//            out.append(",\"");
            out.flush();
            out.close();

        } catch (IOException e) {
            System.out.println("Could not write to file");
            System.exit(0);
        }
    }

    /**
     * Append Standard Header
     *
     * @see json2java.Util#createHeader()
     * @param filename
     */
    protected void appendHeader(String filename) {
        String header_meta = "% 1. Title: Ruby On Rails lighthouse tickets\n" + "%\n"
                + "%2. Sources:\n" + "%\n"
                + "%      (a) Creator: Nikos Stasinopoulos <nstasinopoulos@gmail.com> \n"
                + "%      (b) Donor: Rails Community\n"
                + "%      (c) Date: April, 2010\n"
                + "%\n";

        String header_relation = "@RELATION tickets\n\n";
        String header_with_attributes = "@ATTRIBUTE assigned_user_id NUMERIC\n"
                //                +"@ATTRIBUTE attachments string\n"+""
                + "@ATTRIBUTE attachments_count NUMERIC\n@ATTRIBUTE body string\n@ATTRIBUTE body_html string\n@ATTRIBUTE closed {true, false }\n@ATTRIBUTE created_at date\n@ATTRIBUTE creator_id NUMERIC\n"
                + "@ATTRIBUTE creator_name string\n@ATTRIBUTE latest_body string\n@ATTRIBUTE milestone_due_on string\n@ATTRIBUTE milestone_id NUMERIC\n@ATTRIBUTE milestone_title string\n@ATTRIBUTE number NUMERIC\n"
                + "@ATTRIBUTE original_body string\n@ATTRIBUTE original_body_html string\n@ATTRIBUTE permalink string\n@ATTRIBUTE priority NUMERIC\n@ATTRIBUTE project_id NUMERIC\n"
                + "@ATTRIBUTE raw_data string\n@ATTRIBUTE state string\n@ATTRIBUTE tag string\n@ATTRIBUTE title string\n@ATTRIBUTE updated_at date\n@ATTRIBUTE url string\n@ATTRIBUTE user_id NUMERIC\n@ATTRIBUTE user_name string\n"
                + "@ATTRIBUTE versionId NUMERIC\n" + "@ATTRIBUTE nouns string\n" + "@ATTRIBUTE verbs string\n\n\n";

        String header_data = "@DATA\n";
//        String header3 = "@ATTRIBUTE assigned-user-id NUMERIC\n@ATTRIBUTE attachments-count NUMERIC\n@ATTRIBUTE closed {true, false }\n@ATTRIBUTE created-at date\n@ATTRIBUTE creator-id NUMERIC\n@ATTRIBUTE milestone-due-on date\n@ATTRIBUTE milestone-id NUMERIC\n@ATTRIBUTE number NUMERIC\n@ATTRIBUTE permalink string\n@ATTRIBUTE priority NUMERIC\n@ATTRIBUTE project-id NUMERIC\n@ATTRIBUTE raw-data string\n"
//                + "@ATTRIBUTE state " + "\n@ATTRIBUTE tag string\n@ATTRIBUTE title string\n@ATTRIBUTE updated-at date\n@ATTRIBUTE user-id NUMERIC\n@ATTRIBUTE user-name string\n@ATTRIBUTE creator-name string\n@ATTRIBUTE url string\n" + ""
//                //"@ATTRIBUTE original-body string\n@ATTRIBUTE latest-body string\n@ATTRIBUTE original-body-html string\n\n"
//                + "\n@DATA\n";

        BufferedWriter out = null;
        try {
            FileWriter f = new FileWriter(filename + ".arff", false);
            out = new BufferedWriter(f);
            out.append(header_meta);
            out.append(header_relation);
//            out.append(header3);
            out.append(header_with_attributes);
            out.append(header_data);
            out.flush();
            out.close();

        } catch (IOException e) {
            System.out.println("Could not write to file");
            System.exit(0);
        }



    }
}