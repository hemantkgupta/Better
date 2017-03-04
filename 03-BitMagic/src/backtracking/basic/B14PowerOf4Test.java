package backtracking.basic;

public class B14PowerOf4Test {

	public static void main(String[] args) {
		System.out.println(isPowerOfFour(8));
	}

	/**
	 * Power of 4 number will have only one bit set
	 * and will have even number of 0 bit after the set bit.
	 * @param n
	 * @return
	 */
	public static boolean isPowerOfFour(int n) {
		int count = 0;

		/* Check if there is only one bit set in n */
		int num = n & (n - 1);
		if (n > 0 && num == 0) {
			/* count 0 bits before set bit */
			while (n > 1) {
				n >>= 1;
				count += 1;
			}
			/* If count is even then return true else false */
			return (count % 2 == 0) ? true : false;
		}

		/*
		 * If there are more than 1 bit set then n is not a power of 4
		 */
		return false;
	}

}
