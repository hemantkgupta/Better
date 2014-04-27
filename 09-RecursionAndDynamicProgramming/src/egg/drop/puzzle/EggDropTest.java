package egg.drop.puzzle;

public class EggDropTest {

	public static void main(String[] args) {
		System.out.println(eggDropRec(2, 4));
		System.out.println(eggDropDP(2, 4));
	}

	/*
	 * Function to get minimum number of trails needed 
	 * in worst case with n eggs and k floors
	 */
	public static int eggDropRec(int n, int k) {
		// No floors OR one floor, one trial needed
		if (k == 1 || k == 0)
			return k;
		// We need k trials for one egg and k floors
		if (n == 1)
			return k;

		int min = Integer.MAX_VALUE, x, res;

		// Consider all droppings from 1st to kth floor and
		// return the minimum of these values plus 1.
		for (x = 1; x <= k; x++) {
			res = Math.max(eggDropRec(n - 1, x - 1), eggDropRec(n, k - x));
			if (res < min)
				min = res;
		}

		return min + 1;
	}

	/*
	 * Function to get minimum number of trails needed
	 * in worst case with n eggs and k floors
	 */
	public static int eggDropDP(int n, int k) {
		/*
		 * eggFloor[i][j] will represent minimum number
		 * of trials needed for i eggs and j floors.
		 */
		int[][] eggFloor = new int[n + 1][k + 1];
		int res;
		int i, j, x;

		// one trial for one floor and0 trials for 0 floors
		for (i = 1; i <= n; i++) {
			eggFloor[i][1] = 1;
			eggFloor[i][0] = 0;
		}

		// We always need j trials for one egg and j floors.
		for (j = 1; j <= k; j++)
			eggFloor[1][j] = j;

		
		for (i = 2; i <= n; i++) {
			for (j = 2; j <= k; j++) {
				eggFloor[i][j] = Integer.MAX_VALUE; 													
				for (x = 1; x <= j; x++) {
					int temp1 = eggFloor[i - 1][x - 1];
					int temp2 = eggFloor[i][j - x];
					res = 1 + Math.max(temp1, temp2);
					if (res < eggFloor[i][j])
						eggFloor[i][j] = res;
				}
			}
		}
		// eggFloor[n][k] holds the result
		return eggFloor[n][k];
	}

	public static void printMatrix(int[][] table) {

		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[0].length; j++) {
				System.out.print(table[i][j] + " ");
			}
			System.out.println();
		}

	}

}
