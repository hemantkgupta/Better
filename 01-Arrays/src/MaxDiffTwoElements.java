
public class MaxDiffTwoElements {

	public static void main(String[] args) {
		int arr[] = {1, 2, 6, 80, 100};
		System.out.println(maxDiff(arr, arr.length));
		System.out.println(maxDiff2(arr, arr.length));
	}
	public static int maxDiff(int arr[], int arr_size)
	{
	  int max_diff = arr[1] - arr[0];
	  int min_element = arr[0];
	  int i;
	  for(i = 1; i < arr_size; i++)
	  {       
	    if(arr[i] - min_element > max_diff)                               
	      max_diff = arr[i] - min_element;
	    if(arr[i] < min_element)
	         min_element = arr[i];                     
	  }
	  return max_diff;
	}  
	
	public static int maxDiff2(int arr[], int n)
	{
	    // Create a diff array of size n-1. The array will hold
	    //  the difference of adjacent elements
	    int[] diff = new int[n-1];
	    for (int i=0; i < n-1; i++)
	        diff[i] = arr[i+1] - arr[i];
	 
	    // Now find the maximum sum subarray in diff array
	    int maxDiff = diff[0];
	    for (int i=1; i<n-1; i++)
	    {
	        if (diff[i-1] > 0)
	            diff[i] += diff[i-1];
	        if (maxDiff < diff[i])
	            maxDiff = diff[i];
	    }
	    return maxDiff;
	}

}
