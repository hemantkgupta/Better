package sort.advanced;

import java.util.Arrays;

public class ReverseAnArray {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		reverseArray(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	/* Function to reverse arr[] from start to end */
	public static void reverseArray(int arr[], int start, int end) {
		int temp;
		if (start >= end)
			return;
		temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
		reverseArray(arr, start + 1, end - 1);
	}

}
