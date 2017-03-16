package basic;

/**
 * Created by root on 08/12/15.
 */
public class DP10AWineSaleMaxProfit {

    public static int counter;
    public static int[][] cache ;
    public static  int[] ar;
    public static  int n;
    public static void main(String[] args) {
        //ar = new int[] {2, 3, 5, 1, 4};
        ar = new int[] {1, 4, 2, 3};
        n = ar.length;
        cache = new int[n][n];
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                cache[i][j] = -1;
            }
        }

        //System.out.println(getMaxWineSale(0, ar.length - 1));
        System.out.println(getMaxWineSale2(0, ar.length - 1));
        System.out.println(counter);
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                System.out.print(" " + cache[i][j]);
            }
            System.out.println();

        }

    }

    public static int getMaxWineSale(int start, int end){
        counter++;
        int year = n - (end-start+1)+1;
        if (start == end){
            return  ar[start]* year;
        }
        int x = ar[start]*year+getMaxWineSale(start+1, end);
        int y = ar[end]*year+getMaxWineSale(start, end - 1);
        return Math.max(x,y);
    }

    public static int getMaxWineSale2(int start, int end){
        counter++;

        int year = n - (end-start+1)+1;

        if (start == end)
            return cache[start][end] = ar[start]* year;

        if (cache[start][end] != -1)
            return cache[start][end];

        int x = ar[start] * year + getMaxWineSale2(start+1, end);
        int y = ar[end] * year + getMaxWineSale2(start, end - 1);

        return cache[start][end]= Math.max(x,y);

    }

}
