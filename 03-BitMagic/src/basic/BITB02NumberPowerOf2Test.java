package backtracking.basic;

/**
 * Created by hemant on 16/10/15.
 */
public class BITB02NumberPowerOf2Test {

    public static void main(String[] args) {
        System.out.println(isNumberPowerOfTwo(10));
        System.out.println(isNumberPowerOfTwo(16));
    }

    /**
     * Power of 2 number has only one bit set
     * @param x
     * @return
     */
    public static boolean isNumberPowerOfTwo(int x) {

        int mask = (x - 1);
        if ((x & mask ) == 0)
            return true;
        return false;
    }
}
