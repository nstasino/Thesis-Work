package json2java;

import java.io.*;
import json2java.Pair;
import org.htmlcleaner.XPatherException;

/**
 * Factory for creating .arff from ticket Java Objects
 *
 * @author      Nikos Stasinopoulos <nstasinopoulos@gmail.com>
 * @version     20i0.0720
 * @since       i.6
 */
public class ArffCreator extends TextPreprocessor {

    /**
     * Inserts a standard header using the appendHeader() function
     *
     * @see json2java.ArffCreator#appendHeader(java.lang.String)
     */
    public void createHeader() {
        appendHeader("data2");
    }

    /**
     * Get values of the mapped JSON properties and write them to the .arff file
     * !! Call only for the original version of the ticket (described with versionId= -1 )
     *
     * @param t Ticket object
     *
     * @see Ticket
     *
     * @throws IOException
     * @throws XPatherException
     *
     */
    public void ArffCreator(Ticket t) throws IOException, XPatherException {

        t.getTicket().setVersionId(-1); // Minus One ( -1 ) denotes original version of the ticket

        appendToArff("" + t.getTicket().getNumber(), "data");
        appendToArff("," + t.getTicket().getAssigned_user_id(), "data");
//            appendToArff(" ,'" + removeAnnoyingChars(t.getTicket().getAttachments()) + "'", "data");
        appendToArff("," + t.getTicket().getAttachments_count(), "data");
//        appendToArff(",'" + removeAnnoyingChars(t.getTicket().getBody()) + "'", "data");
//        appendToArff(",'" + removeAnnoyingChars(t.getTicket().getBody_html()) + "'", "data");
        appendToArff("," + t.getTicket().isClosed(), "data");
        appendToArff(",'" + t.getTicket().getCreated_at() + "'", "data");
        appendToArff("," + t.getTicket().getCreator_id(), "data");
        appendToArff(",'" + removeAnnoyingChars(t.getTicket().getCreator_name()) + "'", "data");
//        appendToArff(",'" + removeAnnoyingChars(t.getTicket().getLadata_body()) + "'", "data");
        appendToArff(",'" + removeAnnoyingChars(t.getTicket().getMilestone_due_on()) + "'", "data");
        appendToArff("," + t.getTicket().getMilestone_id(), "data");
        appendToArff(",'" + removeAnnoyingChars(t.getTicket().getMilestone_title()) + "'", "data");
//        appendToArff(",'" + removeAnnoyingChars(t.getTicket().getOriginal_body()) + "'", "data");
//        appendToArff(",'" + removeAnnoyingChars(t.getTicket().getOriginal_body_html()) + "'", "data");
        appendToArff(",'" + removeAnnoyingChars(t.getTicket().getPermalink()) + "'", "data");
        appendToArff("," + t.getTicket().getPriority(), "data");
        appendToArff("," + t.getTicket().getProject_id(), "data");
        appendToArff(",'" + removeAnnoyingChars(t.getTicket().getRaw_data()) + "'", "data");
        appendToArff(",'" + removeAnnoyingChars(t.getTicket().getState()) + "'", "data");
        appendToArff(",'" + removeAnnoyingChars(t.getTicket().getTag()) + "'", "data");
        appendToArff(",'" + removeAnnoyingChars(t.getTicket().getTitle()) + "'", "data");
        appendToArff("," + t.getTicket().getUpdated_at(), "data");
        appendToArff(",'" + (t.getTicket().getUrl()) + "'", "data");
        appendToArff("," + t.getTicket().getUser_id(), "data");
        appendToArff(",'" + (t.getTicket().getUser_name()) + "'", "data");
        appendToArff("," + t.getTicket().getVersionId() + "\n", "data");
//        appendToArff(",'" + wordvector + "'", "data");
//        appendToArff(",'" + TopicList.getTopics().  + "'", "data");


    }

