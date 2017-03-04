package com.hkg.test;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MyEdgeWeightedGraphTest {
	
	public static void main(String[] args){
		
		SimpleEdgeWeightedGraph g = new SimpleEdgeWeightedGraph(10, 25);
		System.out.println(g);
	}
}

class SimpleEdgeWeightedGraph {
    private final int v;
    private int e;
    private Set<SimpleEdge>[] adj;
    
   /**
     * Create an empty edge-weighted graph with V vertices.
     */
    public SimpleEdgeWeightedGraph(int v) {
        if (v < 0) throw new IllegalArgumentException("Number of vertices in a Graph must be nonnegative");
        this.v = v;
        this.e = 0;
        adj = (Set<SimpleEdge>[]) new Set[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new HashSet<SimpleEdge>();
        }
    }

   /**
     * Create a random edge-weighted graph with V vertices and E edges.
     * The expected running time is proportional to V + E.
     */
    public SimpleEdgeWeightedGraph(int v, int e) {
        this(v);
        if (e < 0) throw new IllegalArgumentException("Number of edges in a Graph must be nonnegative");
        for (int i = 0; i < e; i++) {
            int ver1 = (int) (Math.random() * v);
            int ver2 = (int) (Math.random() * v);
            int weight = (int) (100 * Math.random());            
            SimpleEdge edge = new SimpleEdge(ver1, ver2, weight);
            addEdge(edge);
        }
    }

   /**
     * Create a weighted graph from input stream.
     */
   /* public EdgeWeightedGraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            Edge e = new Edge(v, w, weight);
            addEdge(e);
        }
    }*/

   /**
     * Copy constructor.
     */
    public SimpleEdgeWeightedGraph(SimpleEdgeWeightedGraph G) {
        this(G.v);
        this.e = G.e;
        for (int i = 0; i < G.v; i++) {
            // reverse so that adjacency list is in same order as original
            Stack<SimpleEdge> reverse = new Stack<SimpleEdge>();
            for (SimpleEdge e : G.adj[i]) {
                reverse.push(e);
            }
            for (SimpleEdge e : reverse) {
                adj[i].add(e);
            }
        }
    }

   /**
     * Add the undirected edge e to this graph.
     */
    public void addEdge(SimpleEdge e) {
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
    public Iterable<SimpleEdge> adj(int v) {
        return adj[v];
    }

   /**
     * Return all edges in this graph as an Iterable.
     * To iterate over the edges in the graph, use foreach notation:
     * <tt>for (Edge e : G.edges())</tt>.
     */
    public Iterable<SimpleEdge> edges() {
        Set<SimpleEdge> list = new HashSet<SimpleEdge>();
        for (int i = 0; i < v; i++) {
            int selfLoops = 0;
            for (SimpleEdge e : adj(i)) {
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
            for (SimpleEdge e : adj[i]) {
                s.append(e + "  ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}
