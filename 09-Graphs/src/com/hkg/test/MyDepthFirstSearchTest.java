package com.hkg.test;

public class MyDepthFirstSearchTest {

	public static void main(String[] args) {
		Graph G = new Graph(5, 7);
		System.out.println(G);
		MyDepthFirstSearchTest search = new MyDepthFirstSearchTest(G, 0);
		for (int i = 0; i < G.v; i++) {
			if (search.marked(i))
				System.out.println(i + " ");
		}

		System.out.println();
		if (search.count() != G.v)
			System.out.println("NOT connected");
		else
			System.out.println("connected");
	}

	private boolean[] marked; 
	private int count; // number of vertices connected to s

	// single source
	public MyDepthFirstSearchTest(Graph G, int s) {
		marked = new boolean[G.v];
		dfs(G, s);
	}

	// depth first search from v
	private void dfs(Graph G, int v) {
		count++;
		marked[v] = true;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				dfs(G, w);
			}
		}
	}

	public boolean marked(int v) {
		return marked[v];
	}

	public int count() {
		return count;
	}
}
