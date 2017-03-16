package basic;

/**
 * Created by root on 08/12/15.
 */
public class DP10BWineSaleMaxProfit {

    public static int counter;
    public static int[][] cache = new int[5][5];

    public static void main(String[] args) {
        int[] wineArray1 = new int[] {1, 4, 2, 3};
        int[] wineArray = new int[] {2, 3, 5, 1, 4};
        for (int i = 0; i < 5 ; i++) {
            for (int j = 0; j < 5 ; j++) {
                cache[i][j] = -1;
            }
        }

        System.out.println(getMaxWineSale2(wineArray, 0, wineArray.length - 1, 1));
        System.out.println(counter);
        //System.out.println(profit(wineArray,1, 0, wineArray.length-1));

    }

    public static int getMaxWineSale(int[] ar, int start, int end, int depth){
        counter++;
        if (start == end){
            return  ar[start]* depth;
        }
        int x = ar[start]*depth+getMaxWineSale(ar, start+1, end, depth+1);
        int y = ar[end]*depth+getMaxWineSale(ar, start, end - 1, depth + 1);
        return Math.max(x,y);
    }

    public static int getMaxWineSale2(int[] ar, int start, int end, int depth){
        counter++;
        if (start == end){
            cache[start][end] = ar[start]* depth;
            return  cache[start][end];
        }
        if (cache[start][end] != -1)
            return cache[start][end];
        int x = ar[start]*depth+getMaxWineSale(ar, start+1, end, depth+1);
        int y = ar[end]*depth+getMaxWineSale(ar, start, end - 1, depth + 1);
        cache[start][end]= Math.max(x,y);
        return cache[start][end];

    }

   // int p[N]; // read-only array of wine prices
    // year represents the current year (starts with 1)
   // [be, en] represents the interval of the unsold wines on the shelf
   public static int profit(int[] p, int year, int be, int en) {
        // there are no more wines on the shelf
        if (be > en)
            return 0;
        // try to sell the leftmost or the rightmost wine, recursively calculate the
        // answer and return the better one
        return Math.max(
                profit(p, year + 1, be + 1, en) + year * p[be],
                profit(p, year + 1, be, en - 1) + year * p[en]);
    }
}
