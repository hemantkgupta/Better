public class PrintLeaders {

	public static void main(String[] args) {
		int[] ar = { 1, 4, 5, 9, 5, 6, 3, 4, 8, 3, 4 };
		printLeaders(ar, ar.length);
	}

	public static void printLeaders(int arr[], int size) {
		int max_from_right = arr[size - 1];
		int i;
		System.out.format("%d ", max_from_right);

		for (i = size - 2; i >= 0; i--) {
			if (max_from_right < arr[i]) {
				System.out.format("%d ", arr[i]);
				max_from_right = arr[i];
			}
		}
	}

}