package basic;

/**
 * Given an array prices[0 … n-1] containing n positive integers,
 * a subsequence of prices[] is called Bitonic if it is first increasing, then decreasing.
 * A sequence, sorted in increasing order is considered Bitonic with the decreasing part as empty.
 * Similarly, decreasing order sequence is considered Bitonic with the increasing part as empty.
 */

public class DP18LongestBitonicSubsequence {

	public static void main(String[] args) {
		int arr[] = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
		System.out.println(lbs(arr));
	}

	// lbs() returns the length of the Longest Bitonic Subsequence

	/**
	 * We need to construct two arrays lis[] and lds[] using DP solution of LIS problem.
	 * lis[i] stores the length of the Longest Increasing subsequence ending with prices[i].
	 * lds[i] stores the length of the longest Decreasing subsequence starting from prices[i].
	 * Finally, we need to return the max value of (lis[i] + lds[i] – 1) where i is from 0 to n-1.
	 * @param arr
	 * @return
	 */
	public static int lbs(int arr[]) {
		int n = arr.length;
		int i, j;
		
		int[] lis = new int[n];
		int[] lds = new int[n];
		for (i = 0; i < n; i++){
			lis[i] = 1;
			lds[i] = 1;
		}

		/* Compute LIS values from left to right */
		for (i = 1; i < n; i++)
			for (j = 0; j < i; j++)
				if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
					lis[i] = lis[j] + 1;

		/* Compute LDS values from right to left */
		for (i = n - 2; i >= 0; i--)
			for (j = n - 1; j > i; j--)
				if (arr[i] > arr[j] && lds[i] < lds[j] + 1)
					lds[i] = lds[j] + 1;

		/* Return the maximum value of lis[i] + lds[i] - 1 */
		int max = lis[0] + lds[0] - 1;
		for (i = 1; i < n; i++)
			if (lis[i] + lds[i] - 1 > max)
				max = lis[i] + lds[i] - 1;
		return max;
	}

}
