package sort.advanced;

import java.util.Arrays;

public class SubsetArrayTest {

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] arr2 = { 4, 8, 1, 9 };
		System.out.println(isSubset(arr1, arr2, arr1.length, arr2.length));
	}

	/* Return 1 if arr2[] is a subset of arr1[] */
	public static boolean isSubset(int arr1[], int arr2[], int m, int n) {
		int i = 0, j = 0;

		if (m < n)
			return false;

		Arrays.sort(arr1);
		Arrays.sort(arr2);
		while (i < n && j < m) {
			if (arr1[j] < arr2[i])
				j++;
			else if (arr1[j] == arr2[i]) {
				j++;
				i++;
			} else if (arr1[j] > arr2[i])
				return false;
		}

		if (i < n)
			return false;
		else
			return true;
	}

}
