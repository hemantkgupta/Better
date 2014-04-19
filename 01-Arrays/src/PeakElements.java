
public class PeakElements {

	public static void main(String[] args) {
		int arr[] = {1, 3, 20, 4, 1, 0};
		System.out.println(findPeak(arr, arr.length));
		
	}
	
	// A binary search based function that returns index of a peak element
	public static int findPeakUtil(int arr[], int low, int high, int n)
	{
	    int mid = low + (high - low)/2; 
	 
	    // Compare middle element with its neighbours (if neighbours exist)
	    if ((mid == 0 || arr[mid-1] <= arr[mid]) &&
	            (mid == n-1 || arr[mid+1] <= arr[mid]))
	        return mid;
	 
	    // If middle element is not peak and its left neighbor is greater than it
	    // then left half must have a peak element
	    else if (mid > 0 && arr[mid-1] > arr[mid])
	        return findPeakUtil(arr, low, (mid -1), n);
	 
	    // If middle element is not peak and its right neighbor is greater than it
	    // then right half must have a peak element
	    else return findPeakUtil(arr, (mid + 1), high, n);
	}
	 
	// A wrapper over recursive function findPeakUtil()
	public static int findPeak(int arr[], int n)
	{
	    return findPeakUtil(arr, 0, n-1, n);
	}

}