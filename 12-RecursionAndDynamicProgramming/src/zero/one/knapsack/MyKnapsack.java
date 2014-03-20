package zero.one.knapsack;

import java.util.HashMap;
import java.util.Map;

public class MyKnapsack {
	private static Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int val[] = { 60, 100, 120 };
		int wt[] = { 1, 2, 3 };
		int W = 5;
		map.put(0, 0);
		// System.out.println(knapSackMemoizationWithRepititionDP(wt,val,W));
		System.out.println(knapSackWithRepetitionDP(wt, val, W));
	}

	private static int knapSackWithRepetitionDP(int[] wt, int[] val, int W) {
		int[] K = new int[W + 1];
		K[0] = 0;
		for (int w = 1; w <= W; w++) {
			int temp = 0;
			for (int i = 0; i < val.length; i++) {
				int lastweight = w - wt[i];
				if (lastweight > 0 && K[lastweight] + val[i] > temp)
					temp = K[lastweight] + val[i];
			}
			K[w] = temp;
		}
		return K[W];
	}

	private static int knapSackMemoizationWithRepetitionDP(int[] wt, int[] val,
			int w) {
		if (map.containsKey(w))
			return map.get(w);
		int temp = 0;
		int lastVal = 0;
		for (int i = 0; i < val.length; i++) {
			int lastweight = w - wt[i];
			if (lastweight > 0) {
				lastVal = knapSackMemoizationWithRepetitionDP(wt, val,
						lastweight);
				if (lastVal + val[i] > temp)
					temp = lastVal + val[i];
			}
		}
		map.put(w, temp);
		return map.get(w);
	}

	private static void knapSackWithoutRepetitionDP(int[] wt, int[] val, int W) {
		// create the matrix
		int n = wt.length;
		int[][] K = new int[W + 1][n];

		// Initialize all K[0][j]
		for (int i = 0; i < K[0].length; i++) {
			K[0][i] = 0;
		}
		// Initialize all K[i][0]
		for (int i = 0; i < K.length; i++) {
			K[i][0] = 0;
		}

		for (int j = 1; j <= n; j++) {
			for (int w = 1; w < W; w++) {
				int temp = 0;
				int lastweight = w - wt[j];
				if (lastweight > w) {
					K[w][j] = K[w][j - 1];
				} else {
					for (int i = 0; i < val.length; i++) {
						int lastVal = K[w][lastweight];
						if (lastVal + val[i] > temp)
							temp = lastVal + val[i];
					}
					K[w][j] = temp;
				}
			}

		}

	}
}
