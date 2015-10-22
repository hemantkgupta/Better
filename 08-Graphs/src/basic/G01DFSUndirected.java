package basic;

public class G01DFSUndirected {
	
	public static void main(String[] args) {
		Graph G = new Graph("tinyCG.txt");
		marked = new boolean[G.V()];
		dfs(G, 0);

	}
	
	public static boolean[] marked; 
	
	// depth first search from v
	public static void dfs(Graph G, int v) {
		
			marked[v] = true;
			System.out.println("Visited : "+ v);
			for (int w : G.adj(v)) {
				if (!marked[w]) {
					dfs(G, w);
				}
			}
		}

}