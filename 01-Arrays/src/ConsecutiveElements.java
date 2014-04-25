public class ConsecutiveElements {

	public static void main(String[] args) {
		int arr[] = { 1, 4, 5, 3, 2, 6 };
		System.out.println(areConsecutive(arr, arr.length));
	}

	/*
	 * The function checks if the array elements are consecutive If elements are
	 * consecutive, then returns true, else returns false
	 */
	public static boolean areConsecutive(int arr[], int n) {

		if (n < 1)
			return false;

		int min = getMin(arr, n);

		int max = getMax(arr, n);

		if (max - min + 1 == n) {

			for (int i = 0; i < n; i++) {
				int j;

				if (arr[i] < 0)
					j = -arr[i] - min;
				else
					j = arr[i] - min;

				// if the value at index j is negative then
				// there is repitition
				if (arr[j] > 0)
					arr[j] = -arr[j];
				else
					return false;
			}

			return true;
		}

		return false;
	}

	public static int getMin(int arr[], int n) {
		int min = arr[0];
		for (int i = 1; i < n; i++)
			if (arr[i] < min)
				min = arr[i];
		return min;
	}

	public static int getMax(int arr[], int n) {
		int max = arr[0];
		for (int i = 1; i < n; i++)
			if (arr[i] > max)
				max = arr[i];
		return max;
	}

}
