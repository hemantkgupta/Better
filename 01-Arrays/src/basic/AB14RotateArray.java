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

<<<<<<< Updated upstream
    }
=======
    public static void rotateArray(int[] array, int n, int k){
        if (n != k){
            // For each rotation
            for (int i = 1; i <= k ; i++) {
                // Move one element at a time
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


    /* *
    *To left rotate arr[] of siz n by d
    */
    void leftRotate(int arr[], int d, int n) {
        int i, j, k, temp;
        for (i = 0; i < gcd(d, n); i++) {
            /* move i-th values of blocks */
            temp = arr[i];
            j = i;
            while (true) {
                k = j + d;
                if (k >= n)
                    k = k - n;
                if (k == i)
                    break;
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
    }

    /* *
    *    To get gcd of a and b
    */
    int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

>>>>>>> Stashed changes
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
