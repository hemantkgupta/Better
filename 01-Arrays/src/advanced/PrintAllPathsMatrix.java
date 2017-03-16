package advanced;

/**
 * The problem is to print all the possible paths from top left to bottom right of a mXn matrix with the constraints
 * that from each cell you can either move only to right or down.
 */
public class PrintAllPathsMatrix {

	public static void main(String[] args) {
		int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 } };
		printAllPaths(mat, 2, 3);
	}

	// The main function that prints all paths from top left to bottom right
	// in a matrix 'mat' of size mXn
	public static void printAllPaths(int[][] mat, int m, int n) {
		int[] path = new int[m + n];
		printAllPathsUtil(mat, 0, 0, m, n, path, 0);
	}

	/*
	 * mat: mXn matrix i, j: Current position of the robot 
	 * pi: Next index to be filed in path array
	 * path[0..pi-1]: The path traversed by robot till now
	 * (Array to hold the path need at least m+n space)
	 */
	public static void printAllPathsUtil(int[][] mat, int i, int j, int m,
			int n, int[] path, int pi) {
		// Reached the bottom of the matrix so we are left with
		// only option to move right
		if (i == m - 1) {
			for (int k = j; k < n; k++)
				path[pi + k - j] = mat[i][k];

			for (int l = 0; l < pi + n - j; l++)
				System.out.print(path[l] + " ");

			System.out.println();
			return;
		}

		// Reached the right corner of the matrix we are left with
		// only the downward movement.
		if (j == n - 1) {
			for (int k = i; k < m; k++)
				path[pi + k - i] = mat[k][j];

			for (int l = 0; l < pi + m - i; l++)
				System.out.print(path[l] + " ");

			System.out.println();
			return;
		}

		// Add the current cell to the path being generated
		path[pi] = mat[i][j];

		// Print all the paths that are possible after moving down
		printAllPathsUtil(mat, i + 1, j, m, n, path, pi + 1);

		// Print all the paths that are possible after moving right
		printAllPathsUtil(mat, i, j + 1, m, n, path, pi + 1);

		// Print all the paths that are possible after moving diagonal
		// printAllPathsUtil(mat, i+1, j+1, m, n, path, pi + 1);
	}

}
