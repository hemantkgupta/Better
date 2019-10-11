package basic;

public class BITB07ClosetIntWithSameSetBits {

	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(15));
		System.out.println(Integer.toBinaryString(getNextIntegerWithSameSetBits(15)));
	}

    /**
     * Test for least significant bit and the bit after that
     * when moving towards most significant bit,
     * if bits are opposite swap them and return the result.
     * @param x
     * @return
     */
	public static int getNextIntegerWithSameSetBits(int x) {
		for (int i = 0; i < 32; ++i) {

            //check if lsb and next bit are set
			boolean lsb = ((x >> i) & 1) == 1 ? true : false;
			boolean nextToLsb = ((x >> (i + 1)) & 1) == 1 ? true : false;
			// if only one of them is set
			if (lsb ^ nextToLsb) {
				// swaps bit i and bit (i + 1)
                // by taking or
				x ^= (1 << i) | (1 << (i + 1));
				return x;
			}
		}
		return -1;
	}

}
