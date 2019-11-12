package sort.basic;

import java.util.Arrays;

public class SRT02SelectionSort {

	public static void main(String[] args) {
		Integer [] ar = {1,2,4,1,8,5,8,6,9};
		System.out.println("Array before sort is:");
		System.out.println(Arrays.toString(ar));
		sort2(ar);
		System.out.println("\nArray after sort is:");
		System.out.println(Arrays.toString(ar));


	}
	public static void sort(Comparable[] a) {

		int n = a.length;

        for (int i = 0; i < n; i++) {
        	// Set current to index of minimum
            int minIndex = i;
            // Find minimum index
            for (int j = i+1; j < n; j++) {
                if (less(a[j], a[minIndex]))
					minIndex = j;
            }
            // Swap values
            exch(a, i, minIndex);
        }
    }


    public static void sort2(Comparable[] a) {

        int n = a.length;

        for (int lastUnsortedIndex = n-1;  lastUnsortedIndex >  0; lastUnsortedIndex--) {

            int maximumIndex = lastUnsortedIndex;
            //Update maximum index
            for (int j = maximumIndex-1; j >= 0; j--) {
                if (more(a[j], a[maximumIndex]))
                    maximumIndex = j;
            }
            //Exchange the value at maximumIndex
            exch(a, lastUnsortedIndex, maximumIndex);
        }
    }

	
	private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }

    private static boolean more(Comparable v, Comparable w) {
        return (v.compareTo(w) > 0);
    }
	
	private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
	
}
