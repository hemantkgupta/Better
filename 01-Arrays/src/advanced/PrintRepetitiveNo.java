package advanced;

public class PrintRepetitiveNo {

	public static void main(String[] args) {
		int arr[] = { 5, 3, 2, 2, 1, 4, 5 };
		printRepeating(arr, arr.length);
	}

	public static void printRepeating(int arr[], int size) {

		System.out.println("\n The repeating elements are");

		for (int i = 0; i < size; i++) {
			if (arr[Math.abs(arr[i])] > 0)
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			else
				System.out.println("" + Math.abs(arr[i]));
		}
	}

}
