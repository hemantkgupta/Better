package maxsum.contiguous.subarray;

public class BruteForce {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
				
		int[] A =  { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int vmax = A[0];
		for (int i = 0; i < A.length; i++) {
			for (int j = i; j < A.length; j++) {
				int v = 0;
				for (int k = i; k < j; k++) {
					v = v + A[k];
					if(v > vmax){
						vmax = v;
					}
				}
			}
		}
		System.out.println(vmax);

	}

}
