public class MultiplyBy3Andhalf {

	public static void main(String[] args) {
		System.out.println(multiplyWith3Point5(6));
	}

	public static int multiplyWith3Point5(int x) {
		return (x << 1) + x + (x >> 1);
	}

}
