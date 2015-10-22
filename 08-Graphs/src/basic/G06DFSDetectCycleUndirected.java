package basic;

public class G06DFSDetectCycleUndirected {

	public static void main(String[] args) {
		Graph G = new Graph("tinyCG.txt");
		marked = new boolean[G.V()];
		cycle = false;
		detectCycle(G, 0, 0);
		System.out.println(cycle);
	}
	
	private static  boolean[] marked;
	private static boolean cycle;
	
	// DFS based
	public static void detectCycle(Graph G, int parent, int child) {
        marked[child] = true;
        for (int w : G.adj(child)) {

            if (!marked[w]) {
                // for w , child may be parent
                detectCycle(G, child, w);
            }
            else if (w != parent) {
               cycle=true;
            }
        }
    }
}
