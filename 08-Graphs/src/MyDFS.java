public class MyDFS {
	private boolean[] marked; // marked[v] = is there an s-v path?
	private int count; // number of vertices connected to s

	// single source
	public MyDFS(Graph G, int s) {
		marked = new boolean[G.V()];
		dfs(G, s);
	}

	// depth first search from v
	private void dfs(Graph G, int v) {
		count++;
		marked[v] = true;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				dfs(G, w);
			}
		}
	}

	// is there an s-v path?
	public boolean marked(int v) {
		return marked[v];
	}

	// number of vertices connected to s
	public int count() {
		return count;
	}

	// test client
	public static void main(String[] args) {
		Graph G = new Graph("tinyCG.txt");
		int s = 0;
		MyDFS search = new MyDFS(G, s);
		if (search.count() != G.V())
			System.out.println("NOT connected");
		else
			System.out.println("connected");
	}

}
