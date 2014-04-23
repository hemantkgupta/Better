package longest.increasing.subsequence;

public class LongestIncreasingSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 100, 220, 9, 33, 21, 50, 41, 60 };
		System.out.println(lisDynamic(arr));
	}
	public static int lis(int arr[], int n)
	{
	    // The max variable holds the result
	    int max = 1;
	 
	    // The function _lis() stores its result in max
	    lisRec( arr, n, max );
	 
	    // returns max
	    return max;
	}
	
	public static int lisRec( int arr[], int n, int max_ref)
	{
	    /* Base case */
	    if(n == 1)
	        return 1;
	 
	    int res, max_ending_here = 1; // length of LIS ending with arr[n-1]
	 
	    /* Recursively get all LIS ending with arr[0], arr[1] ... ar[n-2]. If 
	       arr[i-1] is smaller than arr[n-1], and max ending with arr[n-1] needs
	       to be updated, then update it */
	    for(int i = 1; i < n; i++)
	    {
	        res = lisRec(arr, i, max_ref);
	        if (arr[i-1] < arr[n-1] && res + 1 > max_ending_here)
	            max_ending_here = res + 1;
	    }
	 
	    // Compare max_ending_here with the overall max. And update the
	    // overall max if needed
	    if (max_ref < max_ending_here)
	       max_ref = max_ending_here;
	 
	    // Return length of LIS ending with arr[n-1]
	    return max_ending_here;
	}
	
	public static int lisDynamic( int arr[])
	{
	   int  i, j, max = 0;
	   int n = arr.length;
	   int[] lis =  new int[n];;
	 
	   /* Initialize LIS values for all indexes */
	   for ( i = 0; i < n; i++ )
	      lis[i] = 1;
	    
	   /* Compute optimized LIS values in bottom up manner */
	   for ( i = 1; i < n; i++ )
	      for ( j = 0; j < i; j++ )
	         if ( arr[i] > arr[j] && lis[i] < lis[j] + 1)
	            lis[i] = lis[j] + 1;
	    
	   /* Pick maximum of all LIS values */
	   for ( i = 0; i < n; i++ )
	      if ( max < lis[i] )
	         max = lis[i];
	  
	   return max;
	}
	
	

}
