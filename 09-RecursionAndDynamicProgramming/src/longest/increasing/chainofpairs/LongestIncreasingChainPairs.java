package longest.increasing.chainofpairs;

public class LongestIncreasingChainPairs {

	public static void main(String[] args) {
		Pair[] arr = { new Pair(5, 24), new Pair(15, 25), new Pair(27, 40),
				new Pair(50, 60) };
		System.out.println(maxChainLength(arr, arr.length));
	}

	// This function assumes that arr is sorted in increasing order
	// according the first (or smaller) values in pairs.
	public static int maxChainLength(Pair[] arr, int n) {
		int i, j, max = 0;
		int[] mcl = new int[n];

		for (i = 0; i < n; i++)
			mcl[i] = 1;

		for (i = 1; i < n; i++)
			for (j = 0; j < i; j++)
				if (arr[i].a > arr[j].b && mcl[i] < mcl[j] + 1)
					mcl[i] = mcl[j] + 1;

		for (i = 0; i < n; i++)
			if (max < mcl[i])
				max = mcl[i];
		return max;
	}

}

class Pair {
	int a;
	int b;

	public Pair(int a, int b) {
		this.a = a;
		this.b = b;
	}
}