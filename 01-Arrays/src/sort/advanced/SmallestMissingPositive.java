package sort.advanced;

import java.util.Arrays;

public class SmallestMissingPositive {

	public static void main(String[] args) {
		int arr[] = { 0, 10, 2, -10, -20 };
		System.out.println(findMissing(arr, arr.length));
	}
	
	public static int findMissing(int arr[], int size) {
		// First separate positive and negative numbers
		int shift = segregate(arr, size);

		// call findMissingPositive for positive part
		int[] positives = Arrays.copyOfRange(arr, shift, size);
		return findMissingPositive(positives, size - shift);
	}

	/*
	 * Find the smallest positive missing number in an array that contains all
	 * positive integers
	 */
	public static int findMissingPositive(int arr[], int size) {
		// Mark arr[i] as visited by making arr[arr[i] - 1] negative. 
		for (int i = 0; i < size; i++) {
			if (Math.abs(arr[i]) - 1 < size && arr[Math.abs(arr[i]) - 1] > 0)
				arr[Math.abs(arr[i]) - 1] = -arr[Math.abs(arr[i]) - 1];
		}
		// Return the first index value at which is positive
		for (int i = 0; i < size; i++)
			if (arr[i] > 0)
				return i + 1; // 1 is added as indexes start from 0

		return size + 1;
	}

	public static int segregate(int arr[], int size) {
		int j = 0, i;
		for (i = 0; i < size; i++) {
			if (arr[i] <= 0) {
				swap(arr, i, j);
				j++;
			}
		}
		return j;
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
