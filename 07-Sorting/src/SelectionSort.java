public class SelectionSort {

	public static void main(String[] args) {
		Integer [] ar = {1,2,4,8,5,6,9};
		System.out.println("Array before sort is:");
		printArray(ar);
		sort(ar);
		System.out.println("\nArray after sort is:");
		printArray(ar);
		

	}
	public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i+1; j < N; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exch(a, i, min);
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
