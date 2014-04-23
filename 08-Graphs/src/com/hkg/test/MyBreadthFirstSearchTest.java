package com.hkg.test;

import java.util.LinkedList;
import java.util.Queue;

public class MyBreadthFirstSearchTest {
	private boolean[] marked; // Is a shortest path to this vertex known?
	private int s;
	
	public static void main(String[] args) {
        //Graph G = new Graph(5, 7);
		Graph G = new Graph();
        System.out.println(G);
        int s=9;
        MyBreadthFirstSearchTest search = new MyBreadthFirstSearchTest(G, s);
        for (int i = 0; i < G.v; i++) {
            if (search.hasPathTo(i))
                System.out.println(i + " ");
        }
        System.out.println();
       
	}

	public MyBreadthFirstSearchTest(Graph G, int s) {
		marked = new boolean[G.v];
		this.s = s;
		bfs(G, s);
	}

	private void bfs(Graph G, int s) {
		Queue<Integer> queue = new LinkedList<Integer>();
		marked[s] = true; // Mark the source
		System.out.println("Visited node: "+s); // print source visited after marking
		queue.add(s); // and put it on the queue.
		while (!queue.isEmpty()) {
			int v = queue.remove(); // Remove next vertex from the queue.
			for (int w : G.adj(v))
				if (!marked[w]) // For every unmarked adjacent vertex,
				{
					marked[w] = true; // mark it because path is known,
					System.out.println("Visited node: "+w); //print as visited after marking
					queue.add(w); // and add it to the queue.
				}
		}
	}

	public boolean hasPathTo(int v) {
		return marked[v];
	}
	

}
