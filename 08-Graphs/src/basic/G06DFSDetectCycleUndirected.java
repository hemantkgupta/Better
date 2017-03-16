package basic;

import util.Graph;

public class G06DFSDetectCycleUndirected {

	public static void main(String[] args) {
		Graph G = new Graph("tinyCG.txt");
        System.out.println(G);
        marked = new boolean[G.V()];
		cycle = false;
		detectCycle(G, 0, 0);
		System.out.println("Is graph cyclic? : "+cycle);
	}
	
	private static  boolean[] marked;
	private static boolean cycle;
	
	// DFS based
	public static void detectCycle(Graph G, int parent, int child) {
        marked[child] = true;
        // For each adjacent node
        for (int w : G.adj(child)) {
            // Check if it is not visited
            if (!marked[w]) {
                detectCycle(G, child, w);
            } else if (w != parent) { // If visited adjacent is not parent the cycle is formed
               cycle=true;
            }
        }
    }
}
