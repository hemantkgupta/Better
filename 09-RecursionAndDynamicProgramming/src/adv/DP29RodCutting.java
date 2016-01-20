package adv;

/**
 * Given a rod of length n inches and an array of prices
 * that contains prices of all pieces of size smaller than n.
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces.
 */
public class DP29RodCutting {

	public static	int prices[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
	public static void main(String[] args) {
		System.out.println(cutRodRecur(8));
		// System.out.println(cutRodMemoized(prices, 10));
		//System.out.println(cutRodDP(prices, 10));
	}

	/*
	 * Returns the best obtainable price for a rod of length n
	 * prices[i] contains the price of length (i+1)
	 */
	public static int cutRodRecur(int n) {
		if (n <= 0)
			return 0;

		//Initialize the max with min possible value
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++)
			max = Math.max(max, prices[i] + cutRodRecur(n - i - 1));

		return max;
	}

	/*
	 * Returns the best obtainable price for a rod of length n
	 * prices[i] contains the price of length (i+1)
	 */
	public static int cutRodDP(int price[], int n) {
		int[] val = new int[n + 1];
		val[0] = 0;
		int i, j;

		// Fill the val array
		for (i = 1; i <= n; i++) {
			int max = Integer.MIN_VALUE;

			for (j = 0; j < i; j++)
				max = Math.max(max, price[j] + val[i - j - 1]);

			val[i] = max;
		}
		return val[n];
	}

}
