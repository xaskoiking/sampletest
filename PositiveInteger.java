
public class PositiveInteger {

	int num;

	public PositiveInteger(int num) {
		super();
		this.num = num;
	}

	/**
	 * This purpose of this method is to find if this.num is "Perfect" A number is
	 * said to be perfect if it is equal to the sum of all its factors Example: 6 =
	 * 3 + 2 + 1, hence 6 is perfect
	 * 
	 * @return boolean ("true" if the number is perfect, "false" otherwise)
	 */
	public boolean isPerfect() {
		// Declare a integer, which will sum all the factors of this.num
		int sumOfFactors = 0;

		// Loop through all the values between 0 and this.num - 1
		// This logic is to check of any number is a divisible of this.num and then sum
		// the values.
		for (int i = 1; i < this.num; i++) {
			if (this.num % i == 0) {
				sumOfFactors = sumOfFactors + i;
			}
		}

		if (this.num == sumOfFactors) {
			return true;
		}

		return false;
	}

	/**
	 * This purpose of this method is to find if this.num is "Abundant" A number is
	 * considered to be abundant if the sum of its factors (aside from the number)
	 * is greater than the number itselfs Example: 12 is abundant since 1+2+3+4+6 =
	 * 16 > 12
	 * 
	 * @return boolean ("true" if the number is Abundant, "false" otherwise)
	 */
	public boolean isAbundant() {
		// Declare a integer, which will sum all the factors of this.num
		int sumOfFactors = 0;

		// Loop through all the values between 0 and this.num - 1
		// This logic is to check of any number is a divisible of this.num and then sum
		// the values.
		for (int i = 1; i < this.num; i++) {
			if (this.num % i == 0) {
				sumOfFactors = sumOfFactors + i;
			}
		}

		if (this.num < sumOfFactors) {
			return true;
		}

		return false;
	}

	public boolean isNarcissistic() {

		// Splitting the integer: 123 --> "123"
		String intvalue = String.valueOf(this.num);

		// Storing the size of the integer value: if 123 ---> 3
		int sizeOfInt = intvalue.length();

		// Storing the reminder
		int reminder = this.num / 10;

		// Storing the modulo value
		int moduloVal = this.num % 10;

		// Storing the resultValue
		double resultValue = 0;

		for (int i = 0; i < sizeOfInt; i++) {
			resultValue = resultValue + Math.pow(moduloVal, sizeOfInt);

			moduloVal = reminder % 10;
			reminder = reminder / 10;

		}

		if ((double) this.num == resultValue) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		PositiveInteger positiveInteger = new PositiveInteger(153);
		System.out.println(positiveInteger.isNarcissistic());

	}

}
