/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package json2java;

import jgibblda.*;

/*
 *
 * @author nikos
 * @version     Oct 12, 2010
 * @since       1.6
 */
public class TagEstimator {
/**
	 *
	 * @param nTopics
	 * @param directory
	 * @param textFile
	 */
	public void runLDA(int nTopics,String directory) {

		System.out.println("Starting LDA for discovering " + nTopics + " topics in "  + directory + "keywords.txt");
		LDACmdOption option = new LDACmdOption();
		option.est = true;

		option.alpha = 0.5;
		option.beta = 0.1;

		option.K = nTopics;
		option.niters = 5;
		option.savestep = 500;
		option.dir = directory;
		option.twords = 20;
		option.dfile =  "keywords.txt";//"C:/LDA/data/newdocs100000.dat";

		System.out.println("Gibbs LDA Parameters:");
		System.out.println("alpha:\t" + option.alpha);
		System.out.println("beta:\t" + option.beta);
		System.out.println("Topics:\t" + option.K);
		System.out.println("Iterations:\t" + option.niters);
		System.out.println("savestep:\t" + option.savestep);
		System.out.println("Topic Words:\t" + option.twords);
		System.out.println("dfile:\t" + option.dfile);


		try {

			if (option.est || option.estc){
				if(option.est )
					System.out.println("Estimate the LDA model from scratch");
				else
					System.out.println("Continue to estimate the model from a previously estimated model");
				Estimator estimator = new Estimator();
				estimator.init(option);
				estimator.estimate();
			}
			else if (option.inf){
				System.out.println("Do inference for previously unseen (new) data using a previously estimated LDA model");
				Inferencer inferencer = new Inferencer();
				inferencer.init(option);

				Model newModel = inferencer.inference();

				for (int i = 0; i < newModel.phi.length; ++i){
					//phi: K * V
					System.out.println("-----------------------\ntopic" + i  + " : ");
					for (int j = 0; j < 10; ++j){
						System.out.println(inferencer.globalDict.id2word.get(j) + "\t" + newModel.phi[i][j]);
					}
				}
			}
		}
		catch (Exception e){
			System.out.println("Error in main: " + e.getMessage());
			e.printStackTrace();
			return;
		}
	}
}
