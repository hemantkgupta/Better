package com.hkg.test.medium;

import java.util.Arrays;

public class NewYearChaos {

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 3, 4};
        int[] arr2 = {1, 2, 5, 3, 7, 8, 6, 4};
        System.out.println(getSwaps(arr2));
        Arrays.stream(arr2).forEach(System.out::println);

    }

    public static int getSwaps(int[] q){
        int swaps = 0;
        boolean isSwapped = false;
        for(int i = q.length-1; i > 0 ; i--){
            for(int j= 0; j < i; j++){
                if (q[j] > q[j+1]){
                    swap(q, j, j+1);
                    swaps++;
                    isSwapped = true;
                }
            }
            if (isSwapped){
                isSwapped = false;
            }else {
                break;
            }
        }
        return swaps;
    }
    public static void swap(int[] q, int i, int j ){
        int temp = q[i];
        q[i] =   q[j];
        q[j] = temp;
    }
}
