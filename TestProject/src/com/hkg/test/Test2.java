package com.hkg.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*try {
			//Pattern WHITESPACE_PATTERN = Pattern.compile("\\p{javaWhitespace}+");
        	Scanner s = new Scanner(new File("D:/MyGitRepo/Job/TestProject/src/com/hkg/test/tinyDG.txt"));
        	System.out.println(s.nextLine());
        	System.out.println(s.nextLine());
            while (s.hasNextLine()) {
            	String line = s.nextLine();
            	//System.out.println(line);
            	line = line.trim();
            	System.out.println(line);
            	String[] vers = line.split("\\p{javaWhitespace}+");
            	System.out.println(vers[0]) ;
                System.out.println(vers[1].trim()) ;
               *//* int ver1 = new Integer(vers[0].trim());
                int ver2 = new Integer(vers[1].trim());
                addEdge(ver1, ver2);*//*
            }
        } catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        }*/

		ArrayList<ArrayList<Integer>> A = new ArrayList<>();
		ArrayList<Integer>  first =  new ArrayList<>();
		first.add(1);
		first.add(2);
		first.add(3);
		first.add(4);
		A.add(first);
		ArrayList<Integer>  second =  new ArrayList<>();
		second.add(5);
		second.add(6);
		second.add(7);
		second.add(8);
        A.add(second);
		ArrayList<Integer>  third =  new ArrayList<>();
		third.add(9);
		third.add(10);
		third.add(11);
		third.add(12);
		A.add(third);

		ArrayList<ArrayList<Integer>> B = performOps(A);
		for (int i = 0; i < B.size(); i++) {
			for (int j = 0; j < B.get(i).size(); j++) {
				System.out.print(B.get(i).get(j) + " ");
			}
		}

	}

	public static ArrayList<ArrayList<Integer>> performOps(ArrayList<ArrayList<Integer>> A) {
		ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < A.size(); i++) {
			B.add(new ArrayList<Integer>());

			for (int j = 0; j < A.get(i).size(); j++) {
				B.get(i).add(0);
			}

			for (int j = 0; j < A.get(i).size(); j++) {
				B.get(i).set(A.get(i).size() - 1 - j, A.get(i).get(j));
			}
		}
		return B;
	}


}
