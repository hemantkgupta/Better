package longest.palindromic.subsequence;

public class LongestPalindromicSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(lps("BBABCBCAB".toCharArray(), 0, 8));
		System.out.println(lpsDP("BBABCBCAB".toCharArray()));
		System.out.println(longestPalindromeDP("ABCBA"));
	}

	// Returns the length of the longest palindromic subsequence
	public static int lps(char[] seq, int i, int j) {
		// Base Case 1: If there is only 1 character
		if (i == j)
			return 1;

		// Base Case 2: If there are only 2 characters and both are same
		if (seq[i] == seq[j] && i + 1 == j)
			return 2;

		// If the first and last characters match
		if (seq[i] == seq[j])
			return lps(seq, i + 1, j - 1) + 2;

		// If the first and last characters do not match
		return Math.max(lps(seq, i, j - 1), lps(seq, i + 1, j));
	}

	// Returns the length of the longest palindromic subsequence
	public static int lpsDP(char[] str) {
		int n = str.length;
		int i, j, cl;
		int[][] L = new int[n][n]; // Create a table to store results of
									// subproblems

		// Strings of length 1 are palindrome of lentgh 1
		for (i = 0; i < n; i++)
			L[i][i] = 1;

		// Build the table. Note that the lower diagonal values of table are
		// useless and not filled in the process. cl is length of substring
		// considering all substrings of length starting from 2 to n
		for (cl = 2; cl <= n; cl++) { // For each substring of length cl in str
			for (i = 0; i < n - cl + 1; i++) {
				j = i + cl - 1; // Set ending index
				if (str[i] == str[j] && cl == 2)
					L[i][j] = 2;
				else if (str[i] == str[j])
					L[i][j] = L[i + 1][j - 1] + 2;
				else
					L[i][j] = Math.max(L[i][j - 1], L[i + 1][j]);
			}
		}

		return L[0][n - 1];
	}
	
	public static String longestPalindromeDP(String s) {
		  int n = s.length();
		  int longestBegin = 0;
		 
		  // table[i][j] will be false if substring str[i..j] is not palindrome.
		  // Else table[i][j] will be true
		  boolean[][] table = new boolean[n][n];
		  
		  // All substrings of length 1 are palindromes
		  int maxLen = 1;
		  for (int i = 0; i < n; i++) {
		    table[i][i] = true;
		  }
		  
		 // check for sub-string of length 2.
		  for (int i = 0; i < n-1; i++) {
		    if (s.charAt(i) == s.charAt(i+1)) {
		      table[i][i+1] = true;
		      longestBegin = i;
		      maxLen = 2;
		    }
		  }
		  for (int len = 3; len <= n; len++) {
		    for (int i = 0; i < n-len+1; i++) {
		      int j = i+len-1;
		      if (s.charAt(i) == s.charAt(j) && table[i+1][j-1]) {
		        table[i][j] = true;
		        longestBegin = i;
		        maxLen = len;
		      }
		    }
		  }
		  return s.substring(longestBegin, longestBegin+maxLen);
		}

}
