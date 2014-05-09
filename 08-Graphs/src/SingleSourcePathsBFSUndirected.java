import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;


public class SingleSourcePathsBFSUndirected {

	public static void main(String[] args) {
		Graph G = new Graph("tinyCG.txt");
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		bfs(G,0);
		

	}
	
	private static final int INFINITY = Integer.MAX_VALUE;
	private static boolean[] marked; // marked[v] = is there an s-v path
	private static int[] edgeTo; // edgeTo[v] = previous edge on shortest s-v path

	// BFS from single soruce
	private static void bfs(Graph G, int s) {
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
	
	// shortest path bewteen s (or sources) and v; null if no such path
		public Iterable<Integer> pathTo(int v) {
			
			// Stack<Integer> path = new Stack<Integer>();
			Deque<Integer> path = new ArrayDeque<Integer>();
			int x;
			for (x = v; x != 0; x = edgeTo[x])
				path.push(x);
			path.push(x);
			return path;
		}

}
