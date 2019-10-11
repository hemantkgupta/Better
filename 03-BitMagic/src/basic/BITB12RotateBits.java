package basic;

public class BITB12RotateBits {

	public static void main(String[] args) {
		System.out.println(leftRotate(8, 2));
		System.out.println(rightRotate(32, 2));

	}

	public static int leftRotate(int n, int d) {

		return (n << d) | (n >> (32 - d));
	}

	public static int rightRotate(int n, int d) {

		return (n >> d) | (n << (32 - d));
	}

}
