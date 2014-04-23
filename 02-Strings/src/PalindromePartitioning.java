public class PalindromePartitioning {

	public static void main(String[] args) {
		char str[] = "ababbbabbababa".toCharArray();
		System.out.println(minPalPartion(str));
	}

	// Returns the minimum number of cuts needed to partition a string
	// such that every part is a palindrome
	public static int minPalPartion(char[] str) {
		int n = str.length;

		/*
		 * Build the solution in bottom up manner C[i][j] =
		 * Minimum number of cuts needed for palindrome partitioning of
		 * substring str[i..j] P[i][j] = true if substring str[i..j] is
		 * palindrome, else false.Also C[i][j] is 0 if P[i][j] is true
		 */
		int[][] C = new int[n][n];
		boolean[][] P = new boolean[n][n];

		int i, j, k, L; // different looping variables

		// Every substring of length 1 is a palindrome
		for (i = 0; i < n; i++) {
			P[i][i] = true;
			C[i][i] = 0;
		}

		/*
		 * L is substring length. Build the solution in bottom up  by
		 * considering all substrings of length starting from 2 to n.
		 */
		for (L = 2; L <= n; L++) {
			// For each substring of length L in str
			for (i = 0; i < n - L + 1; i++) {
				j = i + L - 1; // Set ending index

				// If L is not 22, then we need to check two corner
				// characters and value of P[i+1][j-1]
				if (L == 2)
					P[i][j] = (str[i] == str[j]);
				else
					P[i][j] = (str[i] == str[j]) && P[i + 1][j - 1];

				// IF str[i..j] is palindrome, then C[i][j] is 0
				if (P[i][j] == true)
					C[i][j] = 0;
				else {
					// Make a cut at every possible location
					//starting from i to j, and get the min cost cut.
					C[i][j] = Integer.MAX_VALUE;
					for (k = i; k <= j - 1; k++)
						C[i][j] = Math.min(C[i][j], C[i][k] + C[k + 1][j] + 1);
				}
			}
		}

		// Return the min cut value for complete string. i.e., str[0..n-1]
		return C[0][n - 1];
	}

}