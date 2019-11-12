package com.hkg.test.hard;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayManipulation {

    public static void main(String[] args) {

        int n = 5;
        int[][] queries = {
                {1, 2, 100},
                {2, 5, 100},
                {3, 4, 100},
        };
       System.out.println(arrayManipulation(n, queries));
        // System.out.println(arrayManipulation2(n, queries));

    }
    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {

        long[] array = new long[n];

        /*IntStream.range(0,queries.length).
                forEach(i->{
                    IntStream.range(queries[i][0]-1,queries[i][1])
                            .forEach(j->array[j] = array[j]+ queries[i][2]);
                });*/
        //return Arrays.stream(array).max().getAsLong();

        IntStream.range(0,queries.length).
                forEach(i->{
                    array[queries[i][0]-1] +=queries[i][2];
                    if(queries[i][1]< n)
                        array[queries[i][1]] -=queries[i][2];
                });

        int temp = 0;
        int max = 0;

        for(int i=0;i<n;i++){

            temp += array[i];
            if(temp> max)
                max=temp;
        }

        return  max;

    }

    static long arrayManipulation2 (int n, int[][] queries){

        long[] array = new long[n+1];

        int lower;
        int upper;
        long sum;

        for(int i=0;i< queries.length;i++){

            lower=queries[i][0];
            upper=queries[i][1];
            sum=queries[i][2];

            array[lower-1] +=sum;
            array[upper] -=sum;
        }

        long max=0;
        long temp=0;

        for(int i=0;i<=n;i++){
            temp += array[i];
            if(temp> max) max=temp;
        }

        return  max;
    }
}
