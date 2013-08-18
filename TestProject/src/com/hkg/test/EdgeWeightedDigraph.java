package com.hkg.test;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class EdgeWeightedDigraph {
	
	public int v;
    public int e;
    private Set<DirectedEdge>[] adj;
    
    /**
     * Create an empty edge-weighted digraph with V vertices.
     */
    public EdgeWeightedDigraph(int v) {
        if (v < 0) throw new RuntimeException("Number of vertices must be nonnegative");
        this.v = v;
        this.e = 0;
        adj = (HashSet<DirectedEdge>[]) new HashSet[v];
        for (int i = 0; i < v; i++)
            adj[i] = new HashSet<DirectedEdge>();
    }

   /**
     * Create a edge-weighted digraph with V vertices and E edges.
     */
    public EdgeWeightedDigraph(int v, int e) {
    	if (v < 0) throw new RuntimeException("Number of vertices must be nonnegative");
    	if (e < 0) throw new RuntimeException("Number of edges must be nonnegative");
        this.v = v;
        this.e = e;
        adj = (HashSet<DirectedEdge>[]) new HashSet[v];
        for (int i = 0; i < v; i++)
            adj[i] = new HashSet<DirectedEdge>();
        for (int i = 0; i < e; i++) {
            int ver1 = (int) (Math.random() * v);
            int ver2 = (int) (Math.random() * v);
            double weight = Math.round(100 * Math.random()) / 100.0;
            DirectedEdge edge = new DirectedEdge(ver1, ver2, weight);
            addEdge(edge);
        }
    }

    /**
     * Create an edge-weighted digraph from input stream.
     */
    /*public EdgeWeightedDigraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            addEdge(new DirectedEdge(v, w, weight));
        }
    }*/

   /**
     * Copy constructor.
     */
    public EdgeWeightedDigraph(EdgeWeightedDigraph G) {
        this(G.v);
        this.e = G.e;
        for (int i = 0; i < G.v; i++) {
            // reverse so that adjacency list is in same order as original
            Stack<DirectedEdge> reverse = new Stack<DirectedEdge>();
            for (DirectedEdge e : G.adj[i]) {
                reverse.push(e);
            }
            for (DirectedEdge e : reverse) {
                adj[i].add(e);
            }
        }
    }

   


   /**
     * Add the directed edge e to this digraph.
     */
    public void addEdge(DirectedEdge e) {
        int v = e.from();
        adj[v].add(e);
        this.e++;
    }


   /**
     * Return the edges incident from vertex v as an Iterable.
     * To iterate over the edges incident from vertex v in digraph G, use foreach notation:
     * <tt>for (DirectedEdge e : G.adj(v))</tt>.
     */
    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

   /**
     * Return all edges in this digraph as an Iterable.
     * To iterate over the edges in the digraph, use foreach notation:
     * <tt>for (DirectedEdge e : G.edges())</tt>.
     */
    public Iterable<DirectedEdge> edges() {
        Set<DirectedEdge> list = new HashSet<DirectedEdge>();
        for (int v = 0; v < v; v++) {
            for (DirectedEdge e : adj(v)) {
                list.add(e);
            }
        }
        return list;
    } 

   /**
     * Return number of edges incident from v.
     */
    public int outdegree(int v) {
        return adj[v].size();
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
            for (DirectedEdge e : adj[i]) {
                s.append(e + "  ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

    public EdgeWeightedDigraph() {
    	try {
			Scanner s = new Scanner(new File("D:/MyGitRepo/Job/TestProject/src/com/hkg/test/tinyEWD.txt"));
        	this.v = new Integer(s.nextLine());
        	this.e = new Integer(s.nextLine());
        	adj = (HashSet<DirectedEdge>[]) new HashSet[v];
 	        for (int i = 0; i < v; i++) {
 	            adj[i] = new HashSet<DirectedEdge>();
 	        }
            while (s.hasNextLine()) {
            	String line = s.nextLine();
            	line = line.trim();
            	String[] vers = line.split("\\p{javaWhitespace}+");
                int ver1 = new Integer(vers[0]);
                int ver2 = new Integer(vers[1]);
                double weight = new Double (vers[2]);
                DirectedEdge edge = new DirectedEdge(ver1, ver2, weight);
                addEdge(edge);
            }
        } catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        }    
    }

}
