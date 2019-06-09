import java.util.Arrays;
import java.util.List;

public class CoatExperimentSimulator {

	int numPpl;

	public CoatExperimentSimulator(int numPpl) {
		super();
		this.numPpl = numPpl;
	}

	/**
	 * This method gets the permutation integer array as input (this is the Coat's
	 * position) We will iterate it across the sequence people's position (1 to 25)
	 * and will find out if the permutation sequence matches with the regular
	 * sequence
	 * 
	 * @param permutation
	 * @return peopleGotCoat
	 */
	public int numPplWhoGotTheirCoat(int[] permutation) {
		int peopleGotCoat = 0;

		for (int i = 0; i < permutation.length; i++) {
			if (permutation[i] == i + 1) {
				peopleGotCoat = peopleGotCoat + 1;
			}
		}
		return peopleGotCoat;
	}

	/**
	 * This method takes in number of times, we need to do the simulation If
	 * iterations = 1000, we will loop 1000 times and will call
	 * numPplWhoGotTheirCoat() method if different permutations each times.
	 * 
	 * @param iterations
	 * @return simulatedResults
	 */
	public int[] simulateCoatExperiment(int iterations) {

		// Create an array of size iterations
		int[] simulatedResults = new int[iterations];

		// Iterate and store the results of each index in the array
		for (int i = 0; i < iterations; i++) {
			int[] permutation = RandomOrderGenerator.getRandomOrder(25);
			simulatedResults[i] = numPplWhoGotTheirCoat(permutation);
		}
		return simulatedResults;
	}

	/**
	 * This method will take in the simulation results, and get the probability of
	 * the zero people getting the quote
	 * 
	 * @param results
	 * @return probOfZeroCoat(Probability of no one getting the correct coat)
	 */
	public double answerToQuestionA(int[] results) {
		double n = results.length;
		double countOfZero = 0;
		for (int i = 0; i < results.length; i++) {
			if (results[i] == 0) {
				countOfZero = countOfZero + 1;
			}
		}
		double probOfZeroCoat = countOfZero / n;
		return probOfZeroCoat;
	}

	/**
	 * This method takes in the simulated results, and then return the average
	 * number ( expected value ) of people, who will get their coats back
	 * 
	 * @param results
	 * @return
	 */
	public double answerToQuestionB(int[] results) {
		double expectedValueOfSingleSimulation = 0;
		for (int i = 0; i < results.length; i++) {
			expectedValueOfSingleSimulation = expectedValueOfSingleSimulation + results[i];
		}

		return expectedValueOfSingleSimulation / (results.length);
	}

	public static void main(String[] args) {
		// Step 0:Create a CoatExperimentSimulator with 25 people.
		CoatExperimentSimulator coatExperimentSimulator = new CoatExperimentSimulator(25);

		// Step 1: Run the simulation 100000 times
		int[] simulatedResults = coatExperimentSimulator.simulateCoatExperiment(100000);

		// Step 2: Print the probability of 0 people getting their coats
		double probOfZero = coatExperimentSimulator.answerToQuestionA(simulatedResults);
		// System.out.println("The probability of 0 people getting their coats : " +
		// probOfZero);
		System.out.println(probOfZero);

		// Step 3: Print the average number of people who get their coats back
		double avgPeopleGotCoat = coatExperimentSimulator.answerToQuestionB(simulatedResults);
		// System.out.println("The average number of people who get their hats back : "
		// + avgPeopleGotCoat);
		System.out.println(avgPeopleGotCoat);

		// Step 4: Estimated Value of e
		System.out.println("The estimate of the value of e : " + 1/probOfZero);
		System.out.println(1 / probOfZero);
	}

}
