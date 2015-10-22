package basic;

import java.util.LinkedList;
import java.util.Queue;

public class G03DFSGetConnectedComponentsUndirected {


		public static void main(String[] args) {
			Graph G = new Graph(21, 11);

            G03DFSGetConnectedComponentsUndirected cc = new G03DFSGetConnectedComponentsUndirected(G);

			// number of connected components
			int n = cc.count();
			System.out.println("The graph has " + n + " components");
            System.out.println("Components details: ");

			// initialize components
			Queue<Integer>[] components = (LinkedList<Integer>[]) new LinkedList[n];
			for (int i = 0; i < n; i++) {
				components[i] = new LinkedList<Integer>();
			}

			// add vertex in components by getting the id
			for (int i = 0; i < G.V; i++) {
				components[cc.id(i)].add(i);
			}

			// print results
			for (int i = 0; i < n; i++) {
                System.out.println("The component id "+ i +" has following vertex : ");
				for (int v : components[i]) {
                    System.out.print(v + " ");
				}
				System.out.println();
			}
		}


	private boolean[] marked; // marked[v] = has vertex v been marked?
	private int[] id; // id[v] = id of connected component containing v
	private int[] size; // size[id] = number of vertices in given component
	private int count; // number of connected components

	public G03DFSGetConnectedComponentsUndirected(Graph G) {
		marked = new boolean[G.V];
		id = new int[G.V];
		size = new int[G.V];
		for (int i = 0; i < G.V; i++) {
            // Take first unvisited vertex and mark
            // all the connected vertex
			if (!marked[i]) {
				connectedComponentsDFS(G, i);
                // Now start working for new component
				count++;
			}
		}
	}

	// DFS based
	private void connectedComponentsDFS(Graph G, int v) {
		marked[v] = true;
		id[v] = count;
		size[count]++;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				connectedComponentsDFS(G, w);
			}
		}
	}

	// id of connected component containing v
	public int id(int v) {
		return id[v];
	}

	// size of connected component containing v
	public int size(int v) {
		return size[id[v]];
	}

	// number of connected components
	public int count() {
		return count;
	}

	// are v and w in the same connected component?
	public boolean areConnected(int v, int w) {
		return id(v) == id(w);
	}

	
}
