package com.hkg.test;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MyDirectedGraphTest {
	
	public static void main(String[] args) {
        
        Digraph G = new Digraph();
        System.out.println(G);
        //Digraph r = G.reverse();
        //System.out.println(r);
       /* System.out.println();
        for (int i = 0; i < G.v; i++)
            for (int w : G.adj(i))
                System.out.println(i + "->" + w);*/
    }
}

class Digraph{
	
	public int v;
	public int e;
	public List<Integer>[] adj;
	
	public Digraph() {
		
		try {
			Scanner s = new Scanner(new File("D:/MyGitRepo/Job/TestProject/src/com/hkg/test/tinyDGNoCycle.txt"));
        	this.v = new Integer(s.nextLine());
        	this.e = new Integer(s.nextLine());
        	adj = (LinkedList<Integer>[]) new LinkedList[v];
 	        for (int i = 0; i < v; i++) {
 	            adj[i] = new LinkedList<Integer>();
 	        }
            while (s.hasNextLine()) {
            	String line = s.nextLine();
            	line = line.trim();
            	String[] vers = line.split("\\p{javaWhitespace}+");
                int ver1 = new Integer(vers[0]);
                int ver2 = new Integer(vers[1]);
                addEdge(ver1, ver2);
            }
        } catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        }       
    }
	
	 public Digraph(int v, int e) {
	        if (v < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
	        this.v = v;
	        this.e = e;
	        adj = (LinkedList<Integer>[]) new LinkedList[v];
	        for (int i = 0; i < v; i++) {
	            adj[i] = new LinkedList<Integer>();
	        }
	    }
	 public void addEdge(int ver1, int ver2) {
	        if (ver1 < 0 || ver1 >= v) throw new IndexOutOfBoundsException();
	        if (ver2 < 0 || ver2 >= v) throw new IndexOutOfBoundsException();
	        adj[ver1].add(ver2);
	        e++;
	    }
	 public Iterable<Integer> adj(int i) {
	        if (i < 0 || i >= v) throw new IndexOutOfBoundsException();
	        return adj[i];
	    }
	 public Digraph reverse() {
	        Digraph R = new Digraph();
	        for (int i = 0; i < v; i++) {
	            for (int w : adj(i)) {
	                R.addEdge(w, i);
	            }
	        }
	        return R;
	    }
	 public String toString() {
	        StringBuilder s = new StringBuilder();
	        String NEWLINE = System.getProperty("line.separator");
	        s.append(v + " " + e + NEWLINE);
	        for (int i = 0; i < v; i++) {
	            s.append(String.format("%d: ", i));
	            for (int w : adj[i]) {
	                s.append(String.format("%d ", w));
	            }
	            s.append(NEWLINE);
	        }
	        return s.toString();
	    }

	 
}
