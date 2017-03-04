package sort.basic;

public class SRT05MergeSortTopDown {
	
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
		aux = new Comparable[a.length]; 
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int lo, int hi) { 
		if (hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		sort(a, lo, mid); 
		sort(a, mid + 1, hi); 
		merge(a, lo, mid, hi); 
	}

	// Merge a[lo..mid] with a[mid+1..hi].
	public static void merge(Comparable[] a, int lo, int mid, int hi) {
		
		int i = lo, j = mid + 1;

		// Copy a[lo..hi] to aux[lo..hi].
		for (int k = lo; k <= hi; k++)			
			aux[k] = a[k];

		for (int k = lo; k <= hi; k++) {

			if (i > mid)
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
