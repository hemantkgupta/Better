public class Test {
	private static boolean[][] table;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 3, 1, 1, 2, 2, 1, };
		fixedSumDP(arr, 6, 5);
		//System.out.println(fixedSumRec(arr, arr.length, 5));
	}

	public static boolean fixedSumRec(int[] arr, int len, int sum) {

		// No solution if sum is not zero and all elements are tested
		if (len == 0 && sum != 0)
			return false;
		// Solution find if reached sum==0 irrespective of len
		if (sum == 0)
			return true;
		// If last element is greater than sum to it can not be part of the solution
		if (arr[len - 1] > sum) {
			return fixedSumRec(arr, len - 1, sum);
		}
		
		//Recursively test solution including the last element and not including the last element
		return fixedSumRec(arr, len - 1, sum - arr[len - 1])
				|| fixedSumRec(arr, len - 1, sum);
	}

	public static void fixedSumDP(int[] arr, int len, int sum) {

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
				if (i >= arr[j - 1] ) {
					table[i][j] = table[i][j - 1] || table[i - arr[j - 1]][j - 1];					
				}			
			}
		}

		for (int i = 0; i <= sum; i++) {
			for (int j = 0; j <= len; j++) {
				System.out.print(table[i][j] + " ");
			}
			System.out.println();
		}
	}

}
