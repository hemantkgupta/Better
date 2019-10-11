package basic;

public class BITB06ParityCount {

	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(50));
		System.out.println(parityCount(50));
		System.out.println(parityCount2(50));
	}

    /**
     * Count how many bits are set
     * @param x input integer
     * @return the number of ser bits (parity)
     */
	public static int parityCount(int x) {
		int result = 0;
		while (x > 0) {
			if ( (x & 1) == 1){
				result++;
			}
			x = x >> 1;
		}

		return result;
	}

	/**
	 * @param x input integer
     * @return the number of ser bits (parity)
    */
	public static int parityCount2(int x) {
		int result = 0;
		while (x > 0) {
			x = x & (x - 1);
			result++;
		}
		return result;
	}


}
