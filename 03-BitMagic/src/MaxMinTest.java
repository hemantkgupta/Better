public class MaxMinTest {

	public static void main(String[] args) {
		System.out.println(min(56, 23));
		System.out.println(max(56, 23));
	}

	public static int min(int x, int y) {
		return y + ((x - y) & ((x - y) >> 31));
	}

	public static int max(int x, int y) {
		return x - ((x - y) & ((x - y) >> 31));
	}

}
