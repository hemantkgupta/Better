package basic;

import java.io.*;
import java.util.*;
/**
 * Created by ghemant on 3/8/17.
 */

public class Solution {
    private static boolean[] marked;
    private static int[] distTo;
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        for(int a0=0; a0 < q; a0++ ){
            int n = scan.nextInt();
            int m = scan.nextInt();
            Graph graph = new Graph(n,m);
            for(int a1=0; a1 < m; a1++){
                int u = scan.nextInt();
                int v = scan.nextInt();
                graph.addEdge(u-1, v-1);
            }
            int s = scan.nextInt();
            System.out.print(getAllShortestPath(graph, s-1)+"\n");

        }
    }

    public static String getAllShortestPath(Graph G, int s){
        initializeSolution(G);
        bfs(G,s);
        StringBuilder output = new StringBuilder();
        for(int i=0; i < G.V; i++){
            if ( i != s){
                if(distTo[i] == 0){
                    output.append("-1 ");
                }else{
                    output.append(distTo[i]+ " ");
                }
            }
        }
        return output.toString();
    }
    public static void initializeSolution(Graph G){
        marked =  new boolean[G.V];
        distTo = new int[G.V];
        for (int v = 0; v < G.V; v++){
            distTo[v] = 0;
            marked[v] = false;
        }
    }


    public static void bfs(Graph G, int s) {
        Queue<Integer> q = new LinkedList<Integer>();
        marked[s] = true;
        distTo[s] = 0;
        q.add(s);
        while (!q.isEmpty()) {
            int v = q.remove();
            for (int w : G.adj[v]) {
                if (!marked[w]) {
                    marked[w] = true;
                    distTo[w] = distTo[v] + 6;
                    q.add(w);
                }
            }
        }
    }



    static class Graph{
        public int V;
        public int E;
        public Set<Integer>[] adj;
        public Graph(int V, int E) {
            this.V = V;
            this.E = E;
            adj = (Set<Integer>[]) new Set[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new HashSet<Integer>();
            }
        }
        public void addEdge(int v, int w) {
            adj[v].add(w);
            adj[w].add(v);
        }
    }
}

