public class CommonPrimeDivisors {

	public static void main(String[] args) {
		int[] A = new int[3];
		int[] B = new int[3];
		A[0] = 15;
		B[0] = 75;
		A[1] = 10;
		B[1] = 30;
		A[2] = 3;
		B[2] = 5;
		System.out.println(solution(A, B));
	}

	public static int solution(int[] A, int[] B) {
		int result = 0;
		for (int i = 0; i < B.length; i++) {
			if (hasPrimeDivisors(A[i], B[i]))
				result++;

		}
		return result;
	}

	public static boolean hasPrimeDivisors(int a, int b) {

		int gcdValue = gcd(a, b);
		if (gcdValue == 1)
			return false;

		while (a != 1) {
			int aGcd = gcd(a, gcdValue);
			if (aGcd == 1)
				break;
			a /= aGcd;
		}
		if (a != 1)
			return false;
		while (b != 1) {
			int bGcd = gcd(b, gcdValue);
			if (bGcd == 1)
				break;
			b /= bGcd;
		}
		return b==1;
	}

	public static int gcd(int a, int b) {
		if (a < b) {
			return gcd(b, a);
		}
		if (a % b == 0)
			return b;
		return gcd(b, a % b);
	}

}