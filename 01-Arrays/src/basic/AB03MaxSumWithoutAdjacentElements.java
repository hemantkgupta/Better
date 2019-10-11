package basic;

/**
 * Maximum sum such that no two elements are adjacent
 * https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
 *
 * Given an array of positive numbers,
 * find the maximum sum of a subsequence with the constraint that no 2 numbers
 * in the sequence should be adjacent in the array.
 *
 * Created by hemant on 17/10/15.
 *
 */
public class AB03MaxSumWithoutAdjacentElements {

    public static void main(String[] args) {

        // 5+40+35
        int[] arr = {5,  5, 10, 40, 50, 35};
        System.out.println(FindMaxSum(arr));

    }

    /**
     * This method returns maximum sum of non-adjacent elements
     * @param arr
     * @return
     */
    public static int FindMaxSum(int arr[]){

        // Initialize inclusive with first element
        // and exclusive with 0
        int incl = arr[0]; // Max sum including the previous element
        int excl = 0; // Max sum excluding the previous element

        int excl_new;


        // Start with first element
        for (int i = 1; i < arr.length; i++){

            // Assign new exclusive based on which is big
            excl_new = (incl > excl)? incl: excl;

            // Update inclusive and exclusive
            incl = excl + arr[i];
            excl = excl_new;
        }
        return ((incl > excl)? incl : excl);
    }

}
