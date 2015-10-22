package dynprog.basic;

import java.util.Arrays;

/**
 * Given an array of integers where each element represents the max number of steps that can be made forward from that element.
 * Write a function to return the minimum number of jumps to reach the end of the array (starting from the first element).
 * If an element is 0, then cannot move through that element.
 */

public class DP06MinimumJumpsInArray {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 6, 3, 2, 3, 6, 8, 9, 5 };
		System.out.println("The no of jumps "
				+ minJumpsRecur(arr, 0, arr.length - 1));
		System.out.println("The no of jumps " + minJumpsDP(arr));
	}

	// Returns minimum number of jumps needed to reach arr[h] from arr[l]
	public static int minJumpsRecur(int arr[], int l, int h) {
		// Base case: when source and destination are same
		if (h == l)
			return 0;

		// When nothing is reachable from the given source
		if (arr[l] == 0)
			return Integer.MAX_VALUE;

		// Traverse through all the points reachable from arr[l]. Recursively
		// get the minimum number of jumps needed to reach arr[h] from these
		// reachable points.
		int min = Integer.MAX_VALUE;
		for (int i = l + 1; i <= h && i <= l + arr[l]; i++) {
			int jumps = minJumpsRecur(arr, i, h);
			if (jumps != Integer.MAX_VALUE && jumps + 1 < min)
				min = jumps + 1;
		}

		return min;
	}

	// Returns minimum number of jumps to reach arr[n-1] from arr[0]
	public static int minJumpsDP(int arr[]) {
		int n = arr.length;
		int[] jumps = new int[n]; // jumps[n-1] will hold the result
		int i, j;

		if (n == 0 || arr[0] == 0)
			return Integer.MAX_VALUE;

		jumps[0] = 0;

		// Find the minimum number of jumps to reach arr[i]
		// from arr[0], and assign this value to jumps[i]
		for (i = 1; i < n; i++) {
			jumps[i] = Integer.MAX_VALUE;

			for (j = 0; j < i; j++) { 
				// temp[j] is not unreachable and we can reach i from j						
				if (j + arr[j] >= i && jumps[j] != Integer.MAX_VALUE) {
					jumps[i] = jumps[j] + 1;
					break;
				}
			}
		}
        System.out.println(Arrays.toString(jumps));
        return jumps[n - 1];
	}

}
