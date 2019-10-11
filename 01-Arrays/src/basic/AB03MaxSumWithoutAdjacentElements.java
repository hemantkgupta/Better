package basic;

/**
 * Maximum sum such that no two elements are adjacent
 * https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
 *
 * Given an array of positive numbers,
 * find the maximum sum of a sub-sequence with the constraint that no 2 numbers
 * in the sequence should be adjacent in the array.
 *
 * Created by hemant on 17/10/15.
 *
 */
public class AB03MaxSumWithoutAdjacentElements {

    public static void main(String[] args) {
        int[] arr = {5,  5, 10, 40, 50, 35};
        System.out.println(FindMaxSum(arr));
    }

    /**
     * This method returns maximum sum of non-adjacent elements
     * @param arr
     * @return
     */
    public static int FindMaxSum(int arr[]){

        // Max sum including the previous element
        // Initialize inclusive with first element
        int incl = arr[0];

        // Max sum excluding the previous element
        // Initialize exclusive with 0 to represent exclusion
        int excl = 0;

        int excl_new;

        // Start with first element
        for (int i = 1; i < arr.length; i++){

            // Find out what was max at previous index
            excl_new = (incl > excl)? incl: excl;

            // Update Current maximum including
            incl = excl + arr[i];

            // Update Current maximum excluding
            excl = excl_new;
        }
        return ((incl > excl)? incl : excl);
    }

}
