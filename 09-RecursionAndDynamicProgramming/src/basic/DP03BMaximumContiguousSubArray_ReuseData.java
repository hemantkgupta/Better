package basic;
public class DP03BMaximumContiguousSubArray_ReuseData {

	/**
	 * @param args
     * Re use old sum computed
	 */
	public static void main(String[] args) {
		int[] A = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int vmax = A[0];
		for (int i = 0; i < A.length; i++) {
			int v = 0;
			for (int j = i; j < A.length; j++) {
				v = v + A[j];
				if (v > vmax) {
					vmax = v;
				}
			}
		}
		try {
			Thread.sleep(10000000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(vmax);
	}

}
