package com.hkg.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ghemant on 10/23/16.
 */
public class PrintHE {

    public static void main(String args[]) throws Exception {

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        String str = s.next();
        //hackerearth - a-2,c-1,e-2,h-2,k-1,r-2,t-1
        int[] freq = new int[7];

        for (int i = 0;i < N; i++){
            char currentChar = str.charAt(i);
            if (currentChar == 'a') {
                freq[0]++;
            } else if (currentChar == 'c') {
                freq[1]++;
            } else if (currentChar == 'e') {
                freq[2]++;
            } else if (currentChar == 'h') {
                freq[3]++;
            } else if (currentChar == 'k') {
                freq[4]++;
            } else if (currentChar == 'r') {
                freq[5]++;
            } else if (currentChar == 't') {
                freq[6]++;
            }
        }
        System.out.println(Arrays.toString(freq));
        int max = freq[0] / 2;
        for (int i = 1; i < 7; i++) {
            if ((i == 2 || i == 3 || i == 5) && (freq[i] / 2) < max) {
                max = freq[i] / 2;
            } else if (freq[i] < max) {
                max = freq[i];
            }
        }

        System.out.println(max);
    }
}
