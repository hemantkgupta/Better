import java.util.Arrays;

public class ZerosToEnd {

	public static void main(String[] args) {
		int arr[] = { 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9 };
		pushZerosToEnd(arr, arr.length);
		System.out.println(Arrays.toString(arr));

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

}
