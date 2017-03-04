package com.hkg.test;

/**
 * Created by root on 18/12/15.
 */
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
public class Solution {
    public static void main(String args[] ) throws Exception {

        Entry[] entries = new Entry[5];

        entries[0] = new Entry(1, 4);
        entries[1] = new Entry(2, 5);
        entries[2] = new Entry(9, 12);
        entries[3] = new Entry(5, 9);
        entries[4] = new Entry(5, 12);

        System.out.println(getMax(entries));


    }
    public static int getMax(Entry[] entries){

        // Array to hold entry and exit time
        int[] entryArray = new int[20];
        int[] exitArray = new int[20];

        // Add count for each entry and exit
        for (Entry e : entries){
            entryArray[e.entryTime]++;
            exitArray[e.exitTime]++;
        }
        System.out.println(Arrays.toString(entryArray));
        System.out.println(Arrays.toString(exitArray));

        int max =0;
        int current = 0;
        // For each entry add to current and
        // Get hold of max value in current
        // for each exit subtract from current
        for (int i = 1; i < 20; i++){
            current += entryArray[i];
            if (current > max){
                max = current;
            }
            current  -= exitArray[i];
        }
        return max;

    }

    static class Entry {
        public int entryTime;
        public int exitTime;

        public Entry (int entry, int exit){
            this.entryTime = entry;
            this.exitTime = exit;
        }
    }

}