public class SearchSortedMatrix {

	public static void main(String[] args) {
		int[][] mat = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 },
				{ 27, 29, 37, 48 }, { 32, 33, 39, 50 } };
		System.out.println(search(mat, 4, 29));

	}

	/*
	 * Searches the element x in mat[][]
	 */
	public static int search(int[][] mat, int n, int x) {
		int i = 0, j = n - 1; // set indexes for top right element
		while (i < n && j >= 0) {
			if (mat[i][j] == x) {
				System.out.printf("\n Found at %d, %d", i, j);
				return 1;
			}
			if (mat[i][j] > x)
				j--;
			else
				// if mat[i][j] < x
				i++;
		}
		System.out.printf("\n Element not found");
		return 0; // if ( i==n || j== -1 )
	}

}
