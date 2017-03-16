package basic;

/**
 * Created by root on 10/12/15.
 */
public class DP15MinimumCostMatrixPath {
    public static int[][] input;
    public static void main(String[] args) {
        input = new int[][] { {1,2,3},
                          {4,8,2},
                          {1,5,3}
                        };
        //System.out.println(getMinimumCostRecursive(2, 2));
        System.out.println(getMinimumCostRecursive(2, 2));

    }

    public static int getMinimumCostRecursive(int m, int n){
        if(n < 0 || m < 0){
            return Integer.MAX_VALUE;
        }else if (m == 0 && n ==0) {
            return input[m][n];
        }else
            return input[m][n] + min (getMinimumCostRecursive(m - 1, n - 1),
                                      getMinimumCostRecursive(m - 1, n),
                                      getMinimumCostRecursive(m, n - 1));
    }

    public static int min(int x, int y, int z){
        return Math.min(x, Math.min(y,z));
    }

    public static int getMinimumCostDynamic(int[][] input) {
        int m = input.length;
        int n = input[0].length;
        int [][] output = new int[m][n];

        // initialize corner
        output[0][0] = input[0][0];

        // for first row
        for (int i = 1; i < n; i++) {
            output[0][i] = input[0][i];
        }

        // for first column
        for (int i = 1; i < m; i++) {
            output[i][0] = input[i][0];
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                output[i][j] = min(output[i - 1][j - 1], output[i - 1][j], output[i][j-1]);
            }
        }

        return output[m - 1][n - 1];

    }
}
