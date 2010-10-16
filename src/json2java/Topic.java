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
    private ArrayList<String> similarNGDTopicsHashes;
    private int topicNumber;
    private int numberOfWords;

    public Topic(int numberOfWords) {

        words = new ArrayList<Keyword>();
        similarNGDTopicsHashes = new ArrayList<String>();

        this.topicNumber = topicNumber;
        this.numberOfWords = numberOfWords;
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
        if (!similarNGDTopicsHashes.contains(topicHash)) {
            similarNGDTopicsHashes.add(topicHash);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<String> getNGDSimilarTopicsHashes() {
        return similarNGDTopicsHashes;
    }

    public int getNumberOfWords() {
        return numberOfWords;
    }
}
