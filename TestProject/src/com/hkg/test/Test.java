package com.hkg.test;

import java.io.File;

public class Test {
	public static boolean isUniqueChars(String str) {
		if (str.length() > 256) {
			return false;
		}
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			System.out.println("Value of char (after subtracting a) is: " +val);
			if ((checker & (1 << val)) > 0) return false;
			checker |= (1 << val);
			System.out.println("Checker is: "+Integer.toBinaryString(checker));
		}
		return true;
	}
	
	public static void main(String[] args) {
		String[] words = {"abcae", "hello", "apple", "kite", "padle"};
		for (String word : words) {
			System.out.println(word + ": " + isUniqueChars(word));
		}
	}

}
