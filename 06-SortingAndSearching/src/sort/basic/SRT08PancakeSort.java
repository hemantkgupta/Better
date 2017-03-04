package sort.basic;

import java.util.Arrays;

/**
 * Created by root on 12/12/15.
 */


public class SRT08PancakeSort {
    /**
     * For i = n-1 to 1 (where n is length of the array) do following steps:
       1. Find the index of the maximum element in the array.
       2. Flip array[0..maxIdx] to move ith max element to first position
       3. Flip array[0..i] to move ith max element to ith position
     * @param array
     */

    public static void pancakeSort(int[] array) {
        int n = array.length;
        for(int i = n-1; i > 0; i--) {
            int maxIdx = getMaxValueIndex(array, i);    // Find (n-i)th max element
            if(maxIdx != i) {  // If max value is not in end
                if(maxIdx != 0) {  // flip not needed if max is at start
                    flip(array, maxIdx);    // Flip array[0...maxIdx] to move ith max element to first position
                }
                flip(array, i);     // Flip array[0...i-1] to move ith max element to ith position
            }
        }
    }

    // Flip operation
    private static void flip(int[] array, int end) {
        int start = 0;
        while(start < end) {
            swap(array, start, end);
            start++;
            end--;
        }
    }

    private static void swap(int[] array, int start, int end) {
        int tmp = array[start];
        array[start] = array[end];
        array[end] = tmp;
    }

    private static int getMaxValueIndex(int[] array, int end) {
        int max = 0;
        for(int i = 1; i <= end; i++) {
            if(array[max] < array[i]) {
                max = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {4,1,2,5,3};
        pancakeSort(array);
        System.out.println(Arrays.toString(array));
    }
}