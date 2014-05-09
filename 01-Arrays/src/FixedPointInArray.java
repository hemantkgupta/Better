public class FixedPointInArray {

	public static void main(String[] args) {
		int[] arr = { -10, -1, 0, 3, 10, 11, 30, 50, 100 };
		System.out.println(binarySearch(arr, 0, arr.length - 1));

	}

	public static int binarySearch(int arr[], int low, int high) {
		if (high >= low) {
			int mid = (low + high) / 2; /* low + (high - low)/2; */
			if (mid == arr[mid])
				return mid;
			if (mid > arr[mid])
				return binarySearch(arr, (mid + 1), high);
			else
				return binarySearch(arr, low, (mid - 1));
		}

		/* Return -1 if there is no Fixed Point */
		return -1;
	}

}
