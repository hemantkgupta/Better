package minimum.cost.path;

public class MinimumCostPath {

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

		tc[0][0] = cost[0][0];
		for (i = 1; i < m; i++)
			tc[i][0] = tc[i - 1][0] + cost[i][0];
		for (j = 1; j < n; j++)
			tc[0][j] = tc[0][j - 1] + cost[0][j];

		for (i = 1; i < m; i++)
			for (j = 1; j < n; j++)
				tc[i][j] = Math.min(tc[i - 1][j - 1],
						Math.min(tc[i - 1][j], tc[i][j - 1]))
						+ cost[i][j];

		return tc[m - 1][n - 1];
	}

}
