package basic;

/**
 * Search an element in a sorted and rotated array
 * https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 *
 */
public class AB15FindInSortedRotatedArray {

	public static void main(String[] args) {
		int arr1[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
		System.out.println(binarySearchInPivoted(arr1, 2));
	}

    // Returns index of key in arr[l..h]
    // if key is present, otherwise returns -1
    static int search(int arr[], int l, int h, int key) {
        if (l > h)
            return -1;

        int mid = (l+h)/2;
        if (arr[mid] == key)
            return mid;

        /* If arr[l...mid] is sorted */
        if (arr[l] <= arr[mid]) {
            /* As this subarray is sorted, we
               can quickly check if key lies in
               half or other half */
            if (key >= arr[l] && key <= arr[mid])
                return search(arr, l, mid-1, key);

            return search(arr, mid+1, h, key);
        }

        /* If arr[l..mid] is not sorted,
           then arr[mid... r] must be sorted*/
        if (key >= arr[mid] && key <= arr[h])
            return search(arr, mid+1, h, key);

        return search(arr, l, mid-1, key);
    }


	public static int binarySearchInPivoted(int arr[], int no) {
		int len = arr.length;
		int pivot = findPivot(arr, 0, len - 1);

		if (pivot == -1)
			return binarySearch(arr, 0, len - 1, no);

		if (arr[pivot] == no)
			return pivot;
		if (arr[0] <= no)
			return binarySearch(arr, 0, pivot - 1, no);
		else
			return binarySearch(arr, pivot + 1, len - 1, no);
	}

	public static int findPivot(int arr[], int low, int high) {
		// base cases
		if (high < low)
			return -1;
		if (high == low)
			return low;

		int mid = (low + high) / 2;

		// check if pivot at around mid
		if (mid < high && arr[mid] > arr[mid + 1])
			return mid;
		if (mid > low && arr[mid] < arr[mid - 1])
			return (mid - 1);

		// recursive call to find pivot
		if (arr[low] >= arr[mid])
			return findPivot(arr, low, mid - 1);
		else
			return findPivot(arr, mid + 1, high);
	}

	/* Standard Binary Search function */
	public static int binarySearch(int arr[], int low, int high, int no) {
		if (high < low)
			return -1;

		int mid = (low + high) / 2;

		if (no == arr[mid])
			return mid;

		if (no > arr[mid])
			return binarySearch(arr, (mid + 1), high, no);
		else
			return binarySearch(arr, low, (mid - 1), no);
	}

}
