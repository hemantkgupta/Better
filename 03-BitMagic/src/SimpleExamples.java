public class SimpleExamples {

	public static void main(String[] args) {
		//System.out.println(powerOftwo(17));
		//System.out.println(powerOftwo(128));
		System.out.println(oppositeSigns(2,-3));
	}

	public static boolean powerOftwo(int x) {
		// Power of 2 means only one bit is set
		if ((x & (x - 1)) == 0)
			return true;
		return false;
	}

	/* swap i and j th bit of 32 bit integer.*/
	public static int swap_bits(int x, int i, int j) {
		// First check if the bits are same or not
		if (((x >> i) & 1) != ((x >> j) & 1)) {
			x ^= (1 << i) | (1 << j);
		}
		return x;
	}

	public static int modulusDivisionByPowerOfTwo(int n, int d) {

		return n & (d - 1);
	}
	
	public static boolean oppositeSigns(int x, int y)
	{
	    return ((x ^ y) < 0);
	}

}
