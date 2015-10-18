package sort.basic;

public class B016AddOneWithoutAO {

	public static void main(String[] args) {
		System.out.println(addOne(-1));
		System.out.println(add1(0));
	}

	public static int addOne(int x) {
		int m = 1;

		/* Start from right andfFlip all the set bits until we find a 0 */
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
