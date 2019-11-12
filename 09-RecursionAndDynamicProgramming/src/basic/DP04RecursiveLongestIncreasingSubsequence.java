package basic;

public class DP04RecursiveLongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60 };
		System.out.println(lis(arr));
	}

    /**
     * It can be solved by building a LIS array as follow.
     * LIS at any index of array will be one more than the max of
	 * LIS from previous indexes if
     * the current index value is greater than the last value of largest LIS index value
	 *
     * In case the current index value is not more then the LIS for
	 * this index should be set to one (This can be done as initialization)
	 * Finally the max value is LIS array is the result
	 * The complexity of this approach is O(n^2)
     *
     * https://www.youtube.com/watch?v=Ns4LCeeOFS4&list=PLqM7alHXFySGbXhWx7sBJEwY2DnhDjmxm&index=5
     *
     * @param arr
     * @return
     */

	static int maxLIS; // stores the LIS

	/* To make use of recursive calls, this function must return
    two things:
    1) Length of LIS ending with element arr[n-1]. We use
       maxEndingHereLIS for this purpose
    2) Overall maximum as the LIS may end with an element
       before arr[n-1] maxLIS is used this purpose.
    The value of LIS of full array of size n is stored in
    *maxLIS which is our final result */

	static int lisRecursive(int arr[], int n)
	{
		// base case
		if (n == 1)
			return 1;

		// 'maxEndingHereLIS' is length of LIS ending with arr[n-1]
		int currentLIS, maxEndingHereLIS = 1;

        /* Recursively get all LIS ending with arr[0], arr[1] ...
           arr[n-2]. If   arr[i-1] is smaller than arr[n-1], and
           max ending with arr[n-1] needs to be updated, then
           update it */
		for (int i = 1; i < n; i++)
		{
			currentLIS = lisRecursive(arr, i);
			if (arr[i-1] < arr[n-1] && currentLIS + 1 > maxEndingHereLIS)
				maxEndingHereLIS = currentLIS + 1;
		}

		// Compare maxEndingHereLIS with the overall max. And
		// update the overall max if needed
		if (maxLIS < maxEndingHereLIS)
			maxLIS = maxEndingHereLIS;

		// Return length of LIS ending with arr[n-1]
		return maxEndingHereLIS;
	}

	// The wrapper function for lisRecursive()
	static int lis(int arr[])
	{
		// The max variable holds the result
		maxLIS = 1;

		// The function lisRecursive() stores its result in max
		lisRecursive( arr, arr.length);

		// returns max
		return maxLIS;
	}




}
