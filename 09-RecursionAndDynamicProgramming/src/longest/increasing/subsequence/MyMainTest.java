package longest.increasing.subsequence;

public class MyMainTest {

	public static void main(String[] args) {
		int[] arr = { 100, 220, 9, 33, 21, 50, 41, 60, 80 };
		printLIS(arr);

	}

	public static void printLIS(int[] nums) {
		int n = nums.length;
		String[] paths = new String[n];
		int[] sizes = new int[n];
		for (int i = 0; i < n; i++) {
			sizes[i] = 1;
			paths[i] = nums[i] + " ";
		}
		int maxLength = 1;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j] && sizes[i] < sizes[j] + 1) {
					sizes[i] = sizes[j] + 1;
					paths[i] = paths[j] + nums[i] + " ";
					if (maxLength < sizes[i])
						maxLength = sizes[i];
				}
			}
		}
		for (int i = 1; i < n; i++) {
			if (sizes[i] == maxLength)
				System.out.println("LIS: " + paths[i]);
		}
	}
}
