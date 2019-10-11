package basic;

import util.Graph;

/**
 * Start DFS from any vertex and increase a counter each time a vertex is visited.
 * Finally counter should have a value equal to no of vertex to be connected if
 * the the graph is connected.
 */
public class G02DFSUndirectedConnectedTest {

    public static boolean[] marked;
    public static int count;


	public static void main(String[] args) {
		Graph G = new Graph("tinyCG.txt");
		System.out.println(G);

		marked = new boolean[G.V()];

		connectedDFS(G, 1);

        if (count != G.V())
			System.out.println("NOT connected");
		else
			System.out.println("connected");

	}

	// DFS based
	public static void connectedDFS(Graph G, int v) {
		marked[v] = true;
		count++;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				connectedDFS(G, w);
			}
		}
	}

}
