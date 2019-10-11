package basic;

import java.util.Arrays;

public class AB11PutAllZerosToEnd {

	public static void main(String[] args) {
		int arr[] = { 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9 };
		pushZerosToEnd(arr, arr.length);
		System.out.println(Arrays.toString(arr));

	}

	/**
	 *  Loop through the array and start counting the non-zeros elements in the array
	 *  in a counter. If non-zero element is found then put it at counter index.
	 *  After looping put zero in the array from counter index to last array index.
    */

	public static void pushZerosToEnd(int arr[], int n) {
		int nonZeroCounter = 0;

		for (int i = 0; i < n; i++)
			if (arr[i] != 0){
                if (nonZeroCounter != i){
				    arr[nonZeroCounter] = arr[i];
                }
                nonZeroCounter++;
            }

		while (nonZeroCounter < n)
			arr[nonZeroCounter++] = 0;
	}

}
