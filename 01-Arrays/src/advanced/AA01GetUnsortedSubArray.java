package advanced;

public class AA01GetUnsortedSubArray {

	public static void main(String[] args) {
		int arr[] = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
		printUnsorted(arr, arr.length);

	}

	/**
	 *
	 1. First  Find the candidate unsorted subarray

	 a) Scan from left to right and find the first element which is greater than the next element. Let s be the index of such an element.
	 b) Scan from right to left and find the first element (first in right to left order) which is smaller than the next element (next in right to left order). Let e be the index of such an element.

	 2. Check whether sorting the candidate unsorted subarray makes the complete array sorted or not. If not, then include more elements in the sub array.

	 a) Find the minimum and maximum values in arr[s..e]. Let minimum and maximum                       values be min and max.
	 b) Find the first element (if there is any) in arr[0..s-1] which is greater than min, change s to index of this element.
	 c) Find the last element (if there is any) in arr[e+1..n-1] which is smaller than max, change e to index of this element.

	 * @param arr
	 * @param n
	 */

	public static void printUnsorted(int arr[], int n) {
		int start, end , i, max, min;

        //  Get the first inversion index
		for (start = 0; start < n - 1; start++) {
			if (arr[start] > arr[start + 1])
				break;
		}
		if (start == n - 1) {
			System.out.printf("The complete array is sorted");
			return;
		}

        // Get the last inversion index
		for (end = n - 1; end > 0; end--) {
			if (arr[end] < arr[end - 1])
				break;
		}

		max = arr[start];
		min = arr[start];

		for (i = start + 1; i <= end; i++) {
			if (arr[i] > max)
				max = arr[i];
			if (arr[i] < min)
				min = arr[i];
		}

        // Get the start of subarray
		for (i = 0; i < start; i++) {
			if (arr[i] > min) {
				start = i;
				break;
			}
		}
        // Get the end of subarray
		for (i = n - 1; i >= end + 1; i--) {
			if (arr[i] < max) {
				end = i;
				break;
			}
		}

		System.out.printf(" indx %d and %d", start, end);
		return;
	}

}
