package backtracking.basic;

/**
 * Created by hemant on 16/10/15.
 */
public class B08SwapEvenOddBits {
    public static void main(String[] args) {
        int x = 50;
        System.out.println(Integer.toBinaryString(x));
        ;
        System.out.println(Integer.toBinaryString(swapBits(x)));
    }

    /**
     * To swap even and odd bits first get those bits
     * shift right to even bits and
     * shift left to odd bits and take or
     * @param i
     * @return
     */
    public static  int swapBits(int i)
    {
        // Get all even bits of x, A is 1010
        int even_bits = i & 0xAAAAAAAA;

        // Get all odd bits of x 5 is 0101
        int odd_bits  = i & 0x55555555;

        even_bits >>= 1;  // Right shift even bits
        odd_bits <<= 1;   // Left shift odd bits

        return (even_bits | odd_bits); // Combine even and odd bits
    }

}
