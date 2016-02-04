package basic;

import adv.Graph;

public class G01DFSUndirected {

	// Array to hold visited vertices
	public static boolean[] marked;

	public static void main(String[] args) {
		Graph G = new Graph("tinyCG.txt");
		// Make all vertices unvisited initially
		marked = new boolean[G.V()];
		dfs(G, 0);

	}


	// Depth first search starting from v
	public static void dfs(Graph G, int v) {
		    // First mark the vertex visited
			marked[v] = true;
			System.out.println("Visited : "+ v);
			for (int w : G.adj(v)) {
				// Check if vertex is not visited
				if (!marked[w]) {
					dfs(G, w);
				}
			}
		}

}
