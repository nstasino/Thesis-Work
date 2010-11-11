
package json2java;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class TopicList contains the full arrays of topics created by LDA modeling
 *
 * @author Nikos Stasinopoulos <nstasinopoulos@gmail.com>
 * @version     Oct 17, 2010
 * @since       1.6
 */
public class TopicList {

    private static ArrayList<Topic> topics = new ArrayList<Topic>();
    private static HashMap<String[], NGDTopicScore> topicScore = new HashMap<String[], NGDTopicScore>();


    //Adder/Caller
    /**
     * 
     * @param topic
     */
    public static void addTopic(Topic topic) {
        topics.add(topic);
    }

    /**
     *
     * @param index
     * @return
     */
    public static Topic getTopic(int index) {
        return topics.get(index);
    }

    //Setter/Getter
    /**
     *
     * @return
     */
    public static ArrayList<Topic> getTopics() {
        return topics;
    }

    /**
     *
     * @return
     */
    public static HashMap<String[], NGDTopicScore> getTopicScore() {
        return topicScore;
    }

    /**
     *
     * @param topicScore
     */
    public static void setTopicScore(HashMap<String[], NGDTopicScore> topicScore) {
        TopicList.topicScore = topicScore;
    }

 
}
