package basic;

import java.util.Arrays;

public class AB08Segregate0And1 {

	public static void main(String[] args) {
		int arr[] = { 0, 1, 0, 1, 1, 1 };
		segregate0and1(arr);
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * The solution is loosely based on the concept of quick sort.
	 * Create two variable to hold start index and end index of the array.
	 * Move first variable forward until 1 is encountered and move second variable backward until 0 is encountered.
     * Now if first variable is less then second then swap values and
	 * increase the variables in their direction.
	 * This process has to be continued until both variables cross each other.

	 * @param arr
	 */
	public static void segregate0and1(int arr[]) {
		int left = 0, right = arr.length-1;

		while (left < right) {
			while (arr[left] == 0 && left < right)
				left++;
			while (arr[right] == 1 && left < right)
				right--;
			if (left < right) {
				arr[left] = 0;
				arr[right] = 1;
				left++;
				right--;
			}
		}
	}

}
