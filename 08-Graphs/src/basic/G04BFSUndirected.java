package basic;

import java.util.LinkedList;
import java.util.Queue;

public class G04BFSUndirected {

	public static void main(String[] args) {
		Graph G = new Graph("tinyCG.txt");
		marked = new boolean[G.V()];
		bfs(G, 0);

	}

	private static boolean[] marked;

	// BFS from single source
	private static void bfs(Graph G, int s) {
		Queue<Integer> q = new LinkedList<Integer>();
		marked[s] = true;
		System.out.println("Visited : " + s);
		q.offer(s);

		while (!q.isEmpty()) {
			int v = q.poll();
			for (int w : G.adj(v)) {
				if (!marked[w]) {
					marked[w] = true;
					System.out.println("Visited : " + w);
					q.offer(w);
				}
			}
		}
	}

}
