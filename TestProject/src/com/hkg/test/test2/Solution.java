package com.hkg.test.test2;

/**
 * Created by ghemant on 10/16/16.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int n = in.nextInt();
        int n=4;
        for (int j = 1; j <= n; j++) {
            printline(n-j,j);
        }
    }
    private static void printline(int spaces, int hashs){
        for (int j = 1; j <= spaces; j++) {
            System.out.print(" ");
        }
        for (int j = 1; j <= hashs; j++) {
            if(j != hashs){
                System.out.print("#");
            } else {
                System.out.print("#\n");
            }

        }
    }




}