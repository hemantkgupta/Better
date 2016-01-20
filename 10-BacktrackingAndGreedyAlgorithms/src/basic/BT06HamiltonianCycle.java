package basic;

/**
 * Hamiltonian Path in an undirected graph is a path that visits each vertex exactly once.
 * A Hamiltonian cycle (or Hamiltonian circuit) is a Hamiltonian Path such that
 * there is an edge (in graph) from the last vertex to the first vertex of the Hamiltonian Path.
 * Determine whether a given graph contains Hamiltonian Cycle or not.
 */
public class BT06HamiltonianCycle {
	public static int V =5;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/* Let us create the following graph
	      (0)--(1)--(2)
	       |   / \   |
	       |  /   \  |
	       | /     \ |
	      (3)-------(4)    */
	   int[][] graph1 = {{0, 1, 0, 1, 0},
	                      {1, 0, 1, 1, 1},
	                      {0, 1, 0, 0, 1},
	                      {1, 1, 0, 0, 1},
	                      {0, 1, 1, 1, 0},
	                     };
	 
	    // Print the solution
	    hamCycle(graph1);
	 
	   /* Let us create the following graph
	      (0)--(1)--(2)
	       |   / \   |
	       |  /   \  |
	       | /     \ |
	      (3)       (4)    */
	    /*
	    bool graph2[V][V] = {{0, 1, 0, 1, 0},
	                      {1, 0, 1, 1, 1},
	                      {0, 1, 0, 0, 1},
	                      {1, 1, 0, 0, 0},
	                      {0, 1, 1, 0, 0},
	                     };

	    // Print the solution
	    hamCycle(graph2);
	    */
	}

	/* This function solves the Hamiltonian Cycle problem using Backtracking.
	  It returns false if there is no Hamiltonian Cycle possible, otherwise return true and
	  prints the path. This function prints one of the feasible solutions. */
	public static boolean hamCycle(int[][] graph)
	{
	    int[] path = new int[V];
	    for (int i = 0; i < V; i++)
	        path[i] = -1;

	    /* Let us put vertex 0 as the first vertex in the path. If there is
	       a Hamiltonian Cycle, then the path can be started from any point
	       of the cycle as the graph is undirected */
	    path[0] = 0;
	    if ( hamCycleUtil(graph, path, 1) == false )
	    {
	        System.out.println("\nSolution does not exist");
	        return false;
	    }

	    printSolution(path);
	    return true;
	}

	/* A utility function to check if the vertex v can be added at index 'pos'
	   in the Hamiltonian Cycle constructed so far (stored in 'path[]') */
	public static boolean isSafe(int v, int[][] graph, int[] path, int pos)
	{
	    /* Check if this vertex is an adjacent vertex of the previously
	       added vertex. */
	    if (graph [ path[pos-1] ][ v ] == 0)
	        return false;

	    /* Check if the vertex has already been included.
	      This step can be optimized by creating an array of size V */
	    for (int i = 0; i < pos; i++)
	        if (path[i] == v)
	            return false;

	    return true;
	}

	/* A recursive utility function to solve hamiltonian cycle problem */
	public static boolean hamCycleUtil(int[][] graph, int[] path, int vertexSofar)
	{
	    /* base case: If all vertices are included in Hamiltonian Cycle */
	    if (vertexSofar == V)
	    {
	        // And if there is an edge from the last included vertex to the
	        // first vertex
	        if ( graph[ path[vertexSofar-1] ][ path[0] ] == 1 )
	           return true;
	        else
	          return false;
	    }

	    // Try different vertices as a next candidate in Hamiltonian Cycle.
	    // We don't try for 0 as we included 0 as starting point in in hamCycle()
	    for (int v = 1; v < V; v++)
	    {
	        /* Check if this vertex can be added to Hamiltonian Cycle */
	        if (isSafe(v, graph, path, vertexSofar))
	        {
	            path[vertexSofar] = v;

	            /* recur to construct rest of the path */
	            if (hamCycleUtil (graph, path, vertexSofar+1) == true)
	                return true;

	            /* If adding vertex v doesn't lead to a solution,
	               then remove it */
	            path[vertexSofar] = -1;
	        }
	    }

	    /* If no vertex can be added to Hamiltonian Cycle constructed so far,
	       then return false */
	    return false;
	}


	/* A utility function to print solution */
	public static void printSolution(int[] path)
	{
	    System.out.println ("Solution Exists: Following is one Hamiltonian Cycle \n");
	    for (int i = 0; i < V; i++)
	        System.out.println(path[i]);
	 
	    // Let us print the first vertex again to show the complete cycle
	    System.out.println(path[0]);
	    System.out.println("\n");
	}

}
