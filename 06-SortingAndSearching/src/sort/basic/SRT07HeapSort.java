package sort.basic;

import java.util.Arrays;

public class SRT07HeapSort {

	public static void main(String[] args) {
		Integer[] ar = { 1, 2, 4, 8, 5, 6, 9 };
		System.out.println("Array before sort is:");
        System.out.println(Arrays.toString(ar));
		sort(ar);
		System.out.println("\nArray after sort is:");
        System.out.println(Arrays.toString(ar));

	}
	
	
	 public static void sort(Comparable[] pq) {

	        int N = pq.length;
            // Heap or sink first half
	        for (int k = N/2; k >= 1; k--)
	            sink(pq, k, N);
	        while (N > 1) {
                //Largest value at top, exchange
	            exch(pq, 1, N--);
                // Re heap the rest
	            sink(pq, 1, N);
	        }
	    }
        // Function to heap or sink
	    private static void sink(Comparable[] pq, int k, int N) {
	        while (2*k <= N) {
                // Get first child
	            int child = 2*k;
                // Update child index to greater value one
	            if (child < N && less(pq, child, child+1)) child++;
                // If parent is greater nothing to do
	            if (!less(pq, k, child)) break;
                // exchange the parent to child if parent is less - sink
	            exch(pq, k, child);
	            k = child;
	        }
	    }

	
	    private static boolean less(Comparable[] pq, int i, int j) {
	        return pq[i-1].compareTo(pq[j-1]) < 0;
	    }

	    private static void exch(Object[] pq, int i, int j) {
	        Object swap = pq[i-1];
	        pq[i-1] = pq[j-1];
	        pq[j-1] = swap;
	    }

	    // is v < w ?
	    private static boolean less(Comparable v, Comparable w) {
	        return (v.compareTo(w) < 0);
	    }
	        


	    // print array to standard output
	    private static void show(Comparable[] a) {
	        for (int i = 0; i < a.length; i++) {
	            System.out.println(a[i]);
	        }
	    }

	  

}
