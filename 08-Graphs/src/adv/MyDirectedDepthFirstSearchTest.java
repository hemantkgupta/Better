package adv;

import java.util.ArrayList;
import java.util.List;

public class MyDirectedDepthFirstSearchTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		  Digraph G = new Digraph();
		  //MyDirectedDepthFirstSerachTest dfs = new MyDirectedDepthFirstSerachTest(G,2);
		  List<Integer> l = new  ArrayList<Integer>();
		  l.add(1);
		  l.add(2);
		  l.add(6);
		  MyDirectedDepthFirstSearchTest dfs = new MyDirectedDepthFirstSearchTest(G, l);
		  
		  for (int i = 0; i < G.v; i++) {
	            if (dfs.marked(i)) System.out.println(i + " ");
	       }
	       System.out.println();
	}

	private boolean[] marked; // marked[v] = true if v is reachable

	// from source (or sources)

	// single-source reachability
	public MyDirectedDepthFirstSearchTest(Digraph G, int s) {
		marked = new boolean[G.v];
		dfs(G, s);
	}

	// multiple-source reachability
	public MyDirectedDepthFirstSearchTest(Digraph G, Iterable<Integer> sources) {
		marked = new boolean[G.v];
		for (int v : sources)
			dfs(G, v);
	}

	private void dfs(Digraph G, int v) {
		marked[v] = true;
		for (int w : G.adj(v)) {
			if (!marked[w])
				dfs(G, w);
		}
	}

	// is there a directed path from the source (or sources) to v?
	public boolean marked(int v) {
		return marked[v];
	}

}
