public class ParityCount {

	public static void main(String[] args) {
		System.out.println(parityCount(15));
	}

	public static int parityCount(int x) {
		int result = 0;
		while (x > 0) {
			x = x & (x - 1);
			result++;
		}
		return result;
	}

}
