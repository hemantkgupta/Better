public class RightMostSetBitFindAndTurnOff {

	public static void main(String[] args) {
		System.out.println(getRightMostSetBit(1));
		System.out.println(getRightMostSetBit(2));
		System.out.println(getRightMostSetBit(4));
		System.out.println(getRightMostSetBit(6));
		System.out.println(getRightMostSetBit(8));

		System.out.println(turnOff(6));
	}

	// return position of rightmost set bit (0-32)
	// return 0 for no 0
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

	public static int turnOff(int n) {
		return n & (n - 1);
	}

}
