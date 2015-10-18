package sort.basic;

/**
 * Created by hemant on 16/10/15.
 */
public class B002PowerOf2Test {

    public static void main(String[] args) {
        System.out.println(powerOftwo(10));
        System.out.println(powerOftwo(16));
    }
    public static boolean powerOftwo(int x) {
        // Power of 2 means only one bit is set
        if ((x & (x - 1)) == 0)
            return true;
        return false;
    }
}
