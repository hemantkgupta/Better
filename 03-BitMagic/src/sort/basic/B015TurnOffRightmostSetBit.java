package sort.basic;

/**
 * Created by hemant on 16/10/15.
 */
public class B015TurnOffRightmostSetBit {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(66));
        System.out.println(Integer.toBinaryString(turnOff(66)));
    }

    public static int turnOff(int n) {
        return n & (n - 1);
    }

}
