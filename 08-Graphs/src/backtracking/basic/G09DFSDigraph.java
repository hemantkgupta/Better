package backtracking.basic;

import adv.Digraph;

public class G09DFSDigraph {

	public static void main(String[] args) {
		Digraph G = new Digraph("tinyDG.txt");
		marked = new boolean[G.V()];
		dfsDigraph(G, 0);
	}

	private static boolean[] marked;

	public static void dfsDigraph(Digraph G, int v) {
		marked[v] = true;
		System.out.println("visited: " + v);
		for (int w : G.adj(v)) {
			if (!marked[w])
				dfsDigraph(G, w);
		}
	}

}
