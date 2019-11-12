package com.hkg.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by ghemant on 10/18/16.
 */
public class Factorial {

    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        System.out.println(getFactorial(N));
    }
    private static int getFactorial(int n){
        if(n == 1 || n == 0){
            return 1;
        }
        return n * getFactorial(n-1);
    }
}
