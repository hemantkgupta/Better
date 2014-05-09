import java.util.ArrayDeque;
import java.util.Deque;

public class DetectCycleDigraph {

	public static void main(String[] args) {
		Digraph G = new Digraph("tinyDG.txt");
		marked = new boolean[G.V()];
		onStack = new boolean[G.V()];
		edgeTo = new int[G.V()];

		for (int v = 0; v < G.V(); v++)
			if (!marked[v])
				detectCycleDigraph(G, v);

		System.out.println(cycle);
	}

	private static boolean[] marked;
	private static int[] edgeTo;
	private static boolean[] onStack; // onStack[v] = is vertex on the stack?
	private static Deque<Integer> cycle = null;

	// DFS based
	public static void detectCycleDigraph(Digraph G, int v) {
		onStack[v] = true;
		marked[v] = true;
		for (int w : G.adj(v)) {

			// short circuit if directed cycle found
			if (cycle != null)
				return;

			// found new vertex, so recur
			else if (!marked[w]) {
				edgeTo[w] = v;
				detectCycleDigraph(G, w);
			}

			// trace back directed cycle
			else if (onStack[w]) {
				System.out.println("Got cycle.");
				cycle = new ArrayDeque<Integer>();
				for (int x = v; x != w; x = edgeTo[x]) {
					cycle.push(x);
				}
				cycle.push(w);
				cycle.push(v);
			}
		}
		// remember to change
		onStack[v] = false;
	}

}
