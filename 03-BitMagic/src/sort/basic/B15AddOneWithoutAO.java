package sort.basic;

public class B15AddOneWithoutAO {

	public static void main(String[] args) {

		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));


		System.out.println(Integer.toBinaryString(- 5));
		System.out.println(Integer.toBinaryString( (~ 5)+1 ));

		System.out.println(addOne(-1));
		System.out.println(add1(-1));
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

	/**
	 *
	 * @param x, - x  =  ~ x + 1
	 * @return
	 */
	public static int add1(int x) {
		return (-(~x));
	}

}
