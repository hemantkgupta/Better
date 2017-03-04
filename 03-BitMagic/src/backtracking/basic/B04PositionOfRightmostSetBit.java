package backtracking.basic;

public class B04PositionOfRightmostSetBit {

	public static void main(String[] args) {
		System.out.println(getRightMostSetBit(1));
		System.out.println(getRightMostSetBit(2));
		System.out.println(getRightMostSetBit(4));
		System.out.println(getRightMostSetBit(6));
		System.out.println(getRightMostSetBit(8));

	}

	/**
	 * @param n
	 * @return the postion of RMS bit 0-31
	 */
	public static int getRightMostSetBit(int n) {
		if (n == 0)
			return 0;
		int position = 1;
		for (int i = 0; i < 32; i++) {
			if ((n & 1) == 1) {
				break;
			} else {
				n = n >> 1;
			}
			position++;
		}
		return position;
	}

}
