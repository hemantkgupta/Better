package max.apple.matrix;

public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] app = { {1, 2, 3, 4},
						{5, 6, 7, 8},
						{9, 1, 2, 3}
					  };
		int[][] total = { {0, 0, 0, 0, 0},
				          {0, 0, 0, 0, 0},
				          {0, 0, 0, 0, 0},
				          {0, 0, 0, 0, 0},
			  };
		maxApples(app, total);
		for (int i = 0; i < total.length; i++) {
			for(int j = 0; j< total[0].length;j++){
				System.out.print(total[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	public static void maxApples(int[][] app, int[][] total){
		int row = 3;
		int col = 4;
		for(int i=0;i<row;i++)
			for(int j=0;j< col;j++){
					total[i+1][j+1] = app[i][j]+ Math.max(total[i+1][j], total[i][j+1]);
				}
	}
	
	/*For i = 0 to N - 1
			   For j = 0 to M - 1
			   S[i][j] = A[i][j] +
			      max(S[i][j-1], if j>0 ; S[i-1][j], if i>0 ; 0)

			Output S[n-1][m-1]*/

}
	
	
