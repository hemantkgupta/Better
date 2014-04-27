package matrix.path.count;

public class AllPathsCount {

	public static void main(String[] args) {
		System.out.println(numberOfPathsRecr(3, 3));
		System.out.println(numberOfPaths(3, 3));
	}

	// Possible paths from (m,n) to (1,1)
	public static int numberOfPathsRecr(int m, int n) {
		if (m == 1 || n == 1)
			return 1;

		// Add last line for If diagonal movements
		return numberOfPathsRecr(m - 1, n) + numberOfPathsRecr(m, n - 1);
		// + numberOfPaths(m-1,n-1);
	}

	// Possible paths from (m,n) to (1,1)
	public static int numberOfPaths(int m, int n) {
		int[][] count = new int[m][n];

		for (int i = 0; i < m; i++)
			count[i][0] = 1;

		for (int j = 0; j < n; j++)
			count[0][j] = 1;

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++)

				// Add last line for If diagonal movements
				count[i][j] = count[i - 1][j] + count[i][j - 1];
			// + count[i-1][j-1];

		}
		return count[m - 1][n - 1];
	}

}
