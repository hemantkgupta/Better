package basic;

import util.Graph;

/**
 * Created by root on 05/12/15.
 */
public class G013DFSAllPathsForGivenSToD {

    private boolean[] marked;
    private final int s;
    private int[] path;

    public static void main(String[] args) {
        Graph G = new Graph("mytestgraph.txt");
        System.out.println(G);
        G013DFSAllPathsForGivenSToD dfs = new G013DFSAllPathsForGivenSToD(
                G, 2, 3);

    }

    public G013DFSAllPathsForGivenSToD(Graph G, int source, int dest) {
        this.s = source;
        marked = new boolean[G.V()];
        path = new int[G.V()];
        dfsAllPaths(G, source, dest, 0);
    }

    // DFS based
    private void dfsAllPaths(Graph G, int source, int dest, int pathIndex) {

        marked[source] = true;
        path[pathIndex] = source;
        if (pathIndex < path.length)
            pathIndex++;

        if(source == dest){
            System.out.println("\n The path : ");
            for (int i = 0; i < pathIndex ; i++) {
                System.out.print(" " + path[i] + "");
            }
        } else {
            for (int w : G.adj(source)) {
                if (!marked[w]) {
                    dfsAllPaths(G, w, dest, pathIndex);
                }
            }
        }
        pathIndex--;
        marked[source] = false;
    }


}
