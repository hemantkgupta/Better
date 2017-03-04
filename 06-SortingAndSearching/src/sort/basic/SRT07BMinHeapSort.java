package sort.basic;

import java.util.Arrays;

public class SRT07BMinHeapSort {

	public static void main(String[] args) {

		int [] ar = { 1, 2, 4, 8, 5, 6, 9 };
		System.out.println("Array before sort is:");
		System.out.println(Arrays.toString(ar));
		heapSort(ar);
		System.out.println("\nArray after sort is:");
		System.out.println(Arrays.toString(ar));

	}
	/**
	 * This function first builds a min-heap from full array and then
	 * put the root of heap to end of the array. Once again same process
	 * is repeated but this time the last put element in array is excluded
	 * This loop is continued till one element is remaining for process.
	 */
	public static void heapSort(int [] array){
		if(array == null || array.length < 2)
			return;

		// Build the max-heap from array
		buildMinHeap(array, array.length);

		//Get max from heap and put at end
		int heapSize = array.length;
		for (int i = array.length-1; i > 0 ; i--) {
			swap(array, 0, i);
			heapSize = heapSize -1;
			minHeapify(array, 0, heapSize);
		}


	}

	/**
	 * For parent i (including 0), left child at 2*i+1 and right child at 2*i+2
	 * For child i parent is (i-1)/2 for i >= 1
	 * If last leaf node is at i then its parent is the last internal node
	 * @param array
	 * @param heapSize
	 */

	public static void buildMinHeap(int[] array, int heapSize){

		int n = array.length - 1;
		int lastInternalNode = (n - 1)/2;
		for(int i = lastInternalNode; i >= 0; i--){
			minHeapify(array, i, heapSize);
		}
	}

	/**
	 * For parent i (including 0), left child at 2*i+1 and right child at 2*i+2
	 * for child i parent is (i-1)/2 where is greater than 1
	 * If last leaf node is at i than index of its parent is the last internal node
	 * This method will be executed for all internal nodes
	 * The min-heap is a complete binary tree which has following property:
	 * Value of a node is lesser or equal to value of its both child nodes.
	 * The property is applicable to each node.
	 */
	public static void minHeapify(int[] a, int nodeIndex, int heapSize){

		int left = 2 * nodeIndex + 1;

		int right = left + 1;

		int smallest = nodeIndex;

		if (left < heapSize && a[left] < a[nodeIndex] )
			smallest = left;

		if (right < heapSize && a[right] < a[smallest] )
			smallest = right;

		if (smallest != nodeIndex){
			swap(a, nodeIndex, smallest);
			minHeapify(a, smallest, heapSize);
		}

	}

	public static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}


	// A utility function to convert arr to a min heap
	public static void buildHeap(int[] arr, int n)
	{
	    int i = (n - 1)/2;
	    while (i >= 0)
	    {
	        minHeapify(arr, i, n);
	        i--;
	    }
	}
}
