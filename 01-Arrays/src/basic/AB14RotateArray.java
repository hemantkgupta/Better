package basic;

import java.util.Arrays;

/**
 * Created by root on 20/12/15.
 */
public class AB14RotateArray {

    public static void main(String[] args) {
        int[] ar = { 1, 2, 3, 4, 5};//, 6, 7,8,9,10,11,12,13,14,15,16,17,18,19,20,21 };
		rotateByThreeReverese(ar,5, ar.length);
        System.out.println(Arrays.toString(ar));
        //rotateArray(ar, ar.length, 4);
    }

    public static void rotateArray(int[] array, int n, int k){
        if (n != k){
            for (int i = 1; i <= k ; i++) {
                for (int j = 0; j < n-1; j++) {
                    if ( j == 0){
                        int temp = array[n-1];
                        array[n-1] = array[0];
                        array[0] = temp;
                    } else {
                        int temp = array[j-1];
                        array[j-1] = array[j];
                        array[j] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * Left rotate an array of size n by d elements
     * @param arr
     * @param d
     * @param n
     */
    public static void rotateByThreeReverese(int arr[], int d, int n) {
        revereseArray(arr, 0, d - 1);
        revereseArray(arr, d, n - 1);
        revereseArray(arr, 0, n - 1);
    }

    public static void revereseArray(int arr[], int start, int end) {
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
