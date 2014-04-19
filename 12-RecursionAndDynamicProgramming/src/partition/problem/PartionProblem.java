package partition.problem;

public class PartionProblem {
	private static boolean[][] table;

	public static void main(String[] args) {

		int arr[] = { 3, 1, 1, 2, 2, 1 };

		if (partition(arr, arr.length) == true)
			System.out.println("Can be divided into two subsets of equal sum");
		else
			System.out
					.println("Can not be divided into two subsets of equal sum");

	}

	public static boolean partition(int[] arr, int n) {

		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += arr[i];

		if (sum % 2 != 0)
			return false;

		return fixedSumDP(arr, n, sum / 2);

	}
	
	//sum of the elements is not too big.
	public static boolean fixedSumDP(int[] arr, int len, int sum) {

		// table[i][j] is true if a subset of {arr[0], arr[1], ..arr[j-1]} has
		// sum equal to i, otherwise false
		table = new boolean[sum + 1][len + 1];

		// Initialize top row for corresponding to sum=0
		for (int j = 0; j <= len; j++) {
			table[0][j] = true;
		}

		// Initialize leftmost column to false (except top one) corresponding to
		// no element in array
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

		for (int i = 0; i <= sum; i++) {
			for (int j = 0; j <= len; j++) {
				System.out.print(table[i][j] + " ");
			}
			System.out.println();
		}

		return table[sum][len];
	}

}
