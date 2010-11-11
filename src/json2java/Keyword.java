
package json2java;

/**
 * Class describing Keyword Object, composed of  static word plus probability
 * @author Nikos Stasinopoulos <nstasinopoulos@gmail.com>
 * @version     Oct 17, 2010
 * @since       1.6
 */
public class Keyword {


	private String word;
	private double probability;
	int topicNumber;

	/**
	 *
	 * @param word
	 * @param probability
	 * @param topicNumber
	 */
	public Keyword(String word, double probability, int topicNumber) {
		this.word = word;
		this.probability = probability;
		this.topicNumber = topicNumber;
	}


	/**
	 *
	 * @return
	 */
	public String getWord() {
		return word;
	}


	/**
	 *
	 * @return
	 */
	public double getProbability() {
		return probability;
	}

}


