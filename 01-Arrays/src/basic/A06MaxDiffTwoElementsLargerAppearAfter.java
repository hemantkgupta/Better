package basic;

public class A06MaxDiffTwoElementsLargerAppearAfter {

	public static void main(String[] args) {
		int arr[] = { 100, 2, 6, 80, 1 };
		System.out.println(maxDiff(arr));
		System.out.println(maxDiffUsingKadaneAlgorithm(arr));
	}

	//max diff such that larger element appears after
	public static int maxDiff(int arr[]) {
		int size = arr.length;
		int maxDiff = arr[1] - arr[0];
		int min_element = arr[0];
		int i;
		for (i = 1; i < size; i++) {
			if (arr[i] - min_element > maxDiff)
				maxDiff = arr[i] - min_element;
			if (arr[i] < min_element)
				min_element = arr[i];
		}
		return maxDiff;
	}

	//max diff such that larger element appears after
	public static int maxDiffUsingKadaneAlgorithm(int arr[]) {
		int n = arr.length;
		// diff holds difference of adjacent elements
		int[] diff = new int[n - 1];
		for (int i = 0; i < n - 1; i++)
			diff[i] = arr[i + 1] - arr[i];

		//Use Kadane maximum sum subarray in diff 
		int maxSumSoFar = 0;
		int maxSumEndingHere = 0;
		for (int i = 0; i < n - 1; i++) {
			//Get the contiguous segment
			maxSumEndingHere = Math.max(0, diff[i]+maxSumEndingHere);
			//Compare it with max
			maxSumSoFar = Math.max(maxSumSoFar, maxSumEndingHere);

		}
		return maxSumSoFar;
	}

}
