package basic;

import adv.Graph;

import java.util.ArrayDeque;
import java.util.Deque;

public class G05DFSSingleSourceAllDPathsUndirected {

	public static void main(String[] args) {
		Graph G = new Graph("tinyCG.txt");
		System.out.println(G);
		int s = 0;
		G05DFSSingleSourceAllDPathsUndirected dfs = new G05DFSSingleSourceAllDPathsUndirected(
				G, s);
		System.out.println(dfs.pathTo(0));
		System.out.println(dfs.pathTo(1));
		System.out.println(dfs.pathTo(2));
		System.out.println(dfs.pathTo(3));
		System.out.println(dfs.pathTo(4));
		System.out.println(dfs.pathTo(5));


	}

	public G05DFSSingleSourceAllDPathsUndirected(Graph G, int s) {
		this.s = s;
		edgeTo = new int[G.V()];
		marked = new boolean[G.V()];
		singleSourcePaths(G, s);
	}

	private boolean[] marked; // marked[v] = is there an s-v path?
	private int[] edgeTo; // edgeTo[v] = last edge on s-v path
	private final int s; // source vertex

	// DFS based
	private void singleSourcePaths(Graph G, int v) {
		marked[v] = true;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				// w has path from v
				edgeTo[w] = v;
				singleSourcePaths(G, w);
			}
		}
	}

	// is there a path between s and v?
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	

	//Traverse edgeTo and put in stack to build path
	public Deque<Integer> pathTo(int v) {
		if (!hasPathTo(v))
			return null;
		//List<Integer> path = new LinkedList<Integer>();
		Deque<Integer> pathStack = new ArrayDeque<Integer>();
		for (int x = v; x != s; x = edgeTo[x])
			pathStack.push(x);
		pathStack.push(s);
		return pathStack;
	}

}
