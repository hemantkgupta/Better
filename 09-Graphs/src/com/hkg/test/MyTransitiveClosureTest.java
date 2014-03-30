package com.hkg.test;

public class MyTransitiveClosureTest {
	  private MyDirectedDepthFirstSearchTest[] tc;  // tc[v] = reachable from v

	    public MyTransitiveClosureTest(Digraph G) {
	        tc = new MyDirectedDepthFirstSearchTest[G.v];
	        for (int v = 0; v < G.v; v++)
	            tc[v] = new MyDirectedDepthFirstSearchTest(G, v);
	    }

	    public boolean reachable(int v, int w) {
	        return tc[v].marked(w);
	    }

	    // test client
	    public static void main(String[] args) {
	        Digraph G = new Digraph();

	        MyTransitiveClosureTest tc = new MyTransitiveClosureTest(G);

	        // print header
	        System.out.print("     ");
	        for (int v = 0; v < G.v; v++)
	            System.out.printf("%3d", v);
	        System.out.println();
	        System.out.println("--------------------------------------------");

	        // print transitive closure
	        for (int v = 0; v < G.v; v++) {
	            System.out.printf("%3d: ", v);
	            for (int w = 0; w < G.v; w++) {
	                if (tc.reachable(v, w)) System.out.printf("  T");
	                else                    System.out.printf("   ");
	            }
	            System.out.println();
	        }
	    }
}
