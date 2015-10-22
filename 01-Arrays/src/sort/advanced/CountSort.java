package sort.advanced;

import java.util.Arrays;

public class CountSort {

	public static void main(String[] args) {
		int[] arr = { 2, 2, 2, 1, 4 };
		System.out.println("\nAfter sorting elemnets are: ");
		printArray(countSort(arr));
	}

	public static int[] countSort(int[] arrs) {
		int n = arrs.length;
		int[] output = new int[n];
		int[] count = new int[n];

		int i;
		for (i = 0; i < n; i++) 
			++count[arrs[i]];

		for (i = 1; i < n; i++)
			count[i] += count[i - 1];

		for (i = 0; i < n; ++i) {
			int element = arrs[i];
			
			int locationInOutput = count[element] - 1;

			output[locationInOutput] = element;

			--count[element];
		}
		return output;
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}