    /**
     * Write a line to the .arff file
     * 
     * @param stringToAppend String to Append (:P)
     *
     * @param filename String FileNAME to write to (eg "data"). NO extension (ie. arff)
     */
    protected void appendToArff(String stringToAppend, String filename) {
        BufferedWriter out = null;

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
     * Enhanced arff creator with bugtype assigned and SQ metric assigned<br>
     * Adds keywords, bugtype, sqm at the end of each line of the original arff file
     *
     * @param filename Input filename (data)
     *
     * @param outputFilename Output filename (data2)
     *
     * @param BugsPerTicket String vector containing bugtype per ticket
     *
     * @param SQMPerTicket String vector containing sqm per ticket
     *
     * @param appendHeader Boolean for header appending
     */
    public void enhanceArff(String filename, String outputFilename, String[] BugsPerTicket, String[] SQMPerTicket, boolean appendHeader) {

        String header_meta = "% i. Title: Ruby On Rails lighthouse tickets\n" + "%\n"
                + "%2. Sources:\n" + "%\n"
                + "%      (a) Creator: Nikos Stasinopoulos <nstasinopoulos@gmail.com> \n"
                + "%      (b) Donor: Rails Community\n"
                + "%      (c) Date: April, 20i0\n"
                + "%\n";

        String header_relation = "@RELATION tickets\n\n";
        String header_with_attributes =
                "@ATTRIBUTE number NUMERIC\n"
                + "@ATTRIBUTE assigned_user_id NUMERIC\n"
                //                + "@ATTRIBUTE attachments string\n" + ""
                + "@ATTRIBUTE attachments_count NUMERIC\n"
                //                + "@ATTRIBUTE body string\n"
                + "@ATTRIBUTE closed {true, false}\n"
                + "@ATTRIBUTE created_at date\n"
                + "@ATTRIBUTE creator_id NUMERIC\n"
                + "@ATTRIBUTE creator_name string\n"
                //                + "@ATTRIBUTE ladata_body string\n"
                + "@ATTRIBUTE milestone_due_on string\n"
                + "@ATTRIBUTE milestone_id NUMERIC\n"
                + "@ATTRIBUTE milestone_title string\n"
                //                + "@ATTRIBUTE original_body string\n"
                //                + "@ATTRIBUTE original_body_html string\n"
                + "@ATTRIBUTE permalink string\n"
                + "@ATTRIBUTE priority NUMERIC\n"
                + "@ATTRIBUTE project_id NUMERIC\n"
                + "@ATTRIBUTE raw_data string\n"
                + "@ATTRIBUTE state string\n"
                + "@ATTRIBUTE tag string\n"
                + "@ATTRIBUTE title string\n"
                + "@ATTRIBUTE updated_at date\n"
                + "@ATTRIBUTE url string\n"
                + "@ATTRIBUTE user_id NUMERIC\n"
                + "@ATTRIBUTE user_name string\n"
                + "@ATTRIBUTE versionId NUMERIC\n"
                + "@ATTRIBUTE wordvector string\n"
                + "@ATTRIBUTE bugs string\n"
                + "@ATTRIBUTE metrics string\n";


        String header_data = "\n@DATA\n";

        BufferedReader brArff = null;
        BufferedReader brkeywords = null;
        BufferedWriter bw = null;


        try {
            String sCurrentLine;
            String lineKeywords;
            File file = new File(filename);
            if (!file.exists()) {
                return;
            }
            brArff = new BufferedReader(new FileReader(file));
            brkeywords = new BufferedReader(new FileReader("keywords.txt"));
            bw = new BufferedWriter(new FileWriter(outputFilename, false));
            bw = new BufferedWriter(new FileWriter(outputFilename, true));
            brkeywords.readLine();//skip first line of keywrods.txt

            bw.append(header_meta);
            bw.append(header_relation);
            bw.append(header_with_attributes);
            bw.append(header_data);

//adding keywords, bugtype, sqm at the end of each line
            int index = 0;
            while ((sCurrentLine = brArff.readLine()) != null) {
                String line = sCurrentLine;
                if ((lineKeywords = brkeywords.readLine()) != null) {
                    String keyWordLine = lineKeywords;

                    line = line.concat(",'").concat(keyWordLine).concat("'");
                    line = line.concat(",'").concat(BugsPerTicket[index]).concat("'");
                    line = line.concat(",'").concat(SQMPerTicket[index]).concat("'");
                } else {
                    line = line.concat(",'").concat("'");
                    line = line.concat(",'").concat(BugsPerTicket[index]).concat("'");
                    line = line.concat(",'").concat(SQMPerTicket[index]).concat("'");
                }
                index++;
//                System.out.println(line);
                bw.append(line);
                bw.append("\n");
            }
            bw.flush();
            bw.close();
            brArff.close();
            brkeywords.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        } finally {
            try {
                if (brArff != null) {
                    brArff.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println(e.getMessage());
            }

        }
    }

    /**
     * Deprecated.<br>
     * Get values of the mapped JSON properties and write them to the .arff file
     * !! Call only for the original version of the ticket (described with versionId= -i )
     *
     * @param t Ticket object
     * @param b
     * @throws IOException
     * @throws XPatherException
     *
     */
    public void ArffCreator(Ticket t, String wordvector) throws IOException, XPatherException {

        t.getTicket().setVersionId(-1); //Denotes original version of the ticket

        appendToArff("" + t.getTicket().getNumber(), "data");
        appendToArff("," + t.getTicket().getAssigned_user_id(), "data");
//            appendToArff(" ,'" + removeAnnoyingChars(t.getTicket().getAttachments()) + "'", "data");
        appendToArff("," + t.getTicket().getAttachments_count(), "data");
//        appendToArff(",'" + removeAnnoyingChars(t.getTicket().getBody()) + "'", "data");
//        appendToArff(",'" + removeAnnoyingChars(t.getTicket().getBody_html()) + "'", "data");
        appendToArff("," + t.getTicket().isClosed(), "data");
        appendToArff(",'" + t.getTicket().getCreated_at() + "'", "data");
        appendToArff("," + t.getTicket().getCreator_id(), "data");
        appendToArff(",'" + removeAnnoyingChars(t.getTicket().getCreator_name()) + "'", "data");
//        appendToArff(",'" + removeAnnoyingChars(t.getTicket().getLadata_body()) + "'", "data");
        appendToArff("," + removeAnnoyingChars(t.getTicket().getMilestone_due_on()), "data");
        appendToArff("," + t.getTicket().getMilestone_id(), "data");
        appendToArff(",'" + removeAnnoyingChars(t.getTicket().getMilestone_title()) + "'", "data");
//        appendToArff(",'" + removeAnnoyingChars(t.getTicket().getOriginal_body()) + "'", "data");
//        appendToArff(",'" + removeAnnoyingChars(t.getTicket().getOriginal_body_html()) + "'", "data");
        appendToArff(",'" + removeAnnoyingChars(t.getTicket().getPermalink()) + "'", "data");
        appendToArff("," + t.getTicket().getPriority(), "data");
        appendToArff("," + t.getTicket().getProject_id(), "data");
        appendToArff(",'" + removeAnnoyingChars(t.getTicket().getRaw_data()) + "'", "data");
        appendToArff(",'" + removeAnnoyingChars(t.getTicket().getState()) + "'", "data");
        appendToArff(",'" + removeAnnoyingChars(t.getTicket().getTag()) + "'", "data");
        appendToArff(",'" + removeAnnoyingChars(t.getTicket().getTitle()) + "'", "data");
        appendToArff("," + t.getTicket().getUpdated_at(), "data");
        appendToArff(",'" + (t.getTicket().getUrl()) + "'", "data");
        appendToArff("," + t.getTicket().getUser_id(), "data");
        appendToArff(",'" + (t.getTicket().getUser_name()) + "'", "data");
        appendToArff("," + t.getTicket().getVersionId() + "", "data");
        appendToArff(",'" + wordvector + "'", "data");
//        appendToArff(",'" + TopicList.getTopics().  + "'", "data");

        //Stanford Parse untagged text and write to Possible{Nouns,Verbs}.txt
//        Pair pair = p.parse(t, 200);

//        appendToArff(",'" + pair.keywords.toString() + "'", "data");
//        System.out.println(pair.getNouns());
//        appendToArff(",'" + pair.verbs.toString() + "'\n", "data");
//        System.out.println(p.parse(t).keywords.toString());







//            String pojoAsString = Decode.toJson(t, true);
//           System.out.println("POJO as string:\n" + pojoAsString + "\n");


    }

    /**
     * Deprecated.<br>
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

            appendToArff("" + t.getTicket().getVersions().get(i).getAssigned_user_id(), "data");
//            appendToArff(" ,'" + removeAnnoyingChars(t.getTicket().getAttachments()) + "'", "data");
            appendToArff("," + t.getTicket().getVersions().get(i).getAttachments_count(), "data");
            appendToArff(",'" + removeAnnoyingChars(t.getTicket().getVersions().get(i).getBody()) + "'", "data");
            appendToArff(",'" + removeAnnoyingChars(t.getTicket().getVersions().get(i).getBody_html()) + "'", "data");
            appendToArff("," + t.getTicket().getVersions().get(i).isClosed(), "data");
            appendToArff(",'" + t.getTicket().getVersions().get(i).getCreated_at() + "'", "data");
            appendToArff("," + t.getTicket().getVersions().get(i).getCreator_id(), "data");
            appendToArff(",'" + removeAnnoyingChars(t.getTicket().getVersions().get(i).getCreator_name()) + "'", "data");
//            appendToArff(",'" + removeAnnoyingChars(t.getTicket().getVersions().get(i).getLadata_body()) + "'", "data");
            appendToArff("," + removeAnnoyingChars(t.getTicket().getVersions().get(i).getMilestone_due_on()), "data");
            appendToArff("," + t.getTicket().getVersions().get(i).getMilestone_id(), "data");
            appendToArff(",'" + removeAnnoyingChars(t.getTicket().getVersions().get(i).getMilestone_title()) + "'", "data");
            appendToArff("," + t.getTicket().getVersions().get(i).getNumber(), "data");
            appendToArff(",'" + removeAnnoyingChars(t.getTicket().getVersions().get(i).getOriginal_body()) + "'", "data");
            appendToArff(",'" + removeAnnoyingChars(t.getTicket().getVersions().get(i).getOriginal_body_html()) + "'", "data");
            appendToArff(",'" + removeAnnoyingChars(t.getTicket().getVersions().get(i).getPermalink()) + "'", "data");
            appendToArff("," + t.getTicket().getVersions().get(i).getPriority(), "data");
            appendToArff("," + t.getTicket().getVersions().get(i).getProject_id(), "data");
            appendToArff(",'" + removeAnnoyingChars(t.getTicket().getVersions().get(i).getRaw_data()) + "'", "data");
            appendToArff(",'" + removeAnnoyingChars(t.getTicket().getVersions().get(i).getState()) + "'", "data");
            appendToArff(",'" + removeAnnoyingChars(t.getTicket().getVersions().get(i).getTag()) + "'", "data");
            appendToArff(",'" + removeAnnoyingChars(t.getTicket().getVersions().get(i).getTitle()) + "'", "data");
            appendToArff("," + t.getTicket().getVersions().get(i).getUpdated_at(), "data");
            appendToArff(",'" + removeAnnoyingChars(t.getTicket().getVersions().get(i).getUrl()) + "'", "data");
            appendToArff("," + t.getTicket().getVersions().get(i).getUser_id(), "data");
            appendToArff(",'" + removeAnnoyingChars(t.getTicket().getVersions().get(i).getUser_name()) + "'", "data");
            appendToArff("," + t.getTicket().getVersions().get(i).getVersionId() + "", "data");

            //Do the Stanford Parsing for each version

//            if (b == true) {  //Stanford Parse untagged text and write to Possible{Nouns,Verbs}.txt
//                Pair pair = p.parseVer(t.getTicket().getVersions().get(i));
////                System.out.println(i + "\n***********");
//                appendToArff(",'" + pair.getNouns() + "'", "data");
////                System.out.println(t.getTicket().getVersions().get(i).getBody_html());
//                System.out.println(pair.getNouns());
//                appendToArff(",'" + pair.getVerbs() + "'\n", "data");
//                System.out.println(pair.getVerbs());
//
//            }


        }

    }
        /**
     *Deprecated.
     * Append Standard Header
     *
     * @see json2java.ArffCreator#createHeader()
     * @param filename Filename to append to the file (ie."data")
     */
    protected void appendHeader(String filename) {
        String header_meta = "% i. Title: Ruby On Rails lighthouse tickets\n" + "%\n"
                + "%2. Sources:\n" + "%\n"
                + "%      (a) Creator: Nikos Stasinopoulos <nstasinopoulos@gmail.com> \n"
                + "%      (b) Donor: Rails Community\n"
                + "%      (c) Date: April, 20i0\n"
                + "%\n";

        String header_relation = "@RELATION tickets\n\n";
        String header_with_attributes =
                "@ATTRIBUTE number NUMERIC\n"
                + "@ATTRIBUTE assigned_user_id NUMERIC\n"
                //                + "@ATTRIBUTE attachments string\n" + ""
                + "@ATTRIBUTE attachments_count NUMERIC\n"
                //                + "@ATTRIBUTE body string\n"
                + "@ATTRIBUTE closed {true, false}\n"
                + "@ATTRIBUTE created_at date\n"
                + "@ATTRIBUTE creator_id NUMERIC\n"
                + "@ATTRIBUTE creator_name string\n"
                //                + "@ATTRIBUTE ladata_body string\n"
                + "@ATTRIBUTE milestone_due_on string\n"
                + "@ATTRIBUTE milestone_id NUMERIC\n"
                + "@ATTRIBUTE milestone_title string\n"
                //                + "@ATTRIBUTE original_body string\n"
                //                + "@ATTRIBUTE original_body_html string\n"
                + "@ATTRIBUTE permalink string\n"
                + "@ATTRIBUTE priority NUMERIC\n"
                + "@ATTRIBUTE project_id NUMERIC\n"
                + "@ATTRIBUTE raw_data string\n"
                + "@ATTRIBUTE state string\n"
                + "@ATTRIBUTE tag string\n"
                + "@ATTRIBUTE title string\n"
                + "@ATTRIBUTE updated_at date\n"
                + "@ATTRIBUTE url string\n"
                + "@ATTRIBUTE user_id NUMERIC\n"
                + "@ATTRIBUTE user_name string\n"
                + "@ATTRIBUTE versionId NUMERIC\n"
                + "@ATTRIBUTE wordvector string\n"
                + "@ATTRIBUTE bugs string\n"
                + "@ATTRIBUTE metrics string\n";


        String header_data = "\n@DATA\n";

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
