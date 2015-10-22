import java.util.Arrays;

/**
 * Created by hemant on 21/10/15.
 */
public class DPTest {

    static  int[] jumps = new int[11];

    public static void main(String[] args) {
        //int[] ar = {3,4,6,5,6,2,3,4,5,7};
        int ar[] = { 1, 3, 6, 3, 2, 3, 6, 8, 9, 5 };
        jumps[0] = 0;
        for (int i = 1; i < jumps.length ; i++) {
         jumps[i]= Integer.MAX_VALUE;
        }
        getMinimumJumps(ar, 0, ar.length-1);
    }


    public static void getMinimumJumps(int[] ar, int start, int end){

        for (int i = 0; i < ar.length ; i++) {
            for (int j = i+1; j < i + ar[i] + 1  && j < jumps.length ; j++) {
                if( jumps[j] > jumps[i] +1 ) {
                    jumps[j] = jumps[i] + 1;
                }
            }

        }

        System.out.println(Arrays.toString(jumps));
    }
}
