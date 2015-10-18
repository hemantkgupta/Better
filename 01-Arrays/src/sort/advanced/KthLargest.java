package sort.advanced;

public class KthLargest {

	public static void main(String[] args) {

	}

	public static void minHeapify(int[] arr, int i, int heapSize)
	{
	    int l = i*2 + 1;
	    int r = i*2 + 2;
	    int smallest = i;
	    if (l < heapSize && arr[l] < arr[i])
	        smallest = l;
	    if (r < heapSize && arr[r] < arr[smallest])
	        smallest = r;
	    if (smallest != i)
	    {
	        swap(arr, i, smallest);
	        minHeapify(arr, smallest, heapSize);
	    }
	}
	 
	// A utility function to convert harr[] to a max heap
	public static void buildHeap(int[] arr, int n)
	{
	    int i = (n - 1)/2;
	    while (i >= 0)
	    {
	        minHeapify(arr, i, n);
	        i--;
	    }
	}
	
	public static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp; 
	}
}
