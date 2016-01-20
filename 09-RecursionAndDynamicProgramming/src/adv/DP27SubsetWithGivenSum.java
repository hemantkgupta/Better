package adv;

public class DP27SubsetWithGivenSum {

	public static void main(String[] args) {
		int set[] = { 3, 34, 4, 12, 5, 2 };
		int sum = 9;

		if (isSubsetSumDP(set, set.length, sum) == true)
			System.out.println("Found a subset with given sum");
		else
			System.out.println("No subset with given sum");
	}

	// Returns true if  subset has sum equal to given sum
	public static boolean isSubsetSum(int set[], int n, int sum) {
		if (sum == 0)
			return true;
		if (n == 0 && sum != 0)
			return false;

		if (set[n - 1] > sum)
			return isSubsetSum(set, n - 1, sum);

		return isSubsetSum(set, n - 1, sum)
				|| isSubsetSum(set, n - 1, sum - set[n - 1]);
	}

	// Returns true if  subset has sum equal to given sum
	public static boolean isSubsetSumDP(int[] arr, int len, int sum) {

		// table[i][j] is true if a subset of
		// {prices[0], prices[1], ..prices[j-1]} has sum i
		boolean[][] table = new boolean[sum + 1][len + 1];

		// Initialize top row for corresponding to sum=0
		for (int j = 0; j <= len; j++) {
			table[0][j] = true;
		}

		// Initialize leftmost column to false 
		for (int i = 1; i <= sum; i++) {
			table[i][0] = false;
		}
		// Fill the partition table in bottom up manner
		for (int i = 1; i <= sum; i++) {
			for (int j = 1; j <= len; j++) {

				table[i][j] = table[i][j - 1];
				if (i >= arr[j - 1]) {
					table[i][j] = table[i][j - 1]
							|| table[i - arr[j - 1]][j - 1];
				}
			}
		}
		return table[sum][len];
	}

}
