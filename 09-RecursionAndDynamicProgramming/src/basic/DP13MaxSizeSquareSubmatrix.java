package basic;

/**
 * Created by root on 09/12/15.
 */
public class DP13MaxSizeSquareSubmatrix {

    public static void main(String[] args) {
        int[][] M = { { 0, 1, 1, 0, 1 }, { 1, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 },
                { 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0 } };
        System.out.println(getMaxSizeSquareSubMatrix(M));

    }

    /**
     * Construct a matrix in which an entry at [i][j] position
     * represents size of square sub matrix with all 1s and this
     * positon as the rightmost and bottommost
     * @param M
     * @return
     */

    public static int getMaxSizeSquareSubMatrix(int[][] M){


        int i, j;
        int R = M.length;
        int C = M[0].length;
        int[][] S = new int[R][C];

        for (i = 0; i < R; i++)
            S[i][0] = M[i][0];
        for (j = 0; j < C; j++)
            S[0][j] = M[0][j];

        for (i = 1; i < R; i++) {
            for (j = 1; j < C; j++) {
                if (M[i][j] == 1)
                    S[i][j] = Math.min(S[i][j - 1],
                            Math.min(S[i - 1][j], S[i - 1][j - 1])) + 1;
                else
                    S[i][j] = 0;
            }
        }

        //Find the maximum entry and its indexes
        int maxs, maxi, maxj;
        maxs = S[0][0];
        maxi = 0;
        maxj = 0;
        for (i = 0; i < R; i++) {
            for (j = 0; j < C; j++) {
                if (maxs < S[i][j]) {
                    maxs = S[i][j];
                    maxi = i;
                    maxj = j;
                }
            }
        }

        System.out.println("\n Maximum size sub-matrix is: \n");
        for (i = maxi; i > maxi - maxs; i--) {
            for (j = maxj; j > maxj - maxs; j--) {
                System.out.print(M[i][j] + " ");
            }
            System.out.println();
        }

        return maxs;
    }
}
