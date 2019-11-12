package sort.basic;

public class SRT01BubbleSort {
	
	public static void main(String[] args) {
		int ar[] = { 2, 6, 4, 3, 5, 7, 8, 3, 9, 1 };
		display(ar);
		bubbleSort(ar);
		display(ar);
	}

	public static void display(int[] a) {
		for (int j = 0; j < a.length; j++)
			System.out.print(a[j] + " ");
		System.out.println("");
	}

	public static void bubbleSort(int[] a) {

		// Trace Unsorted Partition Index - starts at rightmost
		for (int lastUnsortedIndex = a.length-1; lastUnsortedIndex > 0; lastUnsortedIndex--)
			for (int j = 0; j < lastUnsortedIndex; j++)
				if (a[j] > a[j + 1]) 
					swap(a, j, j + 1); 
	} 

	public static void swap(int[] a, int one, int two) {
		if (one == two)
			return;
		int temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}
} 