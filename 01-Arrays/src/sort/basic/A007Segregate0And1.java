package sort.basic;

public class A007Segregate0And1 {

	public static void main(String[] args) {
		int arr[] = { 0, 1, 0, 1, 1, 1 };
		segregate0and1(arr, arr.length);
		printArray(arr);
		//pushZerosToFront(arr, arr.length);
		//printArray(arr);
	}

	public static void segregate0and1(int arr[], int size) {
		int left = 0, right = size - 1;

		while (left < right) {
			while (arr[left] == 0 && left < right)
				left++;
			while (arr[right] == 1 && left < right)
				right--;
			if (left < right) {
				arr[left] = 0;
				arr[right] = 1;
				left++;
				right--;
			}
		}
	}

	public static void pushZerosToEnd(int arr[], int n) {
		int count = 0; // Count of non-zero elements

		// replace the non-zero at index 'count'
		for (int i = 0; i < n; i++)
			if (arr[i] != 0)
				arr[count++] = arr[i];

		// Now all non-zero elements have been shifted to front
		while (count < n)
			arr[count++] = 0;
	}

	public static void pushZerosToFront(int arr[], int n) {
		int count = 0; // Count of non-zero elements

		for (int i = n - 1; i >= 0; i--)
			if (arr[i] != 0)
				arr[(n - 1 - count++)] = arr[i];

	}

	public static void printArray(int[] arr) {
		System.out.println("");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" " + arr[i]);
		}

	}

}
