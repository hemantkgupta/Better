import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MyBFS {
	private static final int INFINITY = Integer.MAX_VALUE;
	private boolean[] marked; // marked[v] = is there an s-v path
	private int[] edgeTo; // edgeTo[v] = previous edge on shortest s-v path

	// single source
	public MyBFS(Graph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		bfs(G, s);

	}

	// multiple sources
	public MyBFS(Graph G, Iterable<Integer> sources) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		bfs(G, sources);
	}

	// BFS from single soruce
	private void bfs(Graph G, int s) {
		Queue<Integer> q = new LinkedList<Integer>();

		marked[s] = true;

		q.offer(s);

		while (!q.isEmpty()) {
			int v = q.poll();
			for (int w : G.adj(v)) {
				if (!marked[w]) {
					edgeTo[w] = v;
					marked[w] = true;
					q.offer(w);
				}
			}
		}
	}

	// BFS from multiple sources
	private void bfs(Graph G, Iterable<Integer> sources) {
		Queue<Integer> q = new LinkedList<Integer>();
		for (int s : sources) {
			marked[s] = true;
			q.offer(s);
		}
		while (!q.isEmpty()) {
			int v = q.poll();
			for (int w : G.adj(v)) {
				if (!marked[w]) {
					edgeTo[w] = v;
					marked[w] = true;
					q.offer(w);
				}
			}
		}
	}

	// is there a path between s (or sources) and v?
	public boolean hasPathTo(int v) {
		return marked[v];
	}

	// shortest path bewteen s (or sources) and v; null if no such path
	public Iterable<Integer> pathTo(int v) {
		if (!hasPathTo(v))
			return null;
		// Stack<Integer> path = new Stack<Integer>();
		Deque<Integer> path = new ArrayDeque<Integer>();
		int x;
		for (x = v; edgeTo[x] != 0; x = edgeTo[x])
			path.push(x);
		path.push(x);
		return path;
	}

	// test client
	public static void main(String[] args) {
		Graph G = new Graph("tinyCG.txt");
		System.out.println(G);
		int s = 0;
		MyBFS bfs = new MyBFS(G, s);

		for (int v = 0; v < G.V(); v++) {
			if (bfs.hasPathTo(v)) {
				System.out.printf("%d to %d :  ", s, v);
				for (int x : bfs.pathTo(v)) {
					if (x == s)
						System.out.print(x);
					else
						System.out.print("-" + x);
				}
				System.out.println();
			}

			else {
				System.out.printf("%d to %d (-):  not connected\n", s, v);
			}

		}
	}

}
