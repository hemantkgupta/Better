package basic;

import util.Digraph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;


public class G11BFSSingleSourceAllDPathsDigraph {

    private static boolean[] marked;
    private static int[] edgeTo;
    private static int source;

	public static void main(String[] args) {
		Digraph G = new Digraph("tinyDG.txt");
        System.out.println(G);
        marked =  new boolean[G.V()];
        edgeTo = new int[G.V()];
        source = 0;
		bfsPathsDigraph(G, source);
        for (int i = 1; i < G.V(); i++) {
            System.out.println("Path to "+i+ " is "+pathTo(i));
        }
	}

    public static void bfsPathsDigraph(Digraph G, int s) {
        Queue<Integer> q = new LinkedList<Integer>();
        marked[s] = true;
        q.add(s);
        while (!q.isEmpty()) {
            int v = q.remove();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = v;
                    q.add(w);
                }
            }
        }
    }
    
    // shortest path from s (or sources) to v;
    public static Deque<Integer> pathTo(int v) {
        Deque<Integer> pathStack = new ArrayDeque<Integer>();
        int x;
        for (x = v; edgeTo[x] != 0; x = edgeTo[x])
            pathStack.push(x);
        if (!pathStack.isEmpty()){
            pathStack.push(x);
            pathStack.push(source);
        }
        return pathStack;
    }

}
