package json2java;

import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

//import org.json.JSONException;      // JSON library from http://www.json.org/java/
import org.json.JSONObject;

/**
 * Class calculating the NGD similarity metric for each topic == bag-of-words
 *
 * @author Nikos Stasinopoulos <nstasinopoulos@gmail.com>
 * @version     Nov 01, 2010
 * @since       1.6
 */
public class NGDCalculator {

    /**
     * Method that matches topics as bags-of-words with topic-SQM names<br>
     * Uses NGD metric to calculate scores for every possible combination and then return top topic list
     *
     * @param userAddedWord Extra word added by the user to the (topic = bag of words)
     *
     * @param listedTopics
     * @param outputFilename
     * @return
     * @throws IOException
     */
    public String[] SQMDecider(String userAddedWord, String[] listedTopics, String outputFilename) throws IOException {

        if (outputFilename.isEmpty() || outputFilename.equals("")) {
            outputFilename = "SQMAssigned.txt";
            System.out.println("Storing output to default: SQMAssigned.txt");
        }

        new FileWriter(outputFilename, false);
        String[] topTopicsList = new String[TopicList.getTopics().size()];
        int topTopicsCounter = 0;

        double score;
        for (Topic currentTopic : TopicList.getTopics()) {
            double tempScore;
            score = 1;
            System.out.println(currentTopic.getTopWords() + userAddedWord);
            for (String s : listedTopics) {
                tempScore = NGD(currentTopic.getTopWords().concat(" ").concat(userAddedWord), s);
                NGDTopicScore topicScore = new NGDTopicScore();
//                System.out.print(s);
//                System.out.println(score);
                topicScore.setScore(tempScore);
                TopicList.getTopicScore().put(listedTopics, topicScore);
//                System.out.print(TopicList.getTopicScore().values().iterator().next().getScore()+"\t\n");
//                System.out.println(TopicList.getTopicScore().keySet().iterator().next()[1]);
                if (tempScore < score && tempScore > 0) {
                    currentTopic.setTopSQMScore(tempScore);
                    currentTopic.setTopSQM(s);
                    score = tempScore;
                }
            }
            System.out.println("Top Result\t" + currentTopic.getTopSQM() + "\t" + currentTopic.getTopSQMScore());
            topTopicsList[topTopicsCounter] = currentTopic.getTopSQM();
            topTopicsCounter++;
            BufferedWriter bW = null;
            bW = new BufferedWriter(new FileWriter(outputFilename, true));
            bW.append(currentTopic.getTopSQM() + "\t" + Double.toString(currentTopic.getTopSQMScore()) + "\n");
            bW.close();
        }
        return topTopicsList;
    }

    /**
     * Method that matches topics as bags-of-words with topic-bug names<br>
     * Uses NGD metric to calculate scores for every possible combination and then return top topic list
     * 
     * @param userAddedWord Word user adds to wordvector for testing reasons. Default is null, may distort results.example "ruby"
     * 
     * @param bugtypesProvided All topics created by LDA as bags-of-words (string[])
     * 
     * @param outputFilename An output text file to save results to.
     * 
     * @return bug types assigned to each topic
     * 
     * @throws IOException
     */
    public String[] BugTypeDecider(String userAddedWord, String[] bugtypesProvided, String outputFilename) throws IOException {

        if (outputFilename.isEmpty() || outputFilename.equals("")) {//sanity check, reverting to default
            outputFilename = "BugTypesAssigned.txt";
            System.out.println("Storing output to default: BugTypesAssigned.txt");
        }

        new FileWriter(outputFilename, false);
        String[] topTopicsList = new String[TopicList.getTopics().size()];
        int topTopicsCounter = 0;

        double score;
        for (Topic currentTopic : TopicList.getTopics()) {//for each topic created by LDA
            double tempScore;
            score = 1;
            System.out.println(currentTopic.getTopWords() + userAddedWord);
            for (String s : bugtypesProvided) {//for each and every bugtype in bugtypes.txt
                tempScore = NGD(currentTopic.getTopWords().concat(" ").concat(userAddedWord), s);//NGD calculation
                NGDTopicScore topicScore = new NGDTopicScore();
//                System.out.print(s);
//                System.out.println(score);

                topicScore.setScore(tempScore);//save score in object
                TopicList.getTopicScore().put(bugtypesProvided, topicScore);//put score in topic object as well
//                System.out.print(TopicList.getTopicScore().values().iterator().next().getScore()+"\t");
//                System.out.println(TopicList.getTopicScore().keySet().iterator().next()[1]);

                if (tempScore < score && tempScore > 0) {//decides on biggest score
                    currentTopic.setTopTopicScore(tempScore);
                    currentTopic.setTopTopic(s);
                    score = tempScore;
                }

            }
            System.out.println("Top Result\t" + currentTopic.getTopTopic() + "\t" + currentTopic.getTopTopicScore());
            topTopicsList[topTopicsCounter] = currentTopic.getTopTopic();
            topTopicsCounter++;
            BufferedWriter bW = null;
            bW = new BufferedWriter(new FileWriter(outputFilename, true));
            bW.append(currentTopic.getTopTopic() + "\t" + Double.toString(currentTopic.getTopTopicScore()) + "\n");
            bW.close();
        }
        return topTopicsList;
    }

