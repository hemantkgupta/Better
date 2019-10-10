package basic;

/**
 * An element is a leader if it is greater than all the elements to its right side in an array.
 * The rightmost element is always a leader.
 */
public class A04PrintLeaders {

	public static void main(String[] args) {
		int[] ar = { 1, 4, 5, 9, 5, 6, 3, 4, 8, 3, 4 };
		printLeaders(ar);
	}

	public static void printLeaders(int arr[]) {
		int size = arr.length;
		int maxFromRight = arr[size - 1];
		System.out.format("%d ", maxFromRight);

		for (int i = size - 2; i >= 0; i--) {
			if (maxFromRight < arr[i]) {
				System.out.format("%d ", arr[i]);
				maxFromRight = arr[i];
			}
		}
	}

}
