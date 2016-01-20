package sort.basic;

import java.util.Arrays;

/**
 * Created by hemant on 17/10/15.
 */
public class A02MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = { 1, 3, 5, 7, 9 };
        int[] arr2 = { 2, 4, 6 };
        System.out.println(Arrays.toString(merge(arr1, arr2)));
    }

    /**
     * Program to merge two given sorted arrays and return the result array
     * @param arr1
     * @param arr2
     * @return
     */
    public static int[] merge(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int[] mergedArr = new int[m + n];
        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (arr1[i] < arr2[j]) {
                mergedArr[k] = arr1[i];
                i++;
            } else {
                mergedArr[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i < m) {
            mergedArr[k] = arr1[i];
            i++;
            k++;
        }
        while (j < n) {
            mergedArr[k] = arr2[j];
            j++;
            k++;
        }
        return mergedArr;
    }

}
