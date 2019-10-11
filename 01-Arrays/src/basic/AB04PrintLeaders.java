package basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 Given an array of positive integers. Your task is to find the leaders in the array.
 Note: An element of array is leader if it is greater than or equal to all the elements to its right side.
 Also, the rightmost element is always a leader.

 Input:
 The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows.
 The first line of each test case contains a single integer N denoting the size of array.
 The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.

 Output:
 Print all the leaders.

 Constraints:
 1 <= T <= 100
 1 <= N <= 107
 0 <= Ai <= 107

 Example:
 Input:
 3
 6
 16 17 4 3 5 2
 5
 1 2 3 4 0
 5
 7 4 5 7 3
 Output:
 17 5 2
 4 0
 7 7 3

 Explanation:
 Testcase 3: All elements on the right of 7 (at index 0) are smaller than or equal to 7.
 Also, all the elements of right side of 7 (at index 3) are smaller than 7.
 And, the last element 3 is itself a leader since no elements are on its right.
 */
<<<<<<< Updated upstream
public class AB04PrintLeaders {
=======
>>>>>>> Stashed changes

public class AB04PrintLeaders {

	/*public static void main(String[] args) {
		int[] ar = { 1, 4, 5, 9, 5, 6, 3, 4, 8, 3, 4 };
		printLeaders(ar);
	}*/

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		while(T > 0){
			int N = s.nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < N ; i++) {
				arr[i] = s.nextInt();
			}
			int size = arr.length;
			List<Integer> leadersInReverse = new ArrayList<>();
			// Initialize the maxFromRight as rightmost element
			int maxFromRight = arr[size - 1];
			leadersInReverse.add(maxFromRight);
			//System.out.format("%d ", maxFromRight);

			// The trick is to move from right
			for (int i = size - 2; i >= 0; i--) {
				if (maxFromRight <= arr[i]) {
					//System.out.format("%d ", arr.get(i));
					leadersInReverse.add(arr[i]);
					maxFromRight = arr[i];
				}
			}
			StringBuilder stringBuilder = new StringBuilder();
			for (int i = leadersInReverse.size() -1 ; i >= 0 ; i--) {
				stringBuilder.append(leadersInReverse.get(i));
				stringBuilder.append(' ');

			}
			System.out.print(stringBuilder);

			System.out.println("");
			T--;
		}
	}

	public static void printLeaders(int[] arr) {
		int size = arr.length;
		List<Integer> leadersInReverse = new ArrayList<>();
		// Initialize the maxFromRight as rightmost element
		int maxFromRight = arr[size - 1];
		leadersInReverse.add(maxFromRight);
		//System.out.format("%d ", maxFromRight);

		// The trick is to move from right
		for (int i = size - 2; i >= 0; i--) {
			if (maxFromRight <= arr[i]) {
				//System.out.format("%d ", arr.get(i));
				leadersInReverse.add(arr[i]);
				maxFromRight = arr[i];
			}
		}
		for (int i = leadersInReverse.size() -1 ; i >= 0 ; i--) {
			System.out.print(leadersInReverse.get(i)+" ");
		}
		System.out.println("");
	}

}
