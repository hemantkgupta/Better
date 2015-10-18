package sort.basic;

public class A012GetUnsortedSubArray {

	public static void main(String[] args) {
		int arr[] = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
		printUnsorted(arr, arr.length);

	}

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
