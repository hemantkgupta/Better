package com.hkg.test.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;

public class HashTablesRansomNote {

    public static void main(String[] args) {

        String[] magazine = {"two", "times", "three", "is", "not", "four", "two"};
        String[] note = {"two", "times", "Two", "is", "four"};
        checkMagazine(magazine, note);

    }


    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {

        boolean allPresent = true;
        HashMap<String, Integer> magazineMap = new HashMap<>();

        for (int i =0; i < magazine.length; i++){
            if(!magazineMap.containsKey(magazine[i])){
                magazineMap.put(magazine[i], 1);
            } else {
                magazineMap.put(magazine[i], magazineMap.get(magazine[i])+1);
            }
        }

        for (int i=0; i < note.length; i++){
            if (!magazineMap.containsKey(note[i]) || magazineMap.get(note[i]) == 0) {
                allPresent = false;
                System.out.println("No");
                break;
            } else {
                magazineMap.put(note[i], magazineMap.get(note[i])-1);
            }
        }
        if (allPresent){
            System.out.println("Yes");
        }


    }
}
