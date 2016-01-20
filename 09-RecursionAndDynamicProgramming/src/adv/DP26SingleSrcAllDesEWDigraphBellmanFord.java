package adv;

public class DP26SingleSrcAllDesEWDigraphBellmanFord {

	
	public static void main(String[] args) {

		BellmanFord(createGraph(), 0);

	}

	// Bellman-Ford algorithm also detects negative weight cycle
	public static void BellmanFord(Graph graph, int src) {
		int V = graph.V;
		int E = graph.E;
		int[] dist = new int[V];

		
		for (int i = 0; i < V; i++)
			dist[i] = Integer.MAX_VALUE;

		dist[src] = 0;

		//Relax all edges |V| - 1 times. 
		for (int i = 1; i <= V - 1; i++) {
			for (int j = 0; j < E; j++) {
				int u = graph.edge[j].src;
				int v = graph.edge[j].dest;
				int weight = graph.edge[j].weight;
				if (dist[u] + weight < dist[v])
					dist[v] = dist[u] + weight;
			}
		}

		// In second pass if we get a shorter path, then there is a cycle.
		for (int i = 0; i < E; i++) {
			int u = graph.edge[i].src;
			int v = graph.edge[i].dest;
			int weight = graph.edge[i].weight;
			if (dist[u] + weight < dist[v])
				System.out.println("Graph contains negative weight cycle");
		}

	}

	// A utility function used to print the solution
	public static void printArr(int[] dist, int n) {
		System.out.println("Vertex   Distance from Source\n");
		for (int i = 0; i < n; ++i)
			System.out.format("%d \t\t %d\n", i, dist[i]);
	}

	public static Graph createGraph() {
		Graph graph = new Graph(5, 8);

		// add edge 0-1 (or A-B in above figure)
		graph.edge[0].src = 0;
		graph.edge[0].dest = 1;
		graph.edge[0].weight = -1;

		// add edge 0-2 (or A-C in above figure)
		graph.edge[1].src = 0;
		graph.edge[1].dest = 2;
		graph.edge[1].weight = 4;

		// add edge 1-2 (or B-C in above figure)
		graph.edge[2].src = 1;
		graph.edge[2].dest = 2;
		graph.edge[2].weight = 3;

		// add edge 1-3 (or B-D in above figure)
		graph.edge[3].src = 1;
		graph.edge[3].dest = 3;
		graph.edge[3].weight = 2;

		// add edge 1-4 (or A-E in above figure)
		graph.edge[4].src = 1;
		graph.edge[4].dest = 4;
		graph.edge[4].weight = 2;

		// add edge 3-2 (or D-C in above figure)
		graph.edge[5].src = 3;
		graph.edge[5].dest = 2;
		graph.edge[5].weight = 5;

		// add edge 3-1 (or D-B in above figure)
		graph.edge[6].src = 3;
		graph.edge[6].dest = 1;
		graph.edge[6].weight = 1;

		// add edge 4-3 (or E-D in above figure)
		graph.edge[7].src = 4;
		graph.edge[7].dest = 3;
		graph.edge[7].weight = -3;

		return graph;
	}

}

class Edge {

	public int src;
	public int dest;
	public int weight;

	public Edge(int src, int dest, int weight) {
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}

}

class Graph {

	public Edge[] edge;
	public int V;
	public int E;

	public Graph(int V, int E) {
		this.V = V;
		this.E = E;
		edge = new Edge[E];
		for (int i = 0; i < edge.length; i++) {
			Edge edge = new Edge(0, 0, 0);
			this.edge[i] = edge;
		}
	}

}
