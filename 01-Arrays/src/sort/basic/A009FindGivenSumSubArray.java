package sort.basic;

/**
 * Created by hemant on 17/10/15.
 */
public class A009FindGivenSumSubArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(subArraySum(arr, arr.length, 24));
    }

    public static boolean subArraySum(int arr[], int n, int sum) {

        int currsum = arr[0], start = 0, i;

        // if currsum exceeds then remove starting element

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
