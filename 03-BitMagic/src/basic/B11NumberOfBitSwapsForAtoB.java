package basic;

public class B11NumberOfBitSwapsForAtoB {

	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(55));
		System.out.println(Integer.toBinaryString(45));
		System.out.println(bitSwapRequired(55, 45));
	}

	/**
	 * Take the xor of two integers and then count the
	 * number of set bits in result
	 * @param a
	 * @param b
	 * @return
	 */
	public static int bitSwapRequired(int a, int b) {
		int count = 0;
		for (int c = a ^ b; c != 0; c = c & (c - 1)) {
			count++;
		}
		return count;
	}

}
