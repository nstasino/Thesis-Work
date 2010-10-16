/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package json2java;

import java.util.ArrayList;

/**
 *
 * @author Nikos Stasinopoulos <nstasinopoulos@gmail.com>
 * @version     Oct 17, 2010
 * @since       1.6
 */
public class TopicList {

    private static ArrayList<Topic> topics = new ArrayList<Topic>();


    //Adder/Caller
    public static void addTopic(Topic topic) {
        topics.add(topic);
    }

    public static Topic getTopic(int index) {
        return topics.get(index);
    }



    //Setter/Getter
    public static ArrayList<Topic> getTopics() {
        return topics;
    }

    
}
