package json2java;

import java.io.*;
import java.util.*;

import edu.stanford.nlp.trees.*;
import edu.stanford.nlp.process.*;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.process.Morphology;

import org.htmlcleaner.XPatherException;

import json2java.TextPreprocessor;

/**
 * Factory class for NLP
 *
 * @author      Nikos Stasinopoulos <nstasinopoulos@gmail.com>
 * @version     2010.0820
 * @since       1.6
 */
public class NLParser {

    //Initialize Stanford Parser
    LexicalizedParser lp = new LexicalizedParser("/home/nikos/NetBeansProjects/Thesis-Work/lib/stanford-parser-2010-07-09/englishPCFG.ser.gz");
    TreebankLanguagePack tlp = new PennTreebankLanguagePack();
    GrammaticalStructureFactory gsf = tlp.grammaticalStructureFactory();
    Morphology stemmer = new Morphology();
    //Preprocessor Factory Object
    TextPreprocessor tp = new TextPreprocessor();

    /**
     * Main Parsing function returns nouns and verbs for each ticket original_body_html attrib.<br>
     *
     * @param ticket The ticket POJO to process.
     *
     * @see Ticket
     *
     * @param sentenceMaxLength Maximum sentence length for Stanford Parser.<br>
     * If exceeded SP creates fallback tree. Smaller values for speed and light memory usage
     * 
     * @return pair A Pair object containing nouns and verbs
     *
     * @see Pair
     *
     * @see edu.stanford.nlp.*
     *
     * @see org.htmlcleaner.*
     *
     * @throws IOException
     * @throws XPatherException
     */
    public Pair parse(Ticket ticket, int sentenceMaxLength) throws IOException, XPatherException {

        //Strip html tags for body_html attribute
        String html = ticket.getTicket().getBody_html();
        String text = new HTMLStripper().stripHTMLtags(html);//use of HTMLCleaner
        text = tp.removeAnnoyingChars(text);//Preprocess, reomiving unwanted chars

        try //device to handle potential errors
        {
            //System.out.println("\n\n\nSTART\n\n\n"); // print START
            BufferedWriter outNoun = null;
            outNoun = new BufferedWriter(new FileWriter("keywords.txt", true));

            //Maximum length allowed for a sentence
            //to get Stanford Parsed
            lp.setOptionFlags(new String[]{"-maxLength", Integer.toString(sentenceMaxLength), "-retainTmpSubcategories"});

            StringReader sr = new StringReader(text);
            //create sentence list w/ SP
            List<List<? extends HasWord>> sentences = new DocumentPreprocessor(tlp.getTokenizerFactory()).getSentencesFromText(sr);

            //initialize arrays
            ArrayList nouns = new ArrayList();
            ArrayList verbs = new ArrayList();
            if (sentences.size() == 0) {
                listPopulator(nouns, "denotesEmpty", "", outNoun);//handle empty descriptions
            }
            //reads sentence by sentence
            for (List<? extends HasWord> sentence : sentences) {

                Tree parse = lp.apply(sentence);
                //create syntanctic tree
                GrammaticalStructure gs = gsf.newGrammaticalStructure(parse);
                //name grammatical realtion ie. branches of the tree
                Collection tdl = gs.typedDependenciesCCprocessed(true);

                for (int i = 0; i < tdl.toArray().length; i++) {
                    TypedDependency x = (TypedDependency) tdl.toArray()[i]; //x holds current dependency

                    //Getting the relationships
                    //limits relations to desired  ie. Subj/Obj
                    if (TextPreprocessor.isDesiredRelation(x.reln().getLongName())) {

                        //Printing the relations
                        //System.out.print("Governor: " + x.gov().value() + " " + x.gov().label().tag());
                        //System.out.print("\t<<" + x.reln().getLongName() + ">>\t");
                        //System.out.println("\tDependent: " + x.dep().value() + " " + x.dep().label().tag());

                        //populate nouns list
                        if (wordChecker(x.gov().label().tag(), "NN", nouns, stemmer.stem(x.gov().value()), 3, 20)) {
                            listPopulator(nouns, stemmer.stem(x.gov().value()), x.gov().label().tag(), outNoun);
                        }
                        if (wordChecker(x.dep().label().tag(), "NN", nouns, stemmer.stem(x.dep().value()), 3, 20)) {
                            listPopulator(nouns, stemmer.stem(x.dep().value()), x.dep().label().tag(), outNoun);
                        }

                        //populate verbs list - essentially adds to the nouns list for compact reasons
                        if (wordChecker(x.gov().label().tag(), "VB", nouns, stemmer.stem(x.gov().value()), 3, 20)) {
                            listPopulator(nouns, stemmer.stem(x.gov().value()), x.gov().label().tag(), outNoun);
                        }

                        if (wordChecker(x.dep().label().tag(), "VB", nouns, stemmer.stem(x.dep().value()), 3, 20)) {
                            listPopulator(nouns, stemmer.stem(x.dep().value()), x.dep().label().tag(), outNoun);
                        }

                    }
                }
            }
            
            System.out.println(ticket.getTicket().getNumber());//show current ticket to output for validation reasons
            System.out.println("\n" + nouns + "\n");//and keywords selected

            outNoun.newLine();
            outNoun.flush();
            outNoun.close();

            return new Pair(nouns, verbs);

        } catch (Exception e) { // catch error if any
            System.err.println("ERROR in Parser: " + e.getMessage());
            e.printStackTrace();// print error message
            //EXIT PLAN
            BufferedWriter outNoun = null;
            outNoun = new BufferedWriter(new FileWriter("keywords.txt", true));
            outNoun.append("\n");//Add empty Line
            outNoun.flush();
            outNoun.close();
            return null;
        }
    }

