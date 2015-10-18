package sort.advanced;

import java.util.Arrays;

public class ShuffleArray {

	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
		randomize(arr);
		System.out.println(Arrays.toString(arr));

	}

	// A function to generate a random permutation of arr[]
	public static void randomize(int arr[]) {
		int n = arr.length;
		for (int i = n - 1; i > 0; i--) {
			int j = (int) Math.random() * i;
			swap(arr, i, j);
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
