package subset.sum;

public class SubsetSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int set[] = {3, 34, 4, 12, 5, 2};
		  int sum = 9;
		  
		  if (isSubsetSumDP(set, set.length, sum) == true)
			     System.out.println("Found a subset with given sum");
		  else
				  System.out.println("No subset with given sum");
	}
	
	 // Returns true if there is a subset of set[] with sun equal to given sum
	public static boolean isSubsetSum(int set[], int n, int sum)
	{
	   // Base Cases
	   if (sum == 0)
	     return true;
	   if (n == 0 && sum != 0)
	     return false;
	 
	   // If last element is greater than sum, then ignore it
	   if (set[n-1] > sum)
	     return isSubsetSum(set, n-1, sum);
	 
	   /* else, check if sum can be obtained by any of the following
	      (a) including the last element
	      (b) excluding the last element   */
	   return isSubsetSum(set, n-1, sum) || isSubsetSum(set, n-1, sum-set[n-1]);
	}
	
	public static boolean isSubsetSumDP(int[] arr, int len, int sum) {
		
		// table[i][j] is true if a subset of {arr[0], arr[1], ..arr[j-1]} has
		// sum equal to i, otherwise false
		boolean[][] table = new boolean[sum + 1][len + 1];

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
		return table[sum][len];
	}

}
