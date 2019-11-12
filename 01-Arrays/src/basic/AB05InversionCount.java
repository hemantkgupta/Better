package basic;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by hemant on 17/10/15.
 *
 * The program to count inversions in an array (based on merge sort)
 * The no of inversion for an element is defined as the
 * no of larger elements present before it
 */
public class AB05InversionCount {

    public static void main(String[] args) {
        //int[] arr = {1, 1, 1, 2, 2,};
        int[] arr = {2, 1, 3, 1, 2};
        //int[] arr = {1, 2, 5, 3, 7, 8, 6, 4,};
        //int arr[] = {4, 3, 1, 2};
        //int [] arr = {1, 3, 5, 2, 4, 6, 8};
        System.out.println(mergeSort(arr,0, arr.length-1));
    }


    /**
     * The driver method for merge sort
     * @param arr
     * @param left is the start index of array
     * @param right is the end index of array
     * @return
     */

    public static int mergeSort(int arr[], int left, int right) {
        int inversionCount = 0;

        // If strictly more than one element are in array
        if (right > left) {
            int mid = (right + left) / 2;
            // Call recursively merge sort for both part
            inversionCount = mergeSort(arr, left, mid);
            inversionCount += mergeSort(arr, mid + 1, right);

            // Call the merge for sorted arrays
            inversionCount += merge(arr, left, mid + 1, right);
        }
        return inversionCount;
    }

    /**
     * The merge method for the merge sort
     * @param arr
     * @param left is the start point for first array involve in merge
     * @param mid is start point for second array involve in  in merge
     * @param right is the last point for second array involve in merge
     * @return the no of inversions find during the process
     */
    public static int merge(int arr[], int left, int mid, int right) {

        int[] temp = new int[arr.length];
        int inversionCount = 0;
        int i = left;
        int j = mid;
        int k = left;

        // Move i till end of first array
        // Move j till end of second array
        while ((i <= mid - 1) && (j <= right)) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                // all items after i in left sub-array are inverted
                inversionCount = inversionCount + (mid - i);
            }
        }
        // If first half is not finished
        while (i <= mid - 1)
            temp[k++] = arr[i++];
        // If second half is not finished
        while (j <= right)
            temp[k++] = arr[j++];

        // copy in the original array
        for (i = left; i <= right; i++)
            arr[i] = temp[i];

        return inversionCount;
    }

}
