package basic;

/**
 * Created by root on 08/12/15.
 */
public class DP09LongestCommonSubsequence {
    public static void main(String[] args) {
        char[] x = "ABCBDAB".toCharArray();
        char[] y = "BDCABC".toCharArray();
        System.out.println(lcsDP(x,y));
    }

    /* Returns length of LCS for X[0..m-1], Y[0..n-1] */
    public static int lcsRec(char[] X, char[] Y, int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        if (X[m - 1] == Y[n - 1])
            return 1 + lcsRec(X, Y, m - 1, n - 1);
        else
            return Math.max(lcsRec(X, Y, m, n - 1), lcsRec(X, Y, m - 1, n));
    }

    /* Returns length of LCS for X and Y */
    public static int lcsDP(char[] X, char[] Y) {
        int[][] L = new int[X.length+1][Y.length + 1];

        //L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1]
        //Note that the index in L is one more than char array index
        for (int i = 0; i <= X.length; i++) {
            for (int j = 0; j <= Y.length; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X[i - 1] == Y[j - 1])
                    L[i][j] = L[i - 1][j - 1] + 1;
                else
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
            }
        }
        return L[X.length][Y.length];
    }



}
