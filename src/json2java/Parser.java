package json2java;

import java.io.*;
import java.util.*;
import edu.stanford.nlp.trees.*;
import edu.stanford.nlp.process.*;
//import edu.stanford.nlp.objectbank.TokenizerFactory;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.ling.HasWord;
import org.htmlcleaner.XPatherException;

/**
 * A class representing nouns ticket Nouns for data binding purposes
 *
 * @author      Nikos Stasinopoulos <nstasinopoulos@gmail.com>
 * @version     2010.0820
 * @since       1.6
 */
public class Parser {

    LexicalizedParser lp = new LexicalizedParser("/home/nikos/NetBeansProjects/Thesis-Work/lib/stanford-parser-2010-07-09/englishPCFG.ser.gz");
    TreebankLanguagePack tlp = new PennTreebankLanguagePack();
    GrammaticalStructureFactory gsf = tlp.grammaticalStructureFactory();

    public Pair parse(Ticket ticket) throws IOException, XPatherException {


        //Strip html tags for body_html attribute
        String html = ticket.getTicket().getBody_html();
        String text = new StripHTMLTags().stripHTMLtags(html);

        try // device to handle potential errors
        {
//            System.out.println("\n\n\nSTART\n\n\n"); // print START

            BufferedWriter outNoun = null;
            outNoun = new BufferedWriter(new FileWriter("possibleNounKeywords.txt", true));
//            outNoun.append(Integer.toString(ticket.getTicket().getNumber()));
//            outNoun.append(",");
//            outNoun.append(Integer.toString(ticket.getTicket().getVersionId()));
//            outNoun.append(",");

            BufferedWriter outVerb = null;
            outVerb = new BufferedWriter(new FileWriter("possibleVerbKeywords.txt", true));
//            outVerb.append(Integer.toString(ticket.getTicket().getNumber()));
//            outVerb.append(",");
//            outVerb.append(Integer.toString(ticket.getTicket().getVersionId()));
//            outVerb.append(",");
            lp.setOptionFlags(new String[]{"-maxLength", "150", "-retainTmpSubcategories"});//Maximum length allowed for a sentence
            //to get Stanford Parsed

            StringReader sr = new StringReader(text);
            List<List<? extends HasWord>> sentences = new DocumentPreprocessor(tlp.getTokenizerFactory()).getSentencesFromText(sr);

            ArrayList nouns = new ArrayList();
            ArrayList verbs = new ArrayList();

            for (List<? extends HasWord> sentence : sentences) {

                // print original sentence:
//                System.out.print("\n\n\n\nORIGINAL:\n");
//                for (int k = 0; k < sentence.size(); k++) {
//                    System.out.print(sentence.get(k).word() + " ");
//                }
//                System.out.println("\n\n");

                Tree parse = lp.apply(sentence);
                //                System.outNoun.println("\nPROCESSED:\n\n");

//                System.out.print("\n\n\n\nProcessed:\n\n");

                GrammaticalStructure gs = gsf.newGrammaticalStructure(parse);
                Collection tdl = gs.typedDependenciesCCprocessed(true);

                for (int i = 0; i < tdl.toArray().length; i++) {

                    TypedDependency x = (TypedDependency) tdl.toArray()[i];
//                    System.outNoun.print("Governor: " + x.gov().value() + " " + x.gov().label().tag());

                    //populate nouns list
                    if (x.gov().label().tag().contains("NN") && !nouns.contains(x.gov().value())) { //find unique nouns
                        if (x.gov().value().length() < 25) {//cut outNoun long nouns
                            nouns.add(x.gov().value());
                            outNoun.append(x.gov().value() + " ");
//                            outNoun.append(",");

                        }
                    }
                    //populate verbs list
                    if (x.gov().label().tag().contains("VB") && !verbs.contains(x.gov().value())) { //find unique nouns
                        if (x.gov().value().length() < 25) {//cut outNoun long verbs
                            verbs.add(x.gov().value());
                            outVerb.append(x.gov().value() + " ");
//                            outVerb.append(",");
                        }
                    }

                    //Getting the relationships
                    System.out.print("\t<<" + x.reln().getLongName() + ">>\t");
                    System.out.println("\tDependent: " + x.dep().value() + " " + x.dep().label().tag());

                }

            }
            outNoun.newLine();
            outNoun.flush();
            outNoun.close();
            outVerb.newLine();
            outVerb.flush();
            outVerb.close();


//            System.out.println("\n\n\nTHE END\n\n\n"); // print THE END
//            System.out.println("NOUNS");
//            System.out.println(nouns.toString());//Show nouns
//            System.out.println("VERBS");
//            System.out.println(verbs.toString());//Show verbs
            return new Pair(nouns, verbs);

        } catch (Exception e) { // catch error if any
            System.err.println("ERROR: " + e.getMessage()); // print error message
            return null;
        }

    }

