package adv;

public class BT07Sudoku {
	private static final int UNASSIGNED = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 0 means unassigned cells
	    int[][] grid = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
	                      {5, 2, 0, 0, 0, 0, 0, 0, 0},
	                      {0, 8, 7, 0, 0, 0, 0, 3, 1},
	                      {0, 0, 3, 0, 1, 0, 0, 8, 0},
	                      {9, 0, 0, 8, 6, 3, 0, 0, 5},
	                      {0, 5, 0, 0, 9, 0, 6, 0, 0},
	                      {1, 3, 0, 0, 0, 0, 2, 5, 0},
	                      {0, 0, 0, 0, 0, 0, 0, 7, 4},
	                      {0, 0, 5, 2, 0, 6, 3, 0, 0}};
	    if (solveSudoku(grid) == true)
	          printGrid(grid);
	    else
	         System.out.println("No solution exists");
	 
	}
	
	/* Takes a partially filled-in grid and attempts to assign values to
	  all unassigned locations in such a way to meet the requirements
	  for adv.BT07Sudoku solution (non-duplication across rows, columns, and boxes) */
	public static boolean solveSudoku(int[][] grid)
	{
	 
	    // If there is no unassigned location, we are done
	    int[] locRowCol = findUnassignedLocation(grid);
	    if (locRowCol[0]==-1 && locRowCol[1]==-1)
	       return true; // success!
	    int row = locRowCol[0];
	    int col = locRowCol[1];
	    
	    // consider digits 1 to 9
	    for (int num = 1; num <= 9; num++)
	    {
	        // if looks promising
	        if (isSafe(grid, row, col, num))
	        {
	            // make tentative assignment
	            grid[row][col] = num;
	 
	            // return, if success, yay!
	            if (solveSudoku(grid))
	                return true;
	 
	            // failure, unmake & try again
	            grid[row][col] = UNASSIGNED;
	        }
	    }
	    return false; // this triggers backtracking
	}
	
	public static int[] findUnassignedLocation(int[][] grid)
	{
	    int[] locRowCol = new int[]{-1,-1};
		for (int row = 0; row < 9; row++)
	        for (int col = 0; col < 9; col++)
	            if (grid[row][col] == UNASSIGNED){
	            	locRowCol[0] = row;
					locRowCol[1] = col;
					return locRowCol;
	            }
	    return locRowCol;
	}
	
	/* Returns a boolean which indicates whether any assigned entry
	   in the specified column matches the given number. */
	public static boolean UsedInCol(int[][] grid, int col, int num)
	{
	    for (int row = 0; row < 9; row++)
	        if (grid[row][col] == num)
	            return true;
	    return false;
	}
	 
	/* Returns a boolean which indicates whether any assigned entry
	   within the specified 3x3 box matches the given number. */
	public static boolean UsedInBox(int[][] grid, int boxStartRow, int boxStartCol, int num)
	{
	    for (int row = 0; row < 3; row++)
	        for (int col = 0; col < 3; col++)
	            if ( grid[row+boxStartRow][col+boxStartCol] == num)
	                return true;
	    return false;
	}
	 
	/* Returns a boolean which indicates whether it will be legal to assign
	   num to the given row,col location. */
	public static boolean isSafe(int[][] grid, int row, int col, int num)
	{
	    /* Check if 'num' is not already placed in current row,
	       current column and current 3x3 box */
	    return !UsedInRow(grid, row, num) &&
	           !UsedInCol(grid, col, num) &&
	           !UsedInBox(grid, row - row%3 , col - col%3, num);
	}
	
	/* Returns a boolean which indicates whether any assigned entry
	   in the specified row matches the given number. */
	public static boolean UsedInRow(int[][] grid, int row, int num)
	{
	    for (int col = 0; col < 9; col++)
	        if (grid[row][col] == num)
	            return true;
	    return false;
	}
	
	/* A utility function to print grid  */
	public static void printGrid(int[][] grid)
	{
	    for (int row = 0; row < 9; row++)
	    {
	       for (int col = 0; col < 9; col++)
	             System.out.print(grid[row][col]+" ");
	       System.out.println();
	    }
	}
	 
	

}
