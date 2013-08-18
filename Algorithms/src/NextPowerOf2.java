public class NextPowerOf2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// System.out.println(nextPowerOf2(17));
		System.out.println(nextPowerOf2ByBit2(17));
	}

	public static int nextPowerOf2(int num) {
		int pos = (int) Math.ceil(Math.log(num) / Math.log(2));
		return (int) Math.pow(2, pos);
	}

	public static int nextPowerOf2ByBit(int n) {
		int count = 0;
		int num = n & (n - 1);
		if (num == 0)
			return n;
		while (n != 0) {
			n >>= 1;
			count += 1;
		}
		return 1 << count;
	}
	
	public static int nextPowerOf2ByBit2(int n) {
		int count = 0;
		int num = n & (n - 1);
		if (num == 0)
			return n;
		int p = 1;
		while (p < n) {
			p <<=1;
		}
		return p;
	}
}
