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
	
	public static int nextPowerOf2ByBit2(int n) {
		// To check if n is a power of 2
		int num = n & (n - 1);
		if (num == 0)
			return n;
		// iteratively check with a power of 2
		int p = 1;
		while (p < n) {
			p <<=1;
		}
		return p;
	}
}
