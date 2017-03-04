package backtracking.basic;

/**
 * Created by root on 20/12/15.
 */
public class AB12NumberWithOddOccurrences {
    public static void main(String[] args) {
        int[] ar = {2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2};

        System.out.println(getNumberWithOddOccurrences(ar));
    }

    public static int getNumberWithOddOccurrences(int ar[])
    {
        int i;
        int res = 0;
        for (i=0; i < ar.length; i++)
            res = res ^ ar[i];

        return res;
    }
}
