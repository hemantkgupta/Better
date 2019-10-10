package basic;

public class B13GetAbsWithoutBranching {

	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(-7));
		System.out.println(Integer.toBinaryString(7));
		System.out.println(getAbs(-7));

	}

	/**
	 * For positive numbers take mask as 0 (all 0 in binary )
	 * For negative numbers take mask as -1 (all 1 in binary)
	 * -x -1 = ~x
	 * @param n
	 * @return
	 */
	public static int getAbs(int n) {
		int mask = n >> 31;
		// For negative (~(n + mask)) is good;
		return ((n + mask) ^ mask);
	}
}
