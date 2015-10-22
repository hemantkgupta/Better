package dynprog.basic;

/**
 * Given a value N, if we want to make change for N cents, and we have
 * infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how many
 * ways can we make the change? The order of coins doesn�t matter.
 * 
*/
public class DP07MaximumWaysCoinChange {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 5 };
		System.out.println(countDP(arr, 5));
		//System.out.println(countRec(arr,3, 10));

	}

	/**
	 * To count total number solutions, we can divide all set solutions in two sets.
     * 1) Solutions that do not contain mth coin (or Sm).
     * 2) Solutions that contain at least one Sm.
	 */
	public static int countDP(int S[], int n) {
		int i, j, x, y;
		int m = S.length;

        //Needed n+1 columns
        // Rows represent n value
        // column represent coin value
		int[][] table = new int[n + 1][m];

		// Fill the entries for row 0 (case n = 0)
		for (i = 0; i < m; i++)
			table[0][i] = 1;

		// Fill rest of the table enteries in bottom up manner
		for (i = 1; i < n + 1; i++) {   // for rows
			for (j = 0; j < m; j++) {
				// Count of solutions for sum (i-S[j]) including coin at S[j]
				x = (i - S[j] >= 0) ? table[i - S[j]][j] : 0;
				// Count of solutions for sum i excluding coin at S[j]
				y = (j - 1 >= 0) ? table[i][j - 1] : 0;
				// total count
				table[i][j] = x + y;
			}
		}
		printMatrix(table);
		return table[n][m - 1];
	}
	
	// This is a recursive solution, it takes an array which represents coin
	// It also takes m where m-1 is the last index of usable coin for the solution
	// and n is the sum for which solution is needed
	// It Returns the count of ways we can sum S[0...m-1] coins to get sum n
	public static int countRec(int S[], int m, int n) {
		if (n == 0)
			return 1;
		if (n < 0)
			return 0;
		if (m <= 0 && n >= 1)
			return 0;
        int r1 = countRec(S, m - 1, n);
        System.out.println("The result for "+(m-1)+" and " + n +" is "+ r1);
        int r2 = countRec(S, m, n - S[m - 1]);
        System.out.println("The result for "+(m)+" and " + (n-S[m-1]) +" is "+ r2);
        return countRec(S, m - 1, n) + countRec(S, m, n - S[m - 1]);
	}
	
	public static void printMatrix(int[][] table){
	
    for (int i = 0; i < table.length ; i++)
    {
        for (int j = 0; j < table[0].length; j++)
        {
        	System.out.print(table[i][j]+" ");
        }
        System.out.println();
    }    
    
	}

}
