public class TwoSmallest {

	public static void main(String[] args) {
		int arr[] = { 1, 60, -10, 70, -80, 85 };
		print2Smallest(arr, arr.length);
	}

	public static void print2Smallest(int arr[], int arr_size) {
		int i, first, second;

		if (arr_size < 2) {
			System.out.println(" Invalid Input ");
			return;
		}

		first = second = Integer.MAX_VALUE;
		for (i = 0; i < arr_size; i++) {
			/*
			 * If current element is smaller than first then update both first
			 * and second
			 */
			if (arr[i] < first) {
				second = first;
				first = arr[i];
			} else if (arr[i] < second && arr[i] != first)
				second = arr[i];
		}
		if (second == Integer.MAX_VALUE)
			System.out.println("There is no second smallest element\n");
		else
			System.out.println("Elements: " + first + " and: " + second);
	}

}
