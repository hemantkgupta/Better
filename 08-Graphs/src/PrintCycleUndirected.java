import java.util.ArrayDeque;
import java.util.Deque;


public class PrintCycleUndirected {
	
	public static void main(String[] args) {
		Graph G = new Graph("tinyCG.txt");
		marked = new boolean[G.V()];
 	    edgeTo = new int[G.V()];
		printCycle(G, 0, 0);
		System.out.println(cycle);
	}
	
	private static  boolean[] marked;
	private static Deque<Integer> cycle = null;
	private static  int[] edgeTo;
	
	// DFS based
	public static void printCycle(Graph G, int parent, int child) {
        marked[child] = true;
        for (int w : G.adj(child)) {
        	
        	// short circuit if cycle already found
            if (cycle != null) return;

            if (!marked[w]) {
            	edgeTo[w] = child;
                printCycle(G, child, w);
            }
            else if (w != parent) {
            	System.out.println("Found cycle.");
            	cycle = new ArrayDeque<Integer>();
                for (int x = child; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(child);
            }
        }
    }
}
