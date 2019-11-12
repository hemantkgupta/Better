package com.hkg.test.easy;

public class TwoStrings {

    public static void main(String[] args) {
        String s1 = "hi";
        String s2 = "world";
        System.out.println(twoStrings(s1, s2));
    }

    static String twoStrings(String s1, String s2) {
        boolean isSubString = false;
        String result="";
        for(int i= 0; i < s1.length(); i++){
            if(s2.indexOf(s1.charAt(i)) != -1){
                isSubString = true;
                result = "YES";
                break;
            }
        }
        if(!isSubString){
            result = "NO";
        }
        return  result;

    }
}
