package rod.cutting.problem;

public class RodCutting {

	public static void main(String[] args) {
		int arr[] = { 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };
		System.out.println(cutRodRecur(arr, 10));
		// System.out.println(cutRodMemoized(arr, 10));
		System.out.println(cutRodDP(arr, 10));
	}

	/*
	 * Returns the best obtainable price for a rod of length n
	 * and price[] as prices of different pieces
	 */
	public static int cutRodRecur(int price[], int n) {
		if (n <= 0)
			return 0;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++)
			max = Math.max(max, price[i] + cutRodRecur(price, n - i - 1));

		return max;
	}

	/*
	 * Returns the best obtainable price for a rod of length n
	 * and price[] as prices of different pieces
	 */
	public static int cutRodDP(int price[], int n) {
		int[] val = new int[n + 1];
		val[0] = 0;
		int i, j;

		
		for (i = 1; i <= n; i++) {
			int max = Integer.MIN_VALUE;
			for (j = 0; j < i; j++)
				max = Math.max(max, price[j] + val[i - j - 1]);
			val[i] = max;
		}
		return val[n];
	}

	public static int cutRodMemoized(int[] arr, int n) {
		int[] r = new int[n];
		for (int i = 0; i < n; i++) {
			r[i] = Integer.MIN_VALUE;
		}

		return cutRodMemoizedAux(arr, n, r);
	}

	private static int cutRodMemoizedAux(int[] arr, int n, int[] r) {

		int q = 0;
		if (r[n - 1] >= 0) {
			return r[n - 1];
		}
		if (n == 0) {
			q = 0;
		} else {
			q = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				q = Math.max(q, arr[i] + cutRodMemoizedAux(arr, n - i, r));
			}
		}
		r[n - 1] = q;
		return q;
	}

}
