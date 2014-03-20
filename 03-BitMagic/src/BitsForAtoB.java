public class BitsForAtoB {

	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(55));
		System.out.println(Integer.toBinaryString(45));
		System.out.println(bitSwapRequired(55, 45));
	}

	public static int bitSwapRequired(int a, int b) {
		int count = 0;
		for (int c = a ^ b; c != 0; c = c & (c - 1)) {
			count++;
		}
		return count;
	}

}
