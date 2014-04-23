package com.hkg.test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
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
               /* int ver1 = new Integer(vers[0].trim());
                int ver2 = new Integer(vers[1].trim());
                addEdge(ver1, ver2);*/
            }
        } catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        }    
	}

}
