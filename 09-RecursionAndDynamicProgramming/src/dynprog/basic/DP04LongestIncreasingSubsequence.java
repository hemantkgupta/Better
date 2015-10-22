package dynprog.basic;

public class DP04LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] arr = { 100, 220, 9, 33, 21, 50, 41, 60 };
		System.out.println(lisDynamic(arr));
	}

    /**
     *
     * It is done by saving the LIS for each index of the array in another array
     * when the value at current index is greater than any previous index in array.
     * Finally the max in the newly constructed array will give length of longest increasing sequence.
     *
     * @param arr
     * @return
     */

	public static int lisDynamic(int arr[]) {
		int i, j, max = 0;
		int n = arr.length;
		int[] lis = new int[n];

		for (i = 0; i < n; i++)
			lis[i] = 1;

		for (i = 1; i < n; i++)
			for (j = 0; j < i; j++)
				if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
					lis[i] = lis[j] + 1;

		for (i = 0; i < n; i++)
			if (max < lis[i])
				max = lis[i];

		return max;
	}

}
