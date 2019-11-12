package com.hkg.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ghemant on 3/20/17.
 */
public class ATest {
    public static List<Integer> resultVertices = new ArrayList<>();
    public static boolean[] marked;
    public static void main(String[] args) {

        try {
            String line;
            BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
            line=inp.readLine();
            String[] firstline = line.split(" ");
            int n = Integer.parseInt(firstline[0]);
            marked = new boolean [n];
            int d = Integer.parseInt(firstline[1]);
            Graph graph = new Graph(n);
            for (int i = 0; i < n-1 ; i++) {
                String current = inp.readLine();
                String[] lineSplit = current.split(" ");
                int node1 = Integer.parseInt(lineSplit[0]);
                int node2 = Integer.parseInt(lineSplit[1]);
                graph.addEdge(node1-1, node2-1);
            }
            getAllVertices(graph, 0, d);
            System.out.println(resultVertices);
            System.out.println(resultVertices.size()-1);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static void getAllVertices(Graph graph, int start, int distance ){
        if (distance == 0){
            if(!marked[start]){
                marked[start] = true;
                resultVertices.add(start);
            }
        } else  {
            if(!marked[start]){
                marked[start] = true;
                resultVertices.add(start);
            }
            for (int w : graph.adj(start)) {
                getAllVertices(graph, w, distance-1);
            }
        }
        return;
    }

    public static class Graph {
        public int V;
        public int E;
        public Set<Integer>[] adj;

        public Graph(int V) {
            this.V = V;
            this.E = 0;
            adj = (Set<Integer>[]) new Set[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new HashSet<Integer>();
            }
        }

        public void addEdge(int v, int w) {
            E++;
            adj[v].add(w);
            adj[w].add(v);
        }

        public Iterable<Integer> adj(int v) {
            return adj[v];
        }

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

    }
}
