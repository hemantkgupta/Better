package basic;

/**
 * Created by root on 09/12/15.
 */
public class DP12MinInsertForPalindrome {
    public static void main(String[] args) {
        System.out.println(makePalindrome("sdrs".toCharArray()));
    }

    public static int makePalindrome(char[] input){
        int n = input.length;
        int[][] D = new int [n][n];
        for(int t = 1; t <= n; t++)
            for (int i = 0, j = t; j < n ; i++, j++) {
                    D[i][i] = 0;
            }
        return 0;
    }
}
