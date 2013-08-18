package com.hkg.test;

import java.util.Stack;

public class MyDirectedDepthFirstPathsTest {
	 private boolean[] marked;  // marked[v] = true if v is reachable from s
	    private int[] edgeTo;      // edgeTo[v] = last edge on path from s to v
	    private final int s;       // source vertex

	    // single source
	    public MyDirectedDepthFirstPathsTest(Digraph G, int s) {
	        marked = new boolean[G.v];
	        edgeTo = new int[G.v];
	        this.s = s;
	        dfs(G, s);
	    }


	    private void dfs(Digraph G, int v) { 
	        marked[v] = true;
	        for (int w : G.adj(v)) {
	            if (!marked[w]) {
	                edgeTo[w] = v;
	                dfs(G, w);
	            }
	        }
	    }

	    // is there a directed path from s to v?
	    public boolean hasPathTo(int v) {
	        return marked[v];
	    }

	    // return path from s to v; null if no such path
	    public Iterable<Integer> pathTo(int v) {
	        if (!hasPathTo(v)) return null;
	        Stack<Integer> path = new Stack<Integer>();
	        for (int x = v; x != s; x = edgeTo[x])
	            path.push(x);
	        path.push(s);
	        return path;
	    }

	    public static void main(String[] args) {
	        Digraph G = new Digraph();
	        // Sytem.out.println(G);
	        int s = 0;
	        MyDirectedDepthFirstPathsTest dfs = new MyDirectedDepthFirstPathsTest(G, s);

	        for (int v = 0; v < G.v; v++) {
	            if (dfs.hasPathTo(v)) {
	                System.out.printf("%d to %d:  ", s, v);
	                for (int x : dfs.pathTo(v)) {
	                    if (x == s) System.out.print("-"+x);
	                    else        System.out.print("-" + x);
	                }
	                System.out.println();
	            }

	            else {
	                System.out.printf("%d to %d:  not connected\n", s, v);
	            }

	        }
	    }
}
