package search.basic;

import java.util.Arrays;

public class SRCH05FiniteAutomataBetter {
	private static final int NO_OF_CHARS = 4;

	public static void main(String[] args) {
		char[] txt = "AABAACAADAABAAABAA".toCharArray();
		char[] pat = "AABA".toCharArray();
		search(pat, txt);
		//int M =  pat.length;
		//int[][] TF = new int[M + 1][NO_OF_CHARS];
		//computeTransFun(pat,M, TF);
	}

	/**
	 * 1) Fill the first row. All entries in first row are always 0 except the entry for pat[0] character.
	 * 2) Initialize lps as 0. lps for the first index is always 0.
	 * 3) Do following for rows at index i = 1 to M. (M is the length of the pattern)
	     a) Copy the entries from the row at index equal to lps.
	     b) Update the entry for pat[i] character to i+1.
	     c) Update lps “lps = TF[lps][pat[i]]” where TF is the 2D array which is being constructed.
	 * @param pat
	 * @param M
	 * @param TF
	 */
	public static void computeTransFun(int[] pat, int M, int[][] TF) {
		int i, lps = 0, x;

		// Fill entries in first row
		for (x = 0; x < NO_OF_CHARS; x++)
			TF[0][x] = 0;
		
		TF[0][pat[0]] = 1;

		for (i = 1; i < M; i++) {
			for (x = 0; x < NO_OF_CHARS; x++)
				TF[i][x] = TF[lps][x];

			// Update the entry corresponding to this character
			int temp = pat[i];
			System.out.println("i is :"+i);
			System.out.println("pat[i] is :"+temp);
			TF[i][temp] = i + 1;

			lps = TF[lps][temp];
			System.out.println("lps is: "+lps);
		}
		print2DArray(TF);
		
	}

	/* Prints all occurrences of pat in txt */
	public static void search(char[] pat, char[] txt) {
		int M = pat.length;
		int N = txt.length;

		int[][] TF = new int[M + 1][NO_OF_CHARS];

		//computeTransFun(pat, M, TF);
		System.out.println(Arrays.toString(TF));

		// process text over FA.
		int i, j = 0;
		for (i = 0; i < N; i++) {
			j = TF[j][txt[i]];
			if (j == M) {
				System.out.printf("\n pattern found at index %d", i - M + 1);
			}
		}
	}
	
	public static void print2DArray(int[][] arr){
		for (int i=0;i< arr.length;i++){
			System.out.println();
			for(int j= 0;j<arr[0].length;j++){
				System.out.print(arr[i][j]+" ");
			}
		}
		System.out.println();
		
	}

}
