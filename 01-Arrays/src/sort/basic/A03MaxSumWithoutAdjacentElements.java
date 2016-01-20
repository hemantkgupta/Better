package sort.basic;

/**
 * Created by hemant on 17/10/15.
 */
public class A03MaxSumWithoutAdjacentElements {

    public static void main(String[] args) {

        // 5+40+35
        int[] arr = {5,  5, 10, 40, 50, 35};
        System.out.println(FindMaxSum(arr));

    }

    /**
     * This method returns maximum sum of non-adjacent elements
     * @param arr
     * @return
     */
    public static int FindMaxSum(int arr[]){
        int incl = arr[0];
        int excl = 0;
        int excl_new;
        int i;

        for (i = 1; i < arr.length; i++){

            excl_new = (incl > excl)? incl: excl;

            incl = excl + arr[i];
            excl = excl_new;
        }
        return ((incl > excl)? incl : excl);
    }

}
