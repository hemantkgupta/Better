package dynprog.basic;

import java.util.Arrays;

public class DP01FibonacciNumbers {
	private static final int MAX = 100;
	private static final int NIL = -1;
	private static int[] lookup = new int[MAX];

	public static void main(String[] args) {
		System.out.println("fib_DP_Memoization_TopDown 7 is: " + Arrays.toString(fib_DP_Tabulation_BottemUp(7)));
        initialize();
		System.out.println("fib_DP_Memoization_TopDown 7 is: " + fib_DP_Memoization_TopDown(7));

	}
	public static int[] fib_DP_Tabulation_BottemUp(int n) {
		int[] f = new int[n + 1];
		f[0] = 0;
		f[1] = 1;
		for (int i = 2; i <= n; i++) {

			f[i] = f[i - 1] + f[i - 2];
		}
		return f;
	}

	public static void initialize() {
		for (int i = 0; i < MAX; i++)
			lookup[i] = NIL;
	}

	public static int fib_DP_Memoization_TopDown(int n) {
		if (lookup[n] == NIL) {
			if (n <= 1)
				lookup[n] = n;
			else
				lookup[n] = fib_DP_Memoization_TopDown(n - 1) + fib_DP_Memoization_TopDown(n - 2);
		}
		return lookup[n];
	}

    public static int fibRecur(int n) {
        if (n == 1 || n == 0)
            return n;
        return fibRecur(n - 1) + fibRecur(n - 2);
    }


    public static int fibTwoTemp(int n) {
        int a = 0, b = 1, c, i;
        if (n == 0)
            return a;
        if (n == 1)
            return b;

        for (i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

}
