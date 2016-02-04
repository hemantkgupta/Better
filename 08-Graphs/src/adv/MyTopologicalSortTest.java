package adv;

public class MyTopologicalSortTest {
	private Iterable<Integer> order; // topological order

	// topological sort in a digraph
	public MyTopologicalSortTest(Digraph G) {
		/*MyDirectedCycleTest finder = new MyDirectedCycleTest(G);
		if (!finder.hasCycle()) {
			G14DFSPrePostAndReversePostOrderDirected dfs = new G14DFSPrePostAndReversePostOrderDirected(
					G);
			order = dfs.reversePost();
		}*/
	}

	// topological sort in an edge-weighted digraph
	/*
	 * public Topological(EdgeWeightedDigraph G) { EdgeWeightedDirectedCycle
	 * finder = new EdgeWeightedDirectedCycle(G); if (!finder.hasCycle()) {
	 * DepthFirstOrder dfs = new DepthFirstOrder(G); order = dfs.reversePost();
	 * } }
	 */

	// return topological order if a DAG; null otherwise
	public Iterable<Integer> order() {
		return order;
	}

	// does digraph have a topological order?
	public boolean hasOrder() {
		return order != null;
	}

	public static void main(String[] args) {
		/*
		 * String filename = args[0]; String delimiter = args[1]; SymbolDigraph
		 * sg = new SymbolDigraph(filename, delimiter); Topological topological
		 * = new Topological(sg.G()); for (int v : topological.order()) {
		 * StdOut.println(sg.name(v)); }
		 */

		Digraph g = new Digraph();
		MyTopologicalSortTest topological = new MyTopologicalSortTest(g);
		if (topological.order() == null) {
			System.out.println("Cycle exists");
		} else {
			for (int v : topological.order()) {
				System.out.println(v);
			}
		}
	}

}
