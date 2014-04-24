import java.util.Arrays;


public class KthSmallest {

	public static void main(String[] args) {
		
		klargest(4);

	}
	public static void klargest(int k){
		int[] arr = {20, 50, 10, 40, 90, 30, 70, 60 };
		buildHeap(arr, k);
		for (int i = k; i < arr.length; i++) {
			if(arr[i] > arr[0]){
				arr[0]= arr[i];
				minHeapify(arr,0,k);
			}
		}
		System.out.println(Arrays.toString(arr));
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