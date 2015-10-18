package sort.advanced;

public class MergeSortBottomUp {
	
	private static Comparable[] aux; 

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
		aux = new Comparable[N];
		for (int n = 1; n < N; n = n + n) {
			for (int i = 0; i < N - n; i += n + n) {
				int lo = i;
				int m = i + n - 1;
				int hi = Math.min(i + n + n - 1, N - 1);
				merge(a, lo, m, hi);
			}
		}
	}

	// stably merge a[lo..m] with a[m+1..hi] using aux[lo..hi]
	private static void merge(Comparable[] a, int lo, int m, int hi) {
		// copy to aux[]
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		// merge back to a[]
		int i = lo, j = m + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > m)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (less(aux[j], aux[i]))
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
		}

	}
	
	private static boolean less(Comparable v, Comparable w) {
		return (v.compareTo(w) < 0);
	}

	public static void printArray(Integer[] arr) {
		// System.out.println("");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" " + arr[i]);
		}

	}

}
