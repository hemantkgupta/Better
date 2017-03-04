package backtracking.basic;

public class DP20LongestPalindromicSubstring {

	public static void main(String[] args) {
		System.out.println(longestPalSubstr("BBABCBCAB".toCharArray()));
		System.out.println(longestPalindromeDP("BBABCBCAB"));
	}

	// This function prints the longest palindrome substring of str[].
	// It also returns the length of the longest palindrome
	public static int longestPalSubstr(char[] str) {
		int n = str.length; // get length of input string

		// table[i][j]== false if str[i..j] is not palindrome.
		boolean[][] table = new boolean[n][n];

		// All substrings of length 1 are palindromes
		int maxLength = 1;
		for (int i = 0; i < n; ++i)
			table[i][i] = true;

		// check for sub-string of length 2.
		int start = 0;
		for (int i = 0; i < n - 1; ++i) {
			if (str[i] == str[i + 1]) {
				table[i][i + 1] = true;
				start = i;
				maxLength = 2;
			}
		}

		//For all substrings of k = 2 to n
		for (int k = 3; k <= n; ++k) {
			// i is starting index of substring
			for (int i = 0; i < n - k + 1; ++i) {
				// j is ending index of substring
				int j = i + k - 1;

				if (table[i + 1][j - 1] && str[i] == str[j]) {
					table[i][j] = true;

					if (k > maxLength) {
						start = i;
						maxLength = k;
					}
				}
			}
		}
		return maxLength; // return length of LPS
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
		for (int i = 0; i < n - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				table[i][i + 1] = true;
				longestBegin = i;
				maxLen = 2;
			}
		}
		// check for sub-string of length more than 2.
		for (int len = 3; len <= n; len++) {

			// for each possible substring of length len
			for (int i = 0; i < n - len + 1; i++) {
				// set end index
				int j = i + len - 1;

				if (s.charAt(i) == s.charAt(j) && table[i + 1][j - 1]) {
					table[i][j] = true;
					longestBegin = i;
					maxLen = len;
				}
			}
		}
		return s.substring(longestBegin, longestBegin + maxLen);
	}

}
