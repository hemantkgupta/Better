package advanced;

public class FirstSetBit {

    public static void main(String[] args) {
        System.out.println(getFirstSetBitPos(18));
    }

    public static int getFirstSetBitPos(int n) {
        return (int) (Math.log10((double) (n & -n)) / Math.log10(2.0)) + 1;
    }

}
