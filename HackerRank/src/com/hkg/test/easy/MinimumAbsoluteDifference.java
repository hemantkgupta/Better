package com.hkg.test.easy;

public class MinimumAbsoluteDifference {

    public static void main(String[] args) {

        int[] arr = {3, -7, 0};
        System.out.println(minimumAbsoluteDifference(arr));

    }

    // Complete the minimumAbsoluteDifference function below.
    static int minimumAbsoluteDifference(int[] arr) {

        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; i++){
            for (int j = i-1; j >= 0; j--){
                System.out.println(Math.abs(arr[i]-arr[j]));
                if ( Math.abs(arr[i]-arr[j]) < minDiff ){
                    minDiff = Math.abs(arr[i]-arr[j]);
                }
            }
        }
        return  minDiff;
    }
}
