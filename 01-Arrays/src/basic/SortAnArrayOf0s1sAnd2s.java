package basic;

import java.util.Scanner;

public class SortAnArrayOf0s1sAnd2s {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();

        while(T > 0) {
            int N = s.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N ; i++) {
                arr[i] = s.nextInt();
            }
            sort012(arr, arr.length);
            printArray(arr, arr.length);
            T--;
            String x = "abC";

        }
    }
    private static void sort012(int a[], int arr_size) {

        int lo = 0;
        int hi = arr_size - 1;
        int mid = 0, temp = 0;
        while (mid <= hi) {
            switch (a[mid]) {
                case 0: {
                    temp = a[lo];
                    a[lo] = a[mid];
                    a[mid] = temp;
                    lo++;
                    mid++;
                    break;
                }
                case 1:
                    mid++;
                    break;
                case 2: {
                    temp = a[mid];
                    a[mid] = a[hi];
                    a[hi] = temp;
                    hi--;
                    break;
                }
            }
        }
    }

    private static void printArray(int arr[], int arr_size) {
        int i;
        for (i = 0; i < arr_size; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
    }
}
