package sort.advanced;

/**
 * Created by hemant on 14/10/15.
 */
public class A003Missing1ToN {
    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,5};
        System.out.println(getMissingNo(input,4));
    }

    public static int getMissingNo(int a[], int n){
        int i;
        int x1 = a[0];
        int x2 = 1;

        for (i = 1; i< n; i++)
            x1 = x1^a[i];

        for ( i = 2; i <= n+1; i++)
            x2 = x2^i;

        return (x1^x2);
    }
}
