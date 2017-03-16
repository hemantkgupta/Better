package backtracking.basic;

public class B05MultipleOf3Test {

	public static void main(String[] args) {
		System.out.println(isMultipleOf3(72));
	}

	/* Function to check if n is a multiple of 3 */
	public static boolean isMultipleOf3(int n) {
		int oddCount = 0;
		int evenCount = 0;

		if (n < 0)
			n = -n;
		if (n == 0)
			return true;
		if (n == 1)
			return false;

		while (n > 0) {
			/*
			 * If odd bit is set then increment odd counter
			 */
			if ((n & 1) == 1)
				oddCount++;
			n = n >> 1;

			/*
			 * If even bit is set then increment even counter
			 */
			if ((n & 1) == 1)
				evenCount++;
			n = n >> 1;
		}

		return isMultipleOf3(Math.abs(oddCount - evenCount));
	}

}
