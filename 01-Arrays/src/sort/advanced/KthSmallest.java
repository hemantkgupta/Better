package sort.advanced;

public class KthSmallest {

	public static void main(String[] args) {
		int[] arr = { 20, 50, 60, 40, 90, 30, 70, 10 };
		System.out.println(kthSmallest(arr, 8));

	}

	public static int kthSmallest(int[] arr, int k) {
		buildMaxHeap(arr, k);
		for (int i = k; i < arr.length; i++) {
			if (arr[i] < arr[0]) {
				arr[0] = arr[i];
				maxHeapify(arr, 0, k);
			}
		}
		return arr[0];
	}
	
	public static void buildMaxHeap(int[] arr, int n) {
		int i = n / 2;
		while (i >= 0) {
			maxHeapify(arr, i, n);
			i--;
		}
	}

	public static void maxHeapify(int[] arr, int i, int heapSize) {
		int l = i * 2 + 1;
		int r = i * 2 + 2;
		int largest = i;
		if (l < heapSize && arr[l] > arr[i])
			largest = l;
		if (r < heapSize && arr[r] > arr[largest])
			largest = r;
		if (largest != i) {
			swap(arr, i, largest);
			maxHeapify(arr, largest, heapSize);
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}