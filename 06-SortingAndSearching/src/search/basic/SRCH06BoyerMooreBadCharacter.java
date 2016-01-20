package search.basic;

/**
 * The character of the text which doesn’t match with the current character of pattern is called the Bad Character.
 * Whenever a character doesn’t match, we slide the pattern in such a way
 * that aligns the bad character with the last occurrence of it in pattern.
 * We pre-process the pattern and store the last occurrence of every possible character
 * in an array of size equal to alphabet size.
 * If the character is not present at all, then it may result in a shift by m (length of pattern).
 * Therefore, the bad character heuristic takes O(n/m) time in the best case.
 */
public class SRCH06BoyerMooreBadCharacter {
	private static final int NO_OF_CHARS = 256;

	public static void main(String[] args) {

		char[] txt = "AABAACAADAABAAABAA".toCharArray();
		char[] pat = "AABA".toCharArray();
		search(pat, txt);
	}

	// The pre-processing function for Boyer Moore's bad character heuristic
	// It build from pattern
	public static void badCharHeuristic(char[] pattern, int size, int badchar[]) {
		int i;

		// Initialize all occurrences as -1
		for (i = 0; i < NO_OF_CHARS; i++)
			badchar[i] = -1;

		// Fill the actual value of last occurrence of a character in pattern
		for (i = 0; i < size; i++)
			badchar[(int) pattern[i]] = i;
	}

	/*
	 * A pattern searching function that uses Bad Character Heuristic of Boyer
	 * Moore Algorithm
	 */
	public static void search(char[] txt, char[] pat) {
		int m = pat.length;
		int n = txt.length;

		int[] badchar = new int[NO_OF_CHARS];

		/*
		 * Fill the bad character array by calling the pre-processing function
		 * badCharHeuristic() for given pattern
		 */
		badCharHeuristic(pat, m, badchar);

		int s = 0; // s is shift of the pattern with respect to text
		while (s <= (n - m)) {
			int j = m - 1;

			/*
			 * Keep reducing index j of pattern while characters of pattern and
			 * text are matching at this shift s
			 */
			while (j >= 0 && pat[j] == txt[s + j])
				j--;

			/*
			 * If the pattern is present at current shift, then index j will
			 * become -1 after the above loop
			 */
			if (j < 0) {
				System.out.printf("\n pattern occurs at shift = %d", s);

				/*
				 * Shift the pattern so that the next character in text ie at
				 * s+m aligns with the last occurrence of it in pattern. The condition s+m
				 * < n is done to check bounds
				 */
				s += (s + m < n) ? m - badchar[txt[s + m]] : 1;

			}

			else
				/*
				 * Shift the pattern so that the bad character in text aligns
				 * with the last occurrence of it in pattern. The max function
				 * is used to make sure that we get a positive shift. We may get
				 * a negative shift if the last occurrence of bad character in
				 * pattern is on the right side of the current character.
				 */
				s += Math.max(1, j - badchar[txt[s + j]]);
		}
	}

}
