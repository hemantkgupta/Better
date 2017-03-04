package backtracking.basic;

/**
 * Given a cost matrix cost[][] ,size (m, n.
 * Write a function that returns cost of the minimum cost path to reach (m, n) from (0, 0).
 * Each cell of the matrix represents a cost to traverse through that cell.
 * Total cost of a path to reach (m, n) is sum of all the costs on that path (including both source and destination).
 * You can only traverse down, right and diagonally lower cells from a given cell.
 */

public class DP05MinimumCostPathInMatrix {

	public static void main(String[] args) {
		int[][] cost = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };
		System.out.println(minCost(cost));

	}

	public static int minCost(int[][] cost) {
		int i, j;
		int m = cost.length;
		System.out.println(m);
		int n = cost[0].length;
		System.out.println(n);

		int[][] tc = new int[m][n];

        // First initialise the top-left
		tc[0][0] = cost[0][0];
        // Initialize the columns
		for (i = 1; i < m; i++)
			tc[i][0] = tc[i - 1][0] + cost[i][0];
        // Initialze the rows
		for (j = 1; j < n; j++)
			tc[0][j] = tc[0][j - 1] + cost[0][j];

        //Get min from down, right and and diagonally lower
		for (i = 1; i < m; i++)
			for (j = 1; j < n; j++)
				tc[i][j] = Math.min(tc[i - 1][j - 1],
						Math.min(tc[i - 1][j], tc[i][j - 1]))
						+ cost[i][j];

		return tc[m - 1][n - 1];
	}

}
