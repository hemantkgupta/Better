package basic;

/**
 * Created by root on 01/12/15.
 */
public class M01PowIterative {
    public static void main(String[] args) {
        System.out.println("The pow result is "+ power(2,9));
    }

    /**
     * The power n can be written as 1+2+4+8..
     * It can be calculated from binary representation of n
     * @param a
     * @param n
     * @return
     */
    public static int power(int a, int n) {
        int result = 1;
        while(n>0) {
            if(n%2==1)
                result = result * a;
            a = a * a;
            n = n>>1;
        }
        return result;
    }
}
