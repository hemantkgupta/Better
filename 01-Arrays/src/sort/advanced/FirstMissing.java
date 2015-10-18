package sort.advanced;

public class FirstMissing {

	public static void main(String[] args) {
		int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 10};
		System.out.println(findFirstMissing(arr,0, arr.length-1));
	}
	public static int findFirstMissing(int array[], int start, int end) {
		 
	    if(start  > end)
	      return end + 1;
	 
	    if (start != array[start])
	      return start;
	 
	    int mid = (start + end) / 2;
	 
	    if (array[mid] > mid)
	      return findFirstMissing(array, start, mid);
	    else
	      return findFirstMissing(array, mid + 1, end);
	}

}
