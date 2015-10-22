package sort.advanced;

public class AllPermsRFromN {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5 };
		int r = 3;
		printCombination(arr, arr.length, r);

	}

	public static void printCombination(int arr[], int n, int r) {
		// A temporary array to store all combination one by one
		int[] data = new int[r];
		combinationUtil(arr, n, r, 0, data, 0);
	}

	public static void combinationUtil(int arr[], int n, int r, int index,
			int data[], int i) {
		if (index == r) {
			for (int j = 0; j < r; j++)
				System.out.printf("%d ", data[j]);
			System.out.println();
			return;
		}

		if (i >= n)
			return;

		data[index] = arr[i];
		combinationUtil(arr, n, r, index + 1, data, i + 1);
		// current is excluded,
		combinationUtil(arr, n, r, index, data, i + 1);
	}

}