package basic;

import util.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class G04BFSUndirected {

	public static void main(String[] args) {
		Graph G = new Graph("tinyCG.txt");
        System.out.println(G);
        marked = new boolean[G.V()];
		bfs(G, 0);

	}

	private static boolean[] marked;

	// BFS from single source
	private static void bfs(Graph G, int s) {
		Queue<Integer> q = new LinkedList<Integer>();
		// First mark the vertex visited
		marked[s] = true;
		System.out.println("Visited : " + s);

		// Add to queue
		q.offer(s);

		// Do until queue is not empty
		while (!q.isEmpty()) {
			// Get the first item from q
			int v = q.poll();
			// For each adjacent vertex
			for (int w : G.adj(v)) {
				// Check if it is not visited
				if (!marked[w]) {
					marked[w] = true;
					System.out.println("Visited : " + w);
					// Add to queue
					q.offer(w);
				}
			}
		}
	}

}
