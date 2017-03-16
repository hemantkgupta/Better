package search.basic;

/** The KMP matching algorithm uses degenerating property
 * (pattern having same sub-patterns appearing more than once in the pattern) of the pattern
 *  and improves the worst case complexity to O(n).
 *  KMP algorithm does some preprocessing over the pattern pat[]
 *  and constructs an auxiliary array lps[] of size m (same as size of pattern).
 *  Here name lps indicates longest proper prefix which is also suffix.
 *  For each sub-pattern pat[0…i] where i = 0 to m-1,
 *  lps[i] stores length of the maximum matching proper prefix which is
 *  also a suffix of the sub-pattern pat[0..i].
 */
public class SRCH02KMP {

	public static void main(String[] args) {
		char[] txt = "AABAACAADAABAAABAA".toCharArray();
		char[] pat = "AABA".toCharArray();
		KMPSearch(pat, txt);
	}

	/**
	 * Unlike the Naive algo where we slide the pattern by one,
	 * we use a value from lps[] to decide the next sliding position.
	 * When we compare pat[j] with txt[i] and see a mismatch,
	 * we know that characters pat[0..j-1] match with txt[i-j…i-1],
	 * and we also know that lps[j-1] characters of pat[0…j-1] are
	 * both proper prefix and suffix which means
	 * we do not need to match these lps[j-1] characters with txt[i-j…i-1]
	 * because we know that these characters will anyway match.
	 * @param pat
	 * @param txt
	 */
	public static void KMPSearch(char[] pat, char[] txt) {
		int M = pat.length;
		int N = txt.length;

		int[] lps = new int[M];
		int j = 0;
		int i = 0;

		computeLPSArray(pat, lps);

		// Do for each character in text
		while (i < N) {
			//Check if text and pattern match
			if (pat[j] == txt[i]) {
				j++;
				i++;
			}
			if (j == M) {
				System.out.printf("Found pattern at index %d \n", i - j);
				j = lps[j - 1];

			} else  { // mismatch after j characters are matched
				if (j != 0)
					j = lps[j - 1];
				else
					i = i + 1;
			}
		}
	}

	/**
	 * For the pattern “AAAAA”, lps[] is [0, 1, 2, 3, 4]
	 * For the pattern “AAABAAA”, lps[] is [0, 1, 2, 0, 1, 2, 3]
	 * @param pat
	 * @param lps
	 */
	public static void computeLPSArray(char[] pat, int[] lps) {

		// length of the previous longest prefix suffix
		int len = 0;
		// lps[0] is always 0
		lps[0] = 0;

		int i = 1;

		while (i < pat.length) {
			System.out.println(" i is: " + i);
			System.out.println(" len is: " + len);
			if (pat[i] == pat[len]) {
				System.out.println(" pat[i] is equal to pat[len] ");
				len++;
				lps[i] = len;
				System.out.println(" lps[i] is set to " + lps[i]);
				i++;
			} else {
				System.out.println(" pat[i] is not equal to pat[len] ");
				if (len != 0) {
					System.out.println("len is not zero : " + len);
					// Note that we do not increment i here
					len = lps[len - 1];
				} else {
					lps[i] = 0;
					i++;
				}
			}
		}
	}

}
