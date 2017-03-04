package backtracking.basic;

public class DP01FibonacciNumbers {
	private static final int MAX = 100;
	private static final int NIL = -1;
	private static int[] lookup = new int[MAX];

	public static void main(String[] args) {
        initialize();
	}
	public static int[] fibonacciTabulationBottemUp(int n) {
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

	public static int fibonacciMemoizationTopDown(int n) {
		if (lookup[n] == NIL) {
			if (n <= 1)
				lookup[n] = n;
			else
				lookup[n] = fibonacciMemoizationTopDown(n - 1) + fibonacciMemoizationTopDown(n - 2);
		}
		return lookup[n];
	}

    public static int fibonacciRecursive(int n) {
        if (n == 1 || n == 0)
            return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }



}
