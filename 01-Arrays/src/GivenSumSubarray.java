public class GivenSumSubarray {

	public static void main(String[] args) {
		int arr[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
		subArraySum(arr, arr.length, 23);
	}

	/*
	 * Returns true if the there is a subarray of arr[] with sum equal to 'sum'
	 * otherwise returns false. Also, prints the result
	 */
	public static boolean subArraySum(int arr[], int n, int sum) {
		
		int curr_sum = arr[0], start = 0, i;

		/*
		 * Add elements one by one to curr_sum and if the curr_sum exceeds the
		 * sum, then remove starting element
		 */
		for (i = 1; i <= n; i++) {
			// If curr_sum exceeds the sum, then remove the starting elements
			while (curr_sum > sum && start < i - 1) {
				curr_sum = curr_sum - arr[start];
				start++;
			}

			// If curr_sum becomes equal to sum, then return true
			if (curr_sum == sum) {
				System.out.printf("Sum found between indexes %d and %d", start,
						i - 1);
				return true;
			}

			// Add this element to curr_sum
			if (i < n)
				curr_sum = curr_sum + arr[i];
		}

		// If we reach here, then no subarray
		System.out.printf("No subarray found");
		return false;
	}

}