public class AddOne {

	public static void main(String[] args) {
		System.out.println(addOne(15));
		System.out.println(add1(15));
	}

	public static int addOne(int x) {
		int m = 1;

		/* Flip all the set bits until we find a 0 */
		while ((x & m) > 0) {
			x = x ^ m;
			m <<= 1;
		}

		/* flip the rightmost 0 bit */
		x = x ^ m;
		return x;
	}

	public static int add1(int x) {
		return (-(~x));
	}

}
