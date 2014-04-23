package edit.distance;

public class EditDistance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char[] x = "DFGDGBDEGGAB".toCharArray();
		char[] y = "DGGGDGBDEFGAB".toCharArray();
		System.out.println(EditDistanceDP(x,y));
	}
	// Strings of size m and n are passed.
		// Construct the Table for X[0...m, m+1], Y[0...n, n+1]
	
	public static int EditDistanceDP(char[] X, char[] Y)
	{
		int EDIT_COST = 1;
		// Cost of alignment
	    int leftCell, topCell, cornerCell;
	 
	    int m = X.length+1;
	    int n = Y.length+1;
	 
	    // T[m][n]
	    int[][] T = new int [m][n];
	 
	    // Initialize table
	    for(int i = 0; i < m; i++)
	    	T[i][0]=0;
	    for(int j = 0; j < n; j++)
	        T[0][j] =0;
	 
	    
	    // Build the T in top-down fashion
	    for(int i = 1; i < m; i++)
	    {
	        for(int j = 1; j < n; j++)
	        {
	            T[i][j] = Math.min(T[i][j-1]+EDIT_COST,Math.min(T[i-1][j]+EDIT_COST, T[i-1][j-1]+ (X[i-1] != Y[j-1]?1:0) ));
	        }
	    }
	    System.out.println("The final matrix is: ");
	    
	    for (int i = 0; i < Y.length; i++) {
	    	if (i==0){
	    		System.out.print("   ");
	    	}
	    	System.out.print(" "+Y[i]);
		}
	    System.out.println();
	    for (int i = 0; i <= X.length; i++) {
	    	
	    	for (int j = 0; j <= Y.length; j++) {
	    		if (i == 0 && j == 0){
	    			System.out.print("  ");
	    		}
	    		if (i!= 0 && j==0){
	    			System.out.print(X[i-1]+" ");
	    		}
	    		System.out.print(T[i][j]+" ");
			}
	    	System.out.println();
	    }    
	    return T[m-1][n-1];
	}
}
