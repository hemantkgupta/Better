package basic;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by root on 09/12/15.
 */
public class DP11CoinSum {
    public static int[] coins = new int[]{1,2,3};

    public static int[] D;
    public static void main(String[] args) {
        //System.out.println(coinSumRecursive(coins.length, 3));
        //System.out.println("old way " +count(coins.length, 4));
        System.out.println("old way " +bigCount(coins.length, 4));

    }
    
    /**
     * Calculates the no of ways to get sum using coins[0...m-1]
     * @param m
     * @param sum
     * @return
     */
    public static int coinSumRecursive(int m, int sum){

        if (sum == 0)
            return 1;

        if (sum < 0)
            return 0;

        if (m <= 0 && sum >= 1)
            return 0;

        return coinSumRecursive(m-1, sum)
                + coinSumRecursive(m, sum-coins[m-1]);

    }

    /**
     * Calculates the no of ways to get sum using coins[0...m-1]
     * 250 24
     * 41 34 46 9 37 32 42 21 7 13 1 24 3 43 2 23 8 45 19 30 29 18 35 11
     * 15685693751
     * @param m
     * @param sum
     * @return
     */
    public static int count( int m, int sum )
    {
        int i, j, x, y;

        // We need sum+1 rows as the base case has sum = 0
        int [][]table = new int[sum+1][m];

        // Fill the entries for case sum = 0
        for (i=0; i<m; i++)
            table[0][i] = 1;

        // Fill rest of the table entries in bottom up manner
        for (i = 1; i < sum+1; i++)
        {
            for (j = 0; j < m; j++)
            {
                // Count of solutions including the coin at j
                // First check the sum is greater than 0
                x = (i-coins[j] >= 0)? table[i - coins[j]][j]: 0;

                // Count of solutions excluding the coin at j
                // First coin cannot be excluded
                y = (j >= 1)? table[i][j-1]: 0;

                // total count
                table[i][j] = x + y;
            }
        }
        return table[sum][m-1];
    }

    /**
     * Calculates the no of ways to get sum using coins[0...m-1]
     * 250 24
     * 41 34 46 9 37 32 42 21 7 13 1 24 3 43 2 23 8 45 19 30 29 18 35 11
     * 15685693751
     * @param m
     * @param sum
     * @return
     */
    public static BigInteger bigCount( int m, int sum )
    {
        int i, j;
        BigInteger x, y;

        // We need sum+1 rows as the base case has sum = 0
        BigInteger[][]table = new BigInteger[sum+1][m];

        // Fill the entries for case (row sum = 0)
        for (i=0; i<m; i++)
            table[0][i] = new BigInteger("1");

        // Fill rest of the table entries in bottom up manner

        for (i = 1; i < sum+1; i++) // Do for  all sum values
        {
            for (j = 0; j < m; j++) // Do for all coin value
            {
                // Count of solutions including the coin at j
                if (i-coins[j] >= 0){
                    x = table[i - coins[j]][j];
                } else {
                    x = new BigInteger("0");
                }
                // Count of solutions excluding the coin at j
                // Important: First coin cannot be excluded
                if ( j >=1){
                    y = table[i][j-1];
                } else {
                    y = new BigInteger("0");
                }
                // total count
                table[i][j] = x.add(y);
            }
        }
        return table[sum][m-1];
    }

}
