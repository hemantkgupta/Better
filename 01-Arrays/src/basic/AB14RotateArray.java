package basic;

import java.util.Arrays;

/**
 * Created by root on 20/12/15.
 */
public class AB14RotateArray {

    public static void main(String[] args) {
        int[] ar = { 1, 2, 3, 4, 5, 6, 7,8,9,10,11,12,13,14,15,16,17,18,19,20,21 };
		rotateByThreeReverse(ar,5, ar.length);
        System.out.println(Arrays.toString(ar));

    }
    /**
     * Left rotate an array of size n by d elements
     * @param arr
     * @param d
     * @param n
     */
    public static void rotateByThreeReverse(int arr[], int d, int n) {
        reverseArray(arr, 0, d - 1);
        reverseArray(arr, d, n - 1);
        reverseArray(arr, 0, n - 1);
    }

    public static void reverseArray(int arr[], int start, int end) {
        int temp;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}