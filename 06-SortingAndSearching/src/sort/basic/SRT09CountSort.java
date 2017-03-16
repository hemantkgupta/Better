package sort.basic;

import java.util.Arrays;
/** Counting sort is a sorting technique based on keys between a specific range.
 * It works by counting the number of objects having distinct key values (kind of hashing).
 * Then doing some arithmetic to calculate the position of each object in the output sequence.
 * Time Complexity: O(n+k) where n is the number of elements in input array and k is the range of input.
 * Auxiliary Space: O(n+k)
 */

public class SRT09CountSort {

	public static void main(String[] args) {
		int[] arr = { 2, 2, 2, 1, 4 };
		System.out.println("\nAfter sorting elements are: ");
		printArray(countSort(arr));
	}

	public static int[] countSort(int[] arrs) {
		int n = arrs.length;
		int[] output = new int[n];
		int[] count = new int[n];

		//Increment the count array at element value index
		for (int i = 0; i < n; i++)
			++count[arrs[i]];

		System.out.println("Count is : "+Arrays.toString(count));

		// Cumulative count
		for (int i = 1; i < n; i++)
			count[i] += count[i - 1];

		System.out.println("Cumulative count is : "+Arrays.toString(count));

		for (int i = 0; i < n; ++i) {
			int element = arrs[i];
			System.out.println("The element is "+element);

			int locationInOutput = count[element] - 1;
			System.out.println("The locationInOutput is "+locationInOutput);

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
