package sort.basic;

import java.util.Arrays;

public class SRT03InsertionSort {

	public static void main(String[] args) {

		Integer [] ar = {1,2,4,1,8,5,6,9,8};
		//Integer [] ar = {10,2};
		System.out.println("Array before sort is:");
		System.out.println(Arrays.toString(ar));
		sort(ar);
		//insertionSort(ar);
		System.out.println("\nArray after sort is:");
		System.out.println(Arrays.toString(ar));

	}
	
	public static void sort(Comparable[] a) {
		int n = a.length;

        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
        }	
    }

	public static void insertionSort(Integer[] a){
		if (a == null || a.length < 2)
			return;
		for (int i = 1; i < a.length ; i++) {
			int temp = a[i];
			int j= i-1;
			while (j >= 0 && temp < a[j]){
				a[j+1] = a [j];
				j--;
			}
			a[j+1]= temp;
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

}