    /**
     * Calculates the NGD score for 2 string terms
     *
     * @param term1 First term
     *
     * @param term2 Second term
     *
     * @return Score as double
     */
    public double NGD(String term1, String term2) {
        Long M = 10000000000L; //802080446201L (2007)
        double freqx = logResults(term1);
        double freqy = logResults(term2);
        String xy = term1.concat("+").concat(term2);
        double freqxy = logResults(xy);
        if (freqx == Double.NEGATIVE_INFINITY || freqy == Double.NEGATIVE_INFINITY) { //deal with zero results = infinite logarithms
            return 1;//return 1 by definition
        } else {
            double num = Math.max(freqx, freqy) - freqxy;
            double den = Math.log10(M) - Math.min(freqx, freqy);

            double formula = num / den;
            return formula;
        }
    }

    private long makeQuery(String query) {

//        System.out.println("\nQuerying for " + query);
        try {
            // Convert spaces to +, etc. to make a valid URL
            query = URLEncoder.encode(query, "UTF-8");

            URL url = new URL("http://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=" + query);
            URLConnection connection = url.openConnection();
            connection.addRequestProperty("Referer", "http://stasino.com");


            // Get the JSON response
            String line;
            StringBuilder builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(//remember to remove InputStreamReader for perfomance tweak, even more for bufferedreader
                    new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }

            String response = builder.toString();
            JSONObject json = new JSONObject(response);

            if (json.getJSONObject("responseData").getJSONObject("cursor").has("estimatedResultCount")) {
                long results = Long.valueOf(json.getJSONObject("responseData").getJSONObject("cursor").getString("estimatedResultCount"));
                return results;
            } else {
                long results = 0;
                return results;
            }
        } catch (Exception e) {
            System.err.println("Something went wrong...");
            e.printStackTrace();
            long results = -1;
            return results;
        }
    }

    public double logResults(String term) {
//        System.out.println(term + "\t" + Math.log10(makeQuery(term))); //show results with log10 value
        return Math.log10(makeQuery(term));

    }

    /**
     * Parses model-final.twords file and populates topic list
     */
    public void readFile() {
        BufferedReader topicWordsBr = null;
        BufferedReader test = null;
        try {
            String sCurrentLine;
            String[] words = null;
            double[] probabilities = null;
            File file = new File("model-final.twords");
            if (!file.exists()) {
                return;
            }
            topicWordsBr = new BufferedReader(new FileReader(file));

            int topicCounter = -1;
            int wordCounter = 0;
            while ((sCurrentLine = topicWordsBr.readLine()) != null) {
                String line = sCurrentLine;

                if (!line.startsWith("\t") && topicCounter == -1) {
                    words = new String[20];
                    probabilities = new double[20];
                    topicCounter++;
                } else if (!line.startsWith("\t")) {
                    Topic topic = new Topic(20);

                    for (int i = 0; i < 20; i++) {
                        topic.addKeyword(words[i], probabilities[i]);
                    }
                    TopicList.addTopic(topic);
                    words = new String[20];
                    probabilities = new double[20];
                    topicCounter++;
                    wordCounter = 0;
                } else if (wordCounter < 20) {
                    line = line.trim();
                    words[wordCounter] = line.split(" ")[0].trim();
//                    System.out.println(wordCounter);
                    probabilities[wordCounter] = Double.parseDouble(line.split(" ")[1].trim());//if error here then model_final.twords has an empty value some place
                    wordCounter++;
                }
            }
            //Add last topic:

            Topic topic = new Topic(20);
            for (int i = 0; i < 20; i++) {
                topic.addKeyword(words[i], probabilities[i]);
            }
            TopicList.addTopic(topic);
            ///////////
//            wordSelector(5, 0.0);
            ///////////
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        } finally {
            try {
                if (topicWordsBr != null) {
                    topicWordsBr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println(e.getMessage());
            }

        }
    }

    /**
     * Method for selecting most representative words for each topic<br>
     * This can happen either by selecting a fixed number of words or by a minimum word probability or both.<br>
     * Returns a word vector representing the topic (bag-of-words)
     *
     * @param numberOfWordsToSelect Specify $ of words as topic-representative
     *
     * @param minProbability Specify min probability
     *
     * @return wordvector
     */
    public String wordSelector(int numberOfWordsToSelect, double minProbability) {

        String wordVector = "";

        if (minProbability < 0 || minProbability > 1) {//sanity check
            minProbability = 0;
            System.out.println("Minimum Probability must be between 0 and 1 -> Setting it to 0");
        }
        if (numberOfWordsToSelect < 0 || numberOfWordsToSelect > 20) {//sanity check
            numberOfWordsToSelect = 20;
            System.out.println("Number of Words must be between 0 and 20 -> Setting it to 0");
        }


        for (int ti = 0; ti < TopicList.getTopics().size(); ti++) {
            wordVector = "";
//            System.out.println("\nTopic: " + ti);
            for (int i = 0; i < numberOfWordsToSelect; i++) {
                Keyword kw = TopicList.getTopic(ti).getWordTopics().get(i);
                if (kw.getProbability() >= minProbability) {
//                    System.out.println("\t" + kw.getWord() + " " + kw.getProbability());
                    wordVector = wordVector.concat(kw.getWord()).concat(" ");
                }
            }
//            System.out.println(wordVector);
            TopicList.getTopic(ti).setTopWords(wordVector);
//            System.out.println(TopicList.getTopic(ti).getTopWords());
        }

        return wordVector;

    }

    /**
     * Reads file and return number of lines<br>
     * Useful for counting words in a text file
     *
     * @param filename File to assess
     *
     * @return number of line as int
     *
     */
    public int determineLinesNumberofFile(String filename) {
        int lines = 0;
        BufferedReader br = null;
        try {
            String sCurrentLine;
            File file = new File(filename);
            if (!file.exists()) {
                return lines;
            }
            br = new BufferedReader(new FileReader(file));
//            lines = -1;
            while ((sCurrentLine = br.readLine()) != null) {
                lines++;
            }
            return lines;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println(e.getMessage());
            }

            return lines;
        }
    }

