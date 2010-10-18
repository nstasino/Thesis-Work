/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package json2java;

    /**
     * Packer Class for keywords, verbs
     *
     * @param <ArrayList>
     *
     * @author      Nikos Stasinopoulos <nstasinopoulos@gmail.com>
     * @version     2010.2509
     * @since       1.6
     */

    public class Pair<ArrayList> {

        public ArrayList keywords;
        public ArrayList verbs;

        public Pair(ArrayList nouns, ArrayList verbs) {
            this.keywords = nouns;
            this.verbs = verbs;
        }

        public ArrayList getNouns() {
            return keywords;
        }

        public ArrayList getVerbs() {
            return verbs;
        }
    }