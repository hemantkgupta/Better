package basic;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Graph {
    public int V;
    public int E;
    public Set<Integer>[] adj;
    
   /**
     * Create an empty graph with V vertices.
     * @throws IllegalArgumentException if V < 0
     */
    public Graph(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be non-negative");
        this.V = V;
        this.E = 0;
        adj = (Set<Integer>[]) new Set[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new HashSet<Integer>();
        }
    }

   /**
     * Create a random graph with V vertices and E edges.
     * Expected running time is proportional to V + E.
     * @throws IllegalArgumentException if either V < 0 or E < 0
     */
    public Graph(int V, int E) {
        this(V);
        if (E < 0) throw new IllegalArgumentException("Number of edges must be non-negative");
        for (int i = 0; i < E; i++) {
            int v = (int) (Math.random() * V);
            int w = (int) (Math.random() * V);
            addEdge(v, w);
        }
    }



   /**
     * Copy constructor.
     */
    public Graph(Graph G) {
        this(G.V());
        this.E = G.E();
        for (int v = 0; v < G.V(); v++) {
            // reverse so that adjacency Set is in same order as original
            Set<Integer> reverse = new HashSet<Integer>();
            for (int w : G.adj[v]) {
                reverse.add(w);
            }
            for (int w : reverse) {
                adj[v].add(w);
            }
        }
    }

   /**
     * Return the number of vertices in the graph.
     */
    public int V() { return V; }

   /**
     * Return the number of edges in the graph.
     */
    public int E() { return E; }


   /**
     * Add the undirected edge v-w to graph.
     * @throws IndexOutOfBoundsException unless both 0 <= v < V and 0 <= w < V
     */
    public void addEdge(int v, int w) {
        if (v < 0 || v >= V) throw new IndexOutOfBoundsException();
        if (w < 0 || w >= V) throw new IndexOutOfBoundsException();
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }


   /**
     * Return the Set of neighbors of vertex v as in Iterable.
     * @throws IndexOutOfBoundsException unless 0 <= v < V
     */
    public Iterable<Integer> adj(int v) {
        if (v < 0 || v >= V) throw new IndexOutOfBoundsException();
        return adj[v];
    }


   /**
     * Return a string representation of the graph.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        String NEWLINE = System.getProperty("line.separator");
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

    /**  
     * Create a digraph from input stream.
     */
    public Graph(String filename) {
    	try {
    		String dir = System.getProperty("user.dir");
    		
    		String filePath = dir+File.separator+"08-Graphs/src/basic"+File.separator+filename;
			Scanner s = new Scanner(
					new File(filePath));
			int V = new Integer(s.nextLine());
			int E = new Integer(s.nextLine());
			if (V < 0) throw new IllegalArgumentException("Number of vertices must be non-negative");
	        this.V = V;
	        this.E = E;
	        adj = (Set<Integer>[]) new Set[V];
	        for (int v = 0; v < V; v++) {
	            adj[v] = new LinkedHashSet<Integer>();
	        }
   		    for (int e = 0; e < E; e++) {
				String line = s.nextLine();
				line = line.trim();
				String[] vers = line.split("\\p{javaWhitespace}+");
				int p = new Integer(vers[0]);
				int q = new Integer(vers[1]);
				addEdge(p, q);
			} 
   		    s.close();
		} catch (IOException e) {
			System.err.println(e);
			System.exit(1);
		}	
    
    }

  

}
