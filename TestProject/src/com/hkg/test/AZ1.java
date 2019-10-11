package com.hkg.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ghemant on 10/16/16.
 */
public class AZ1 {
    public static void main(String[] args) {

        //Scanner
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        List<Long> numbers = new ArrayList<Long>(T);
        List<Long> results =  new ArrayList<Long>(T);

        for (int i = 0; i < T; i++) {
            long N =  s.nextInt();
            numbers.add(N);
        }



        for (int i = 0; i < T; i++) {
            long target = numbers.get(i);
            long start = 0;
            long count = 0;
            while(count != target){
                start++;
                if (isBinaryPalindrome(start)){
                    count++;
                }
            }
            results.add(start);
        }

        for (int i = 0; i < T; i++) {
            System.out.println(results.get(i));
        }

    }



    private static boolean isBinaryPalindrome(long n){
        if(n == 1 || n == 3 || n== 5 || n == 7 )
            return true;
        if ( n== 2 || n == 4 || n == 6 || n == 8)
            return false;
        String binary = Long.toBinaryString(n);
        int strlen = binary.length();
        int midIndex = strlen/2 -1;
        for (int i = 0; i <= midIndex ; i++) {
            if(binary.charAt(i) != binary.charAt(strlen - (i+1)) ){
                return false;
            }
        }
        return true;
    }
}
