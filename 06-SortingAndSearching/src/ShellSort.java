public class ShellSort {

	public static void main(String[] args) {
		Integer[] ar = { 1, 2, 4, 8, 5, 6, 9 };
		System.out.println("Array before sort is:");
		printArray(ar);
		sort(ar);
		System.out.println("\nArray after sort is:");
		printArray(ar);
	}

	public static void sort(Comparable[] a) {
		int N = a.length;
		// 3x+1 increment sequence: 1, 4, 13, 40, 121, 364, 1093,
		int h = 1;
		while (h < N / 3)
			h = 3 * h + 1;

		while (h >= 1) {
			// h-sort the array
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
					exch(a, j, j - h);
				}
			}
			h /= 3;
		}
	}

	private static boolean less(Comparable v, Comparable w) {
		return (v.compareTo(w) < 0);
	}

	private static void exch(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	public static void printArray(Integer[] arr) {
		// System.out.println("");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" " + arr[i]);
		}

	}

}
