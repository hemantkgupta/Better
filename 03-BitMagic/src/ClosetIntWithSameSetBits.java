public class ClosetIntWithSameSetBits {

	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(15));
		System.out.println(Integer.toBinaryString(closest_int_same_bits(15)));
	}

	public static int closest_int_same_bits(int x) {
		for (int i = 0; i < 63; ++i) {
			boolean lsb = ((x >> i) & 1) == 1 ? true : false;
			boolean afterlsb = ((x >> (i + 1)) & 1) == 1 ? true : false;
			if (lsb ^ afterlsb) {
				x ^= (1 << i) | (1 << (i + 1)); // swaps bit-i and bit-(i + 1)
				return x;
			}
		}
		return -1;
	}

}