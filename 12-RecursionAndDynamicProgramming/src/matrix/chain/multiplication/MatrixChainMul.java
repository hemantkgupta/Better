package matrix.chain.multiplication;

public class MatrixChainMul {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = {10, 100, 5, 50};
		System.out.println(MatrixChainOrderDP(arr,3));
	}
	/**
	 * // Matrix Ai has dimension p[i-1] x p[i] for i = 1..n
	 *
	 */
	public static int MatrixChainOrderRec(int p[], int i, int j)
	{
	    if(i == j)
	        return 0;
	    int k;
	    int min = Integer.MAX_VALUE;
	    int count;
	 
	    // place parenthesis at different places between first and last matrix,
	    // recursively calculate count of multiplcations for each parenthesis 
	    // placement and return the minimum count
	    for (k = i; k < j; k++)
	    {
	        count = MatrixChainOrderRec(p, i, k) +
	                MatrixChainOrderRec(p, k+1, j) +
	                p[i-1]*p[k]*p[j];
	 
	        if (count < min)
	            min = count;
	    }
	 
	    // Return minimum count
	    return min;
	}
	
	// Matrix Ai has dimension p[i-1] x p[i] for i = 1..n
	public static int MatrixChainOrderDP(int p[], int n)
	{
	 
	    /* For simplicity of the program, one extra row and one extra column are
	       allocated in m[][].  0th row and 0th column of m[][] are not used */
	    int[][] m= new int[n+1][n+1];
	 
	    int i, j, k, l, q;
	 
	    /* m[i,j] = Minimum number of scalar multiplications needed to compute
	       the matrix A[i]A[i+1]...A[j] = A[i..j] where dimention of A[i] is
	       p[i-1] x p[i] */
	 
	    // cost is zero when multiplying one matrix.
	    for (i = 1; i <= n; i++)
	        m[i][i] = 0;
	 
	    // L is chain length.  
	    for (l=2; l<= n; l++)   
	    {
	        for (i=1; i<= n-l+1; i++)
	        {
	            j = i+l-1;
	            m[i][j] = Integer.MAX_VALUE;
	            for (k=i; k <j; k++)
	            {
	                // q = cost/scalar multiplications
	                q = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
	                if (q < m[i][j])
	                    m[i][j] = q;
	            }
	        }
	    }
	 
	    return m[1][n];
	}

}
