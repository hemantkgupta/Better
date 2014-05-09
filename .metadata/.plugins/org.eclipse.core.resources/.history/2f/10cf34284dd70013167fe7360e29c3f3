package com.hkg.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyDirectedBreadthFirstPathsTest {
	  private static final int INFINITY = Integer.MAX_VALUE;
	    private boolean[] marked;  // marked[v] = is there an s->v path?
	    private int[] edgeTo;      // edgeTo[v] = last edge on shortest s->v path
	    private int[] distTo;      // distTo[v] = length of shortest s->v path

	    // single source
	    public MyDirectedBreadthFirstPathsTest(Digraph G, int s) {
	        marked = new boolean[G.v];
	        distTo = new int[G.v];
	        edgeTo = new int[G.v];
	        for (int i = 0; i < G.v; i++) distTo[i] = INFINITY;
	        bfs(G, s);
	    }

	    // multiple sources
	    public MyDirectedBreadthFirstPathsTest(Digraph G, Iterable<Integer> sources) {
	        marked = new boolean[G.v];
	        distTo = new int[G.v];
	        edgeTo = new int[G.v];
	        for (int v = 0; v < G.v; v++) distTo[v] = INFINITY;
	        bfs(G, sources);
	    }

	    // BFS from single source
	    private void bfs(Digraph G, int s) {
	        Queue<Integer> q = new LinkedList<Integer>();
	        marked[s] = true;
	        distTo[s] = 0;
	        q.add(s);
	        while (!q.isEmpty()) {
	            int v = q.remove();
	            for (int w : G.adj(v)) {
	                if (!marked[w]) {
	                    edgeTo[w] = v;
	                    distTo[w] = distTo[v] + 1;
	                    marked[w] = true;
	                    q.add(w);
	                }
	            }
	        }
	    }

	    // BFS from multiple sources
	    private void bfs(Digraph G, Iterable<Integer> sources) {
	        Queue<Integer> q = new LinkedList<Integer>();
	        for (int s : sources) {
	            marked[s] = true;
	            distTo[s] = 0;
	            q.add(s);
	        }
	        while (!q.isEmpty()) {
	            int v = q.remove();
	            for (int w : G.adj(v)) {
	                if (!marked[w]) {
	                    edgeTo[w] = v;
	                    distTo[w] = distTo[v] + 1;
	                    marked[w] = true;
	                    q.add(w);
	                }
	            }
	        }
	    }

	    // length of shortest path from s (or sources) to v
	    public int distTo(int v) {
	        return distTo[v];
	    }

	    // is there a directed path from s (or sources) to v?
	    public boolean hasPathTo(int v) {
	        return marked[v];
	    }

	    // shortest path from s (or sources) to v; null if no such path
	    public Iterable<Integer> pathTo(int v) {
	        if (!hasPathTo(v)) return null;
	        Stack<Integer> path = new Stack<Integer>();
	        int x;
	        for (x = v; distTo[x] != 0; x = edgeTo[x])
	            path.push(x);
	        path.push(x);
	        return path;
	    }

	    public static void main(String[] args) {
	        Digraph G = new Digraph();
	        // System.out.println(G);
	        int s= 3;
	        MyDirectedBreadthFirstPathsTest bfs = new MyDirectedBreadthFirstPathsTest(G, s);

	        for (int v = 0; v < G.v; v++) {
	            if (bfs.hasPathTo(v)) {
	                System.out.printf("%d to %d (%d):  ", s, v, bfs.distTo(v));
	                for (int x : bfs.pathTo(v)) {
	                    if (x == s) System.out.print("-"+ x);
	                    else        System.out.print("->" + x);
	                }
	                System.out.println();
	            }

	            else {
	                System.out.printf("%d to %d (-):  not connected\n", s, v);
	            }

	        }
	    }
}
