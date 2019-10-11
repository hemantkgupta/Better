package sort.basic;

import java.util.Scanner;

/**
 * Created by ghemant on 3/7/17.
 */
public class SRT01BubbleSort2 {

    public static void main(String[] args) {
       // Scanner in = new Scanner(System.in);
        //int t = in.nextInt();
        //int[] input = {3, 2, 1};
        int[] input = {1, 2, 3, 6, 5, 4};
        int[] result = sort(input);
        System.out.println("Array is sorted in "+result[0]+" swaps.");
        System.out.println("First Element: "+result[1]);
        System.out.println("Last Element: "+result[2]);

    }

    public static int[] sort (int[] a){
        int[] result = new int[3];
        int n = a.length;
        int totalSwaps =0;
        for (int i = n-1; i > 0 ; i--) {
            // Track number of elements swapped during a single array traversal
            int numberOfSwaps = 0;

            for (int j = 0; j < i; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    numberOfSwaps++;
                    totalSwaps++;
                }
            }

            // If no elements were swapped during a traversal, array is sorted
            if (numberOfSwaps == 0) {
                break;
            }
        }
        result[0] = totalSwaps;
        result[1] = a[0];
        result[2] = a[n-1];
        return result;
    }
    public static void swap(int[] a, int i, int j ){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
