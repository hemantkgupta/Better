package search.advanced;

public class PatternSearch02_KMP {

	public static void main(String[] args) {
		char[] txt = "AABAACAADAABAAABAA".toCharArray();
		char[] pat = "AABA".toCharArray();
		KMPSearch(pat, txt);
	}

	public static void KMPSearch(char[] pat, char[] txt) {
		int M = pat.length;
		int N = txt.length;

		int[] lps = new int[M];
		int j = 0;
		int i = 0;

		computeLPSArray(pat, lps);

		while (i < N) {
			if (pat[j] == txt[i]) {
				j++;
				i++;
			}
			if (j == M) {
				System.out.printf("Found pattern at index %d \n", i - j);
				j = lps[j - 1];

			} else  {
				if (j != 0)
					j = lps[j - 1];
				else
					i = i + 1;
			}
		}
	}

	public static void computeLPSArray(char[] pat, int[] lps) {
		int len = 0;
		int i = 1;
		lps[0] = 0;

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
					len = lps[len - 1];
				} else {
					lps[i] = 0;
					i++;
				}
			}
		}
	}

}
