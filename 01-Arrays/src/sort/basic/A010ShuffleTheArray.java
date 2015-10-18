package sort.basic;

import java.util.Arrays;

/**
 * Created by hemant on 17/10/15.
 */
public class A010ShuffleTheArray {
    public static void main(String[] args) {
        int[] arr = {23,1,25,78,9,34,56,7,0,2,45,63};
    }
    public static void randomize(int arr[]) {
        int n = arr.length;
        for (int i = n - 1; i > 0; i--) {
            // generate an index less than i
            int j = (int) Math.random() * i;
            swap(arr, i, j);
        }
    }
    private static  void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
