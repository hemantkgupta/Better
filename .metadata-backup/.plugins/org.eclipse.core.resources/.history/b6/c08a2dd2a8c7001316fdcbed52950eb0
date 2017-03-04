package longest.increasing.subsequence;

public class MyMainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		System.out.println(lis(arr));

	}

	public static int lis(int[] arr) {

		int n = arr.length;
		int[] LIS = new int[n];
		;

		/* Initialize LIS values for all indexes */
		for (int i = 0; i < n; i++)
			LIS[i] = 1;

		int max_ending_here = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] <= arr[i]) {
				max_ending_here = max_ending_here + 1;
				LIS[i] = max_ending_here;
			}
		}

		int max = 0;
		/* Pick maximum of all LIS values */
		for (int i = 0; i < n; i++)
			if (max < LIS[i])
				max = LIS[i];

		return max;
	}

}
