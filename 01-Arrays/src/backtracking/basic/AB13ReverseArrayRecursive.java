package backtracking.basic;

import java.util.Arrays;

/**
 * Created by root on 20/12/15.
 */
public class AB13ReverseArrayRecursive {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        reverseArrayRecursive(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /* Function to reverse arr[] from start to end */
    public static void reverseArrayRecursive(int arr[], int start, int end) {
        int temp;
        if (start >= end)
            return;
        temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        reverseArrayRecursive(arr, start + 1, end - 1);
    }
}
