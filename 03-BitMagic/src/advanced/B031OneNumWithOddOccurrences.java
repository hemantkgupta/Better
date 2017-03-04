package advanced;

/**
 * Created by hemant on 16/10/15.
 */
public class B031OneNumWithOddOccurrences {

    public static void main(String[] args) {

        int[] inputArray = new int[]{3,4,3,5,3,4,3,5,6,3,6};
        System.out.println(getOddOccurrence(inputArray));
    }

    public static int getOddOccurrence(int ar[]){
        int i;
        int res = 0;
        for (i=0; i < ar.length; i++)
            res = res ^ ar[i];
        return res;
    }

}
