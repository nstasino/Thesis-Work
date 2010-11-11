
package json2java;

/**
 *
 * @author Nikos Stasinopoulos <nstasinopoulos@gmail.com>
 * @version     Oct 17, 2010
 * @since       1.6
 */
import java.util.ArrayList;

/**
 * Class Topic describes topic object containing bag-of-keywords, topBugType and score, topSQM and score
 *
 * @author Nikos Stasinopoulos <nstasinopoulos@gmail.com>
 */
public class Topic {

    private ArrayList<Keyword> words;
    private String topWords;
    private String topBugType;
    private double topBugTypeScore;
    private String topSQM;
    private double topSQMScore;
    private ArrayList<String> NGDCalculatedTopics;
    private int topicNumber;//topic id
    private int numberOfWords;

    /**
     * Constructor method for Topic with specified amount of words
     * @param numberOfWords
     */
    public Topic(int numberOfWords) {

        words = new ArrayList<Keyword>();
        NGDCalculatedTopics = new ArrayList<String>();

        this.topicNumber = topicNumber;
        this.numberOfWords = numberOfWords;
    }

    /**
     *
     * @return
     */
    public String getTopWords() {
        return topWords;
    }

    /**
     *
     * @param topWords
     */
    public void setTopWords(String topWords) {
        this.topWords = topWords;
    }

    /**
     * Adds a keyword and its probability to topic
     *
     * @param word A keyword
     *
     * @param probability Keyword prob.
     *
     * @return boolean for testing reasons
     *
     */
    public boolean addKeyword(String word, double probability) {
        if (!containsWord(word) && words.size() < numberOfWords) {
            Keyword kW = new Keyword(word, probability, topicNumber);
            words.add(kW);
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @return
     */
    public ArrayList<Keyword> getWordTopics() {
        if (words.size() == numberOfWords) {
            return words;
        } else {
            return null;
        }
    }

    /**
     * Checks if word is contained recursively
     *
     * @param word A keyword
     *
     * @return Boolean
     *
     */
    public boolean containsWord(String word) {
        boolean containsWord = false;
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).getWord().equalsIgnoreCase(word)) {
                containsWord = true;
                break;
            }
        }
        return containsWord;
    }

    /**
     *
     * @return
     */
    public int getTopicNumber() {
        return topicNumber;
    }

    /**
     *
     * @param topicHash
     * @return
     */
    public boolean addSimilarNDGTopicHash(String topicHash) {
        if (!NGDCalculatedTopics.contains(topicHash)) {
            NGDCalculatedTopics.add(topicHash);
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @return
     */
    public ArrayList<String> getNGDSimilarTopicsHashes() {
        return NGDCalculatedTopics;
    }

    /**
     *
     * @return
     */
    public int getNumberOfWords() {
        return numberOfWords;
    }

    /**
     *
     * @return
     */
    public String getTopTopic() {
        return topBugType;
    }

    /**
     *
     * @param topTopic
     */
    public void setTopTopic(String topTopic) {
        this.topBugType = topTopic;
    }

    /**
     *
     * @return
     */
    public double getTopTopicScore() {
        return topBugTypeScore;
    }

    /**
     *
     * @param topTopicScore
     */
    public void setTopTopicScore(double topTopicScore) {
        this.topBugTypeScore = topTopicScore;
    }

    /**
     *
     * @return
     */
    public String getTopSQM() {
        return topSQM;
    }

    /**
     *
     * @param topSQM
     */
    public void setTopSQM(String topSQM) {
        this.topSQM = topSQM;
    }

    /**
     *
     * @return
     */
    public double getTopSQMScore() {
        return topSQMScore;
    }

    /**
     *
     * @param topSQMScore
     */
    public void setTopSQMScore(double topSQMScore) {
        this.topSQMScore = topSQMScore;
    }
}
