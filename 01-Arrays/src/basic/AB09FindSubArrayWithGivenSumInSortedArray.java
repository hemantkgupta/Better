package basic;

/**
 * Created by hemant on 17/10/15.
 */
<<<<<<< Updated upstream:01-Arrays/src/basic/AB09FindSubArrayWithGivenSumInSortedArray.java
public class AB09FindSubArrayWithGivenSumInSortedArray {
=======
public class AB09FindGivenSumSubArrayInSortedArray {
>>>>>>> Stashed changes:01-Arrays/src/basic/AB09FindGivenSumSubArrayInSortedArray.java
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(subArraySum(arr, arr.length, 24));
    }

    /** Start by saving the first element of the sorted array in a variable to represent
     *  the current-sum and index of this in a variable start.
     *  Now loop through the array and first test if the current-sum is
     *  more than the given sum and start index is less than the current loop index.
     *  If yes then subtract the element at start index from current-sum
     *  and update the start index. Once out of this test, check for the current-sum
     *
     */
     public static boolean subArraySum(int arr[], int n, int sum) {

        int currsum = arr[0], start = 0, i;

        for (i = 1; i <= n; i++) {
            while (currsum > sum && start < i - 1) {
                currsum = currsum - arr[start];
                start++;
            }
            if (currsum == sum) {
                System.out.printf("Sum idx %d and %d\n", start, i - 1);
                return true;
            }
            if (i < n)
                currsum = currsum + arr[i];
        }
        System.out.printf("No subarray found");
        return false;
    }

}
