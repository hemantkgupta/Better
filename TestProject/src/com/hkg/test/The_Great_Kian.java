package com.hkg.test;

import java.util.Scanner;

/**
 * Created by ghemant on 10/18/16.
 */
public class The_Great_Kian {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int a1=0,a2=0,a3=0;
        int freq = 0;
            if (N%3 == 0){
                freq = N/3;
            } else {
                freq = N/3 +1;
            }
        System.out.println("The freq is " + freq );
        for (int i = 1; i <= freq; i++) {
            a1 += s.nextInt();
            System.out.println("a1 is "+ a1);
            if(s.hasNextInt()){
                a2 += s.nextInt();
                System.out.println("a2 is "+ a2);
            } else {
                System.out.println("breaking in a2");
                break;
            }
            if(s.hasNextInt()){
                a3 += s.nextInt();
                System.out.println("a3 is "+ a3);
            } else {
                System.out.println("breaking in a3");
                break;
            }
        }
        System.out.println("for result");
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
    }
}
