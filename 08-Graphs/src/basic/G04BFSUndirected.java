package basic;

import util.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class G04BFSUndirected {

	private static boolean[] marked;

	public static void main(String[] args) {
		Graph G = new Graph("tinyCG.txt");
        System.out.println(G);
        marked = new boolean[G.V()];
		bfs(G, 0);

	}

	// BFS from single source
	private static void bfs(Graph G, int s) {
		Queue<Integer> q = new LinkedList<Integer>();

		// First visti the vertex
		System.out.println("Visited : " + s);
		// Mark the vertex visited
		marked[s] = true;

		// Add the vertix to the queue
		q.offer(s);

		// Do until queue is not empty
		while (!q.isEmpty()) {
			// Get the first item from queue
			int v = q.poll();
			// For each adjacent vertex
			for (int w : G.adj(v)) {
				// Check if it is not visited
				if (!marked[w]) {
					System.out.println("Visited : " + w);
					marked[w] = true;
					q.offer(w);
				}
			}
		}
	}

}
