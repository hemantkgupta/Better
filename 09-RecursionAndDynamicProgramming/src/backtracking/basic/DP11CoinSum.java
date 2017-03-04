package backtracking.basic;

/**
 * Created by root on 09/12/15.
 */
public class DP11CoinSum {
        public static int[] coins = new int[]{1,2,3};
    public static void main(String[] args) {
        //System.out.println(coinSumRecursive(coins.length, 4));
        System.out.println(count(coins.length, 4));

    }

    public static int coinSum(){
        int[] coins = new int[]{1,3,4};
        int sum = 5;
        int[] D = new int[sum+1];
        D[0] = D[1] = D[2] = 1;
        D[3] = 2;
        for (int i = 4; i <= sum ; i++) {
            D[i] = D[i-1] + D[i-3] + D[i-4];
        }
        return D[sum];
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
}
