package json2java;

import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
//import java.lang.Math;

//import org.json.JSONException;      // JSON library from http://www.json.org/java/
import org.json.JSONObject;

public class NGDCalculator {

    
    public double NGD(String term1, String term2) {
        Long M = 10000000000L; //802080446201L (2007)
        double freqx = logResults(term1);
        double freqy = logResults(term2);
        String xy = term1.concat("+").concat(term2);
        double freqxy = logResults(xy);
        if (freqx == Double.NEGATIVE_INFINITY || freqy == Double.NEGATIVE_INFINITY) { //deal with zero results = infinite logarithms
            return 100000;
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
        System.out.println(term + "\t" + Math.log10(makeQuery(term))); //show results with log10 value
        return Math.log10(makeQuery(term));

    }

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
                    probabilities[wordCounter] = Double.parseDouble(line.split(" ")[1].trim());
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

    public String wordSelector(int numberOfWordsToSelect, double minProbability) {

        String wordVector = "";

        if (minProbability < 0 || minProbability > 1) {
            minProbability = 0;
            System.out.println("Minimum Probability must be between 0 and 1 -> Setting it to 0");
        }
        if (numberOfWordsToSelect < 0 || numberOfWordsToSelect > 20) {
            numberOfWordsToSelect = 20;
            System.out.println("Number of Words must be between 0 and 20 -> Setting it to 0");
        }


        for (int ti = 0; ti < TopicList.getTopics().size(); ti++) {
            wordVector = "";
            System.out.println("\nTopic: " + ti);
            for (int i = 0; i < numberOfWordsToSelect; i++) {
                Keyword kw = TopicList.getTopic(ti).getWordTopics().get(i);
                if (kw.getProbability() >= minProbability) {
                    System.out.println("\t" + kw.getWord() + " " + kw.getProbability());
                    wordVector = wordVector.concat(kw.getWord()).concat(" ");
                }
            }
            System.out.println(wordVector);
        }
        return wordVector;

    }

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

    public void BugListPopulator() {
        BufferedReader br = null;

        try {
            String sCurrentLine;
            String[] bugs = new String[determineLinesNumberofFile("buglist.txt")];
            File f = new File("buglist.txt");
            if (!f.exists()) {
                return;
            }
            br = new BufferedReader(new FileReader(f));
            int lineIndex = 0;
            while ((sCurrentLine = br.readLine()) != null) {
                String line = sCurrentLine;

                line = line.trim();
                bugs[lineIndex] = line;
                lineIndex++;
//                System.out.println(line);
            }
//            System.out.println("Bugs read " + bugs[15]);

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
        }

    }
}
