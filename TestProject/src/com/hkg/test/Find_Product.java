package com.hkg.test;

import java.util.Scanner;

/**
 * Created by ghemant on 10/18/16.
 */
public class Find_Product {
    public static void main(String args[] ) throws Exception {


        //Scanner
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        long mul = (long)1e9 + 7;
        long answer = 1;
        for (int i = 0; i < N; i++) {
            long val = s.nextLong();
            answer = (answer * val)%mul;
        }
        System.out.println(answer);
    }
}
