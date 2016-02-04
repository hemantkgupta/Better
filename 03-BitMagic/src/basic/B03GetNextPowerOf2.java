package basic;

public class B03GetNextPowerOf2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getNextPowerOf2Integer(17));
	}

	public static int getNextPowerOf2Integer(int n) {
		//Check if n is a power of 2
		int num = n & (n - 1);
		if (num == 0)
			return n;

		//Iteratively check with a power of 2
		int p = 1;
		while (p < n) {
			p <<=1;
		}
		return p;
	}
}
