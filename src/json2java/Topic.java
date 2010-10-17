/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package json2java;

/**
 *
 * @author Nikos Stasinopoulos <nstasinopoulos@gmail.com>
 * @version     Oct 17, 2010
 * @since       1.6
 */
import java.util.ArrayList;

public class Topic {

    private ArrayList<Keyword> words;
    private String topWords;
    private String topBugType;
    private double topBugTypeScore;
    private String topSQM;
    private double topSQMScore;
    private ArrayList<String> NGDCalculatedTopics;
    private int topicNumber;
    private int numberOfWords;

    public Topic(int numberOfWords) {

        words = new ArrayList<Keyword>();
        NGDCalculatedTopics = new ArrayList<String>();

        this.topicNumber = topicNumber;
        this.numberOfWords = numberOfWords;
    }

    public String getTopWords() {
        return topWords;
    }

    public void setTopWords(String topWords) {
        this.topWords = topWords;
    }

    public boolean addKeyword(String word, double probability) {
        if (!containsWord(word) && words.size() < numberOfWords) {
            Keyword kW = new Keyword(word, probability, topicNumber);
            words.add(kW);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Keyword> getWordTopics() {
        if (words.size() == numberOfWords) {
            return words;
        } else {
            return null;
        }
    }

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

    public int getTopicNumber() {
        return topicNumber;
    }

    public boolean addSimilarNDGTopicHash(String topicHash) {
        if (!NGDCalculatedTopics.contains(topicHash)) {
            NGDCalculatedTopics.add(topicHash);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<String> getNGDSimilarTopicsHashes() {
        return NGDCalculatedTopics;
    }

    public int getNumberOfWords() {
        return numberOfWords;
    }

    public String getTopTopic() {
        return topBugType;
    }

    public void setTopTopic(String topTopic) {
        this.topBugType = topTopic;
    }

    public double getTopTopicScore() {
        return topBugTypeScore;
    }

    public void setTopTopicScore(double topTopicScore) {
        this.topBugTypeScore = topTopicScore;
    }

    public String getTopSQM() {
        return topSQM;
    }

    public void setTopSQM(String topSQM) {
        this.topSQM = topSQM;
    }

    public double getTopSQMScore() {
        return topSQMScore;
    }

    public void setTopSQMScore(double topSQMScore) {
        this.topSQMScore = topSQMScore;
    }
}
