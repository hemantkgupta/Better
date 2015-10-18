import java.util.Arrays;

public class S013Interleaving {

	public static void main(String[] args) {
		String str1 = "AC";
        int m = str1.length();
		String str2 = "BD";
        int n = str2.length();
		char[] results = new char[m + n];
		printInterleavings(str1, str2, results, 0);
		System.out.println(isInterleaved("AC".toCharArray(),
                "BD".toCharArray(), "ACFD".toCharArray()));
		System.out.println(isInterleaved("AC".toCharArray(),
                "BD".toCharArray(), "ACBD".toCharArray()));

	}

	public static void printInterleavings(String str1, String str2,
			char[] iStr, int i) {

		int m = str1.length();
		int n = str2.length();

		if (m == 0 && n == 0) {
			System.out.println(Arrays.toString(iStr));
		}

		if (m != 0) {
			iStr[i] = str1.charAt(0);
			printInterleavings(str1.substring(1), str2, iStr, i + 1);
		}

		if (n != 0) {
			iStr[i] = str2.charAt(0);
			printInterleavings(str1, str2.substring(1), iStr, i + 1);
		}
	}

	// Returns true if C is an interleaving of A and B, otherwise
	// returns false
	public static boolean isInterleaved(char[] A, char[] B, char[] C) {
		int clen = C.length;

		if (clen != (A.length + B.length))
			return false;

		int aIndex = 0, bIndex = 0, cIndex = 0;
		while (cIndex < clen) {

			if (aIndex < A.length-1 && A[aIndex] == C[cIndex]) {
				aIndex++;
			} else if (bIndex < B.length-1 && B[bIndex] == C[cIndex]) {
                bIndex++;
            }
			cIndex++;
		}
		return cIndex == aIndex+1 + bIndex+1;
	}

}