    /**
     * Reads buglist.txt file and return a string array containing plausible bug types
     *
     * @param filename buglist.txt
     *
     * @return Bug types names as a string array
     *
     */
    public String[] BugListPopulator(String filename) {
        BufferedReader br = null;
        String[] bugs = new String[determineLinesNumberofFile(filename)];

        try {
            String sCurrentLine;
            File f = new File(filename);
            if (!f.exists()) {
                return bugs;
            }
            br = new BufferedReader(new FileReader(f));
            int lineIndex = 0;
            while ((sCurrentLine = br.readLine()) != null) {
                String line = sCurrentLine;

                line = line.trim();
                bugs[lineIndex] = line;
                lineIndex++;
            }
            return bugs;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println(e.getMessage());
            }
            return bugs;
        }
    }

    /**
     * Decides which bug type is assigned to which topic, by finding max probability<br>
     * Base on model_finale.theta model file
     *
     * @param thetas 2-dimension array with Topic - bug type probabilities
     *
     * @return 1-dimension array Topic-Max bugtype
     *
     */
    public int[] thetaDecider(double[][] thetas) {
        int[] selectedTopicIndex = new int[thetas.length];
        for (int i = 0; i < (thetas.length); i++) {
            selectedTopicIndex[i] = max(thetas[i]);
//            System.out.println(selectedTopicIndex);
        }
        return selectedTopicIndex;

    }

    /**
     * Populates thetas[][] 2d array topic - bugtype distribution
     *
     * @param filename model_final.theta
     *
     * @param nTopics Number of topics
     *
     * @return thetas[][]
     *
     */
    public double[][] thetaParser(String filename, int nTopics) {
        BufferedReader br = null;
        double[][] thetas = new double[determineLinesNumberofFile(filename)][nTopics];

        try {
            String sCurrentLine;
            File f = new File(filename);
            if (!f.exists()) {
                return thetas;
            }
            br = new BufferedReader(new FileReader(f));
            int lineIndex = 0;
            while ((sCurrentLine = br.readLine()) != null) {
                String line = sCurrentLine;
                for (int i = 0; i < nTopics; i++) {
                    thetas[lineIndex][i] = Double.parseDouble(line.split(" ")[i].trim());//base function
                }
                lineIndex++;
            }
            return thetas;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println(e.getMessage());
            }
//            String[] bugs = new String[determineLinesNumberofFile("buglist.txt")];
            return thetas;

        }
    }

    //===================================================== max
    /**
     * Auxiliary function finding INDEX of max item for a row
     *
     * @param t Array(row)
     *
     * @return index of maximum item
     */
    public int max(double[] t) {
        double maximum = t[0];   // start with the first value
        int index = 0;
        for (int i = 1; i < t.length; i++) {
            if (t[i] > maximum) {
                maximum = t[i];   // new maximum
                index = i;//index of maximum
            }
        }
        return index;
    }//end method max
}