    public Pair parseVer(Ticket ticket) throws IOException, XPatherException {


        //Strip html tags for body_html attribute
        String html = ticket.getBody_html();
        String text = new StripHTMLTags().stripHTMLtags(html);

        try // device to handle potential errors:
        {
//            System.out.println("\n\n\nSTART\n\n\n"); // print START


            BufferedWriter outNoun = null;
            outNoun = new BufferedWriter(new FileWriter("possibleNounKeywords.txt", true));
//            outNoun.append(Integer.toString(ticket.getNumber()));
//            outNoun.append(",");
//            outNoun.append(Integer.toString(ticket.getVersionId()));
//            outNoun.append(",");

            BufferedWriter outVerb = null;
            outVerb = new BufferedWriter(new FileWriter("possibleVerbKeywords.txt", true));
//            outVerb.append(Integer.toString(ticket.getNumber()));
//            outVerb.append(",");
//            outVerb.append(Integer.toString(ticket.getVersionId()));
            outVerb.append(",");
            lp.setOptionFlags(new String[]{"-maxLength", "150", "-retainTmpSubcategories"});

            DocumentPreprocessor dp = new DocumentPreprocessor(tlp.getTokenizerFactory());

            StringReader sr = new StringReader(text);
            List<List<? extends HasWord>> sentences = dp.getSentencesFromText(sr);

            ArrayList nouns = new ArrayList();
            ArrayList verbs = new ArrayList();
            for (List<? extends HasWord> sentence : sentences) {

                // print original sentence:
//                System.out.print("\n\n\n\nORIGINAL:\n");
//                for (int k = 0; k < sentence.size(); k++) {
//                    System.out.print(sentence.get(k).word() + " ");
//                }
//                System.out.println("\n\n");

                Tree parse = lp.apply(sentence);
                //                System.outNoun.println("\nPROCESSED:\n\n");

//                System.out.print("\n\n\n\nProcessed:\n\n");
//            parse.pennPrint();

                GrammaticalStructure gs = gsf.newGrammaticalStructure(parse);
                Collection tdl = gs.typedDependenciesCCprocessed(true);
//            System.outNoun.println(tdl);
//            System.outNoun.println();

                for (int i = 0; i < tdl.toArray().length; i++) {

                    TypedDependency x = (TypedDependency) tdl.toArray()[i];
//                    System.outNoun.print("Governor: " + x.gov().value() + " " + x.gov().label().tag());

                    if (x.gov().label().tag().contains("NN") && !nouns.contains(x.gov().value())) { //find unique nouns
                        if (x.gov().value().length() < 25) {//cut outNoun long nouns
                            nouns.add(x.gov().value());
                            outNoun.append(x.gov().value());
//                            outNoun.append(",");


                        }//populate nouns list
                    }
                    if (x.gov().label().tag().contains("VB") && !verbs.contains(x.gov().value())) { //find unique nouns
                        if (x.gov().value().length() < 25) {//cut outNoun long verbs
                            verbs.add(x.gov().value());
                            outVerb.append(x.gov().value());
//                            outVerb.append(",");
                        }//populate verbs list
                    }

                    //Getting the relationships
//                    System.outNoun.print("\t<<" + x.reln().getLongName() + ">>\t");
//                    System.outNoun.println("\tDependent: " + x.dep().value() + " " + x.dep().label().tag());

                }

            }
            outNoun.newLine();
            outNoun.flush();
            outNoun.close();
            outVerb.newLine();
            outVerb.flush();
            outVerb.close();

//            System.out.println("\n\n\nTHE END\n\n\n"); // print THE END
//            System.out.println("NOUNS");
//            System.out.println(nouns.toString());//Show nouns
//            System.out.println("VERBS");
//            System.out.println(verbs.toString());//Show verbs
            return new Pair(nouns, verbs);

        } catch (Exception e) { // catch error if any
            System.err.println("ERROR: " + e.getMessage()); // print error message

            return null;
        }
    }

}
