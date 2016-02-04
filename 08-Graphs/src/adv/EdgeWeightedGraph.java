package adv;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class EdgeWeightedGraph {
	public  int v;
    private int e;
    private Set<Edge>[] adj;
    
   /**
     * Create an empty edge-weighted graph with V vertices.
     */
    public EdgeWeightedGraph(int v) {
        if (v < 0) throw new IllegalArgumentException("Number of vertices in a Graph must be nonnegative");
        this.v = v;
        this.e = 0;
        adj = (Set<Edge>[]) new Set[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new HashSet<Edge>();
        }
    }
    

   /**
     * Create a random edge-weighted graph with V vertices and E edges.
     * The expected running time is proportional to V + E.
     */
    public EdgeWeightedGraph(int v, int e) {
    	if (v < 0) throw new IllegalArgumentException("Number of vertices in a Graph must be nonnegative");
    	if (e < 0) throw new IllegalArgumentException("Number of edges in a Graph must be nonnegative");
    	this.v = v;
        this.e = e;
        adj = (HashSet<Edge>[]) new HashSet[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new HashSet<Edge>();
        }
        for (int i = 0; i < e; i++) {
            int ver1 = (int) (Math.random() * v);
            int ver2 = (int) (Math.random() * v);
            double weight = Math.round(100 * Math.random()) / 100.0;
            Edge edge = new Edge(ver1, ver2, weight);
            addEdge(edge);
        }
        
    }

   /**
     * Create a weighted graph from input stream.
     */
    /*public EdgeWeightedGraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble;
            Edge e = new Edge(v, w, weight);
            addEdge(e);
        }
    }*/

   /**
     * Copy constructor.
     */
    public EdgeWeightedGraph(EdgeWeightedGraph G) {
        this(G.v);
        this.e = G.e;
        for (int i = 0; i < G.v; i++) {
            // reverse so that adjacency list is in same order as original
            Stack<Edge> reverse = new Stack<Edge>();
            for (Edge e : G.adj[i]) {
                reverse.push(e);
            }
            for (Edge e : reverse) {
                adj[i].add(e);
            }
        }
    }

   


   /**
     * Add the undirected edge e to this graph.
     */
    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        this.e++;
    }


   /**
     * Return the edges incident to vertex v as an Iterable.
     * To iterate over the edges incident to vertex v, use foreach notation:
     * <tt>for (Edge e : graph.adj(v))</tt>.
     */
    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

   /**
     * Return all edges in this graph as an Iterable.
     * To iterate over the edges in the graph, use foreach notation:
     * <tt>for (Edge e : G.edges())</tt>.
     */
    public Iterable<Edge> edges() {
        Set<Edge> list = new HashSet<Edge>();
        for (int i = 0; i < v; i++) {
            int selfLoops = 0;
            for (Edge e : adj(i)) {
                if (e.other(i) > i) {
                    list.add(e);
                }
                // only add one copy of each self loop
                else if (e.other(i) == i) {
                    if (selfLoops % 2 == 0) list.add(e);
                    selfLoops++;
                }
            }
        }
        return list;
    }



   /**
     * Return a string representation of this graph.
     */
    public String toString() {
        String NEWLINE = System.getProperty("line.separator");
        StringBuilder s = new StringBuilder();
        s.append(v + " " + e + NEWLINE);
        for (int i = 0; i < v; i++) {
            s.append(i + ": ");
            for (Edge e : adj[i]) {
                s.append(e + "  ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
    
    
    public EdgeWeightedGraph() {
    	try {
			Scanner s = new Scanner(new File("D:/MyGitRepo/Job/TestProject/src/com/hkg/test/tinyEWG.txt"));
        	this.v = new Integer(s.nextLine());
        	this.e = new Integer(s.nextLine());
        	adj = (HashSet<Edge>[]) new HashSet[v];
 	        for (int i = 0; i < v; i++) {
 	            adj[i] = new HashSet<Edge>();
 	        }
            while (s.hasNextLine()) {
            	String line = s.nextLine();
            	line = line.trim();
            	String[] vers = line.split("\\p{javaWhitespace}+");
                int ver1 = new Integer(vers[0]);
                int ver2 = new Integer(vers[1]);
                double weight = new Double (vers[2]);
                Edge edge = new Edge(ver1, ver2, weight);
                addEdge(edge);
            }
        } catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        }    
    }

   /**
     * Test client.
     */
    public static void main(String[] args) {
     
        EdgeWeightedGraph G = new EdgeWeightedGraph();
        System.out.println(G);
    }
}
