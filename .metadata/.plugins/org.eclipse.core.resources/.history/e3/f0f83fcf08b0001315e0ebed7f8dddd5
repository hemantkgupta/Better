public class MultipleOf3Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isMultipleOf3(9));
	}

	/* Fnction to check if n is a multiple of 3 */
	public static boolean isMultipleOf3(int n) {
		int odd_count = 0;
		int even_count = 0;

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
			int tmp = n & 1;
			if (tmp == 1) {
				odd_count++;
			}
			n = n >> 1;
			/*
			 * If even bit is set then increment even counter
			 */
			if (tmp == 1) {
				even_count++;
			}
			n = n >> 1;
		}
		return isMultipleOf3(Math.abs(odd_count - even_count));
	}

}