    /**
     * Checks each keyword for uniqueness and size by calling functions from the TextProcessor Unit
     * 
     * @param member Checks for nouns or verb type
     * 
     * @param typeAbbreviation Checks for subject/ Object Grammatical Relationship
     * 
     * @param members List of previous keywords accepted
     * 
     * @param value Value of member
     * 
     * @param minLength Minimum Length allowed
     * 
     * @param maxLength Maximum Length allowed
     * 
     * @return <code>true</code> if keywords passed, or <code>false</code> if it doesn't
     * 
     * @see TextPreprocessor
     */
    public boolean wordChecker(String member, String typeAbbreviation, ArrayList members, String value, int minLength, int maxLength) {
        if (TextPreprocessor.isDesiredMember(member, typeAbbreviation)
                && TextPreprocessor.isUnique(members, value)
                && TextPreprocessor.checkMinMaxLength(value, minLength, maxLength)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Populates keywords list with new members
     * 
     * @param members Previously accepted keywords
     * 
     * @param word Keyword to be added
     * 
     * @param member
     * 
     * @param outNoun Write to keywords.txt file, also
     *
     * @throws IOException
     */
    public void listPopulator(ArrayList members, String word, String member, BufferedWriter outNoun) throws IOException { //populate nouns list
//                    word = word.toLowerCase();
        if (!word.isEmpty() && !word.equals("")) {
            members.add(word);
            outNoun.append(word + " ");
        } else {
            members.add("denotesEmpty");
            outNoun.append("denotesEmpty" + " ");
        }
    }

    /**
     * Deprecated. Base parse for different versions of each ticket
     * 
     * @param ticket
     * @return
     * @throws IOException
     * @throws XPatherException
     */
    public Pair parseVer(Ticket ticket) throws IOException, XPatherException {


        //Strip html tags for body_html attribute
        String html = ticket.getBody_html();
        String text = new HTMLStripper().stripHTMLtags(html);

        try // device to handle potential errors:
        {
//            System.out.println("\n\n\nSTART\n\n\n"); // print START


            BufferedWriter outNoun = null;
            outNoun = new BufferedWriter(new FileWriter("keywords.txt", true));
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
//                System.out.print("\n\n\n\nProcessed:\n\n");
//                parse.pennPrint();

                GrammaticalStructure gs = gsf.newGrammaticalStructure(parse);
                Collection tdl = gs.typedDependenciesCCprocessed(true);
//            System.outNoun.println(tdl);
//            System.outNoun.println();

                for (int i = 0; i < tdl.toArray().length; i++) {

                    TypedDependency x = (TypedDependency) tdl.toArray()[i];  //x holds current dependency

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
