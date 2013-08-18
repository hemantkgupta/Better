package com.hkg.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyBreadthFirstPathsTest2 {
    private static final int INFINITY = Integer.MAX_VALUE;
    private boolean[] marked;  // marked[v] = is there an s-v path
    private int[] edgeTo;      // edgeTo[v] = previous edge on shortest s-v path
    private int[] distTo;      // distTo[v] = number of edges shortest s-v path

    // single source
    public MyBreadthFirstPathsTest2(Graph G, int s) {
        marked = new boolean[G.v];
        distTo = new int[G.v];
        edgeTo = new int[G.v];
        bfs(G, s);

        assert check(G, s);
    }

    // multiple sources
    public MyBreadthFirstPathsTest2(Graph G, Iterable<Integer> sources) {
        marked = new boolean[G.v];
        distTo = new int[G.v];
        edgeTo = new int[G.v];
        for (int v = 0; v < G.v; v++) distTo[v] = INFINITY;
        bfs(G, sources);
    }


    // BFS from single soruce
    private void bfs(Graph G, int s) {
        Queue<Integer> q = new LinkedList<Integer>();
        for (int v = 0; v < G.v; v++) distTo[v] = INFINITY;
        distTo[s] = 0;
        marked[s] = true;
        q.add(s);

        while (!q.isEmpty()) {
            int v = q.remove();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.add(w);
                }
            }
        }
    }

    // BFS from multiple sources
    private void bfs(Graph G, Iterable<Integer> sources) {
        Queue<Integer> q = new LinkedList<Integer>();
        for (int s : sources) {
            marked[s] = true;
            distTo[s] = 0;
            //q.enqueue(s);
            q.add(s);
        }
        while (!q.isEmpty()) {
            int v = q.remove();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.add(w);
                }
            }
        }
    }

    // is there a path between s (or sources) and v?
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    // length of shortest path between s (or sources) and v
    public int distTo(int v) {
        return distTo[v];
    }

    // shortest path bewteen s (or sources) and v; null if no such path
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        int x;
        for (x = v; distTo[x] != 0; x = edgeTo[x])
            path.push(x);
        path.push(x);
        return path;
    }


    // check optimality conditions for single source
    private boolean check(Graph G, int s) {

        // check that the distance of s = 0
        if (distTo[s] != 0) {
            System.out.println("distance of source " + s + " to itself = " + distTo[s]);
            return false;
        }

        // check that for each edge v-w dist[w] <= dist[v] + 1
        // provided v is reachable from s
        for (int v = 0; v < G.v; v++) {
            for (int w : G.adj(v)) {
                if (hasPathTo(v) != hasPathTo(w)) {
                    System.out.println("edge " + v + "-" + w);
                    System.out.println("hasPathTo(" + v + ") = " + hasPathTo(v));
                    System.out.println("hasPathTo(" + w + ") = " + hasPathTo(w));
                    return false;
                }
                if (hasPathTo(v) && (distTo[w] > distTo[v] + 1)) {
                    System.out.println("edge " + v + "-" + w);
                    System.out.println("distTo[" + v + "] = " + distTo[v]);
                    System.out.println("distTo[" + w + "] = " + distTo[w]);
                    return false;
                }
            }
        }

        // check that v = edgeTo[w] satisfies distTo[w] + distTo[v] + 1
        // provided v is reachable from s
        for (int w = 0; w < G.v; w++) {
            if (!hasPathTo(w) || w == s) continue;
            int v = edgeTo[w];
            if (distTo[w] != distTo[v] + 1) {
                System.out.println("shortest path edge " + v + "-" + w);
                System.out.println("distTo[" + v + "] = " + distTo[v]);
                System.out.println("distTo[" + w + "] = " + distTo[w]);
                return false;
            }
        }

        return true;
    }


    // test client
    public static void main(String[] args) {
        //Graph G = new Graph(10,15);
        Graph G = new Graph();
        // System.out.println(G);

        MyBreadthFirstPathsTest2 bfs = new MyBreadthFirstPathsTest2(G, 0);
        
        for (int i = 0; i < G.v; i++) {
            if (bfs.hasPathTo(i)) {
                System.out.printf("%d to %d (%d):  ", 0, i, bfs.distTo(i));
                for (int x : bfs.pathTo(i)) {
                    if (x == 0) System.out.print("-"+x);
                    else        System.out.print("-" + x);
                }
                System.out.println();
            }

            else {
                System.out.printf("%d to %d (-):  not connected\n", 0, i);
            }

        }
    }

}
