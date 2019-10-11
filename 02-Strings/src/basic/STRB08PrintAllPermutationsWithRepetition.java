package basic;

import java.util.Arrays;

/**
 * The program prints all permutation with repetition allowed for
 * a given string. The program works if the given string has only
 * unique characters. If it is not the case then first remove duplcate
 * characters from the string.
 */


public class STRB08PrintAllPermutationsWithRepetition {

	public static void main(String[] args) {
		printAllPermsWithRepetition("BAC");
	}
	
	public static void printAllPermsWithRepetition(String str){
		int len = str.length();
		char[] input = str.toCharArray();
		char[] print = new char[len];
		Arrays.sort(input);
		printPerms(input, print, 0);
	}
	
	public static void printPerms(char[] ar, char[] print, int index){
		
		int len = ar.length;

		// For each char in the array
		for (int i = 0; i < len; i++) {

			// Save the current char for printing
			print[index] = ar[i];

			//If the print array has all chars, print
			if ((len-1) == index){
				System.out.println(Arrays.toString(print));
			}else{
				printPerms(ar, print, index+1);
			}
		}
	}

}
