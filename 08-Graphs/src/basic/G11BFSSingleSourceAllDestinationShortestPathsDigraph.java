package basic;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;


public class G11BFSSingleSourceAllDestinationShortestPathsDigraph {

	public static void main(String[] args) {
		Digraph G = new Digraph("tinyDG.txt");
		marked =  new boolean[G.V()];
	    distTo = new int[G.V()];
        edgeTo = new int[G.V()];
        for (int v = 0; v < G.V(); v++) distTo[v] = Integer.MAX_VALUE;
		bfsPathsDigraph(G, 0);
		System.out.println(pathTo(3));

	}
	
    private static boolean[] marked;  
    private static int[] edgeTo;    
    private static int[] distTo;     
	
    public static void bfsPathsDigraph(Digraph G, int s) {
        Queue<Integer> q = new LinkedList<Integer>();
        marked[s] = true;
        distTo[s] = 0;
        System.out.println("visited :"+ s);
        q.add(s);
        while (!q.isEmpty()) {
            int v = q.remove();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    System.out.println("visited :"+ w);
                    q.add(w);
                }
            }
        }
    }
    
    // shortest path from s (or sources) to v;
    public static Deque<Integer> pathTo(int v) {
        Deque<Integer> pathStack = new ArrayDeque<Integer>();
        int x;
        for (x = v; distTo[x] != 0; x = edgeTo[x])
            pathStack.push(x);
        pathStack.push(x);
        return pathStack;
    }

}
