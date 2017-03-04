package advanced;

/**
 * Created by hemant on 16/10/15.
 */
public class B018SwapBits {
    public static void main(String[] args) {
        int x = 75;
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(swap_bits(x, 4, 0)));

    }

    // The given number is x and bits positon to swap
    // are i and j
    public static int swap_bits(int x, int i, int j) {
        // First check if the bits are same or not
        if (((x >> i) & 1) != ((x >> j) & 1)) {
            x ^= (1 << i) | (1 << j);
        }
        return x;
    }


}
