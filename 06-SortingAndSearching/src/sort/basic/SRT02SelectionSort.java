package sort.basic;

import java.util.Arrays;

public class SRT02SelectionSort {

	public static void main(String[] args) {
		Integer [] ar = {1,2,4,1,8,5,8,6,9};
		System.out.println("Array before sort is:");
		System.out.println(Arrays.toString(ar));
		sort(ar);
		System.out.println("\nArray after sort is:");
		System.out.println(Arrays.toString(ar));


	}
	public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < a.length; j++) {
                if (less(a[j], a[minIndex]))
					minIndex = j;
            }
            exch(a, i, minIndex);
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
	
	public static void printArray(Integer[] arr){
		//System.out.println("");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" "+arr[i]);
		}
		
	}


}
