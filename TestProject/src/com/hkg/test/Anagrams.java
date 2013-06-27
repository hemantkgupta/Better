package com.hkg.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Anagrams {
    public static void main(String[] args) {
    //    int minGroupSize = 8;

        // Read words from file and put into a simulated multimap
        Map<String, List<String>> m = new HashMap<String, List<String>>();

        try {
        	//System.out.println(new File(".").getAbsolutePath());
            Scanner s = new Scanner(new File("D:/MyGitRepo/Job/TestProject/src/com/hkg/test/dictionary.txt"));
            while (s.hasNext()) {
                String word = s.next();
                String alpha = alphabetize(word);
                List<String> l = m.get(alpha);
                if (l == null)
                    m.put(alpha, l=new ArrayList<String>());
                l.add(word);
            }
        } catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        }
       // System.out.println(m);
        
        List<String> l2 = m.get("elmost");
        System.out.println(l2.size() + ": " + l2);
        
        // Print all permutation groups above size threshold
        /*for (List<String> l : m.values())
            if (l.size() >= minGroupSize)
                System.out.println(l.size() + ": " + l);*/
    }

    private static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}