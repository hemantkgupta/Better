package basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Find a pair of elements in an array whose sum is a given number
 */
public class A01FindTwoElementsWithFixedSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = { 1, 4, 45, 6, 10, -8 };
		System.out.println(hasArrayTwoCandidates(A,16));
		System.out.println(Arrays.toString(twoSum(A,16)));

	}
	
	/**
	 * First sort the array. Now create two variables to hold start index and end index of the array.
	 * Calculate the sum of elements at these indexes
	 * and move them until they cross each other or sum is found.
	 * @param A
	 * @param sum
	 * @return
	 */

	public static boolean hasArrayTwoCandidates(int[] A, int sum) {

		Arrays.sort(A);
		int l = 0;
		int r = A.length - 1;
		while (l < r) {
			if (A[l] + A[r] == sum)
				return true;
			else if (A[l] + A[r] < sum)
				l++;
			else
				r--;
		}
		return false;
	}

	/**
	 * Save the difference with sum for an element as key and its index in the array +1 as value in a map.
	 * Before adding the elements to map check if the value is present in the map.
	 * The lower index is returned first
	 * @param numbers
	 * @param target
	 * @return
	 */
	public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int temp = target - numbers[i];
            if (map.containsKey(temp)) {
            	int index1 = i+1;
                int index2 =  map.get(temp)+1;
                if(index1 < index2){
                	result[0] = index1;
                	result[1] = index2;
                }else{
                	result[1] = index1;
                	result[0] = index2;
                }

            }
            map.put(numbers[i], i);
        }
        return result;
    }


}
