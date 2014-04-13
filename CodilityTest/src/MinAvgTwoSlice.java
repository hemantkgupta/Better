import java.util.Arrays;

public class MinAvgTwoSlice {

	public static void main(String[] args) {
		System.out.println(test());
	}

	public static int test() {
	//	int[] ar = { 4, 2, 2, 5,  1,  5,  8    };
	 //	int[] pr = { 0, 4, 6, 8, 13, 14, 19, 27};
	//	int[] ar = { 4, 2, 2, 5,  1,  1,  8    };
	  //int[] pr = { 0, 4, 6, 8, 13, 14, 15, 23}
		int[] A = { -10,000, 10,000, 2, 4};
		int len = A.length;
		if (len == 2){
			return (A[0]+A[1])/2;
		}
		int[] prefixSum = prefixSum(A);
		System.out.println(Arrays.toString(prefixSum));
		double minAvg = Double.MAX_VALUE;
		int start = 0;
		
		for (int i = 2; i <= len; i++) {
			System.out.println("For outer loop i: "+ i);
			for (int j = 0; j <= i-2; j++){
				System.out.println("For inner loop j: "+ j);
				double currentSum = (float)(prefixSum[i]- prefixSum[j]);
				System.out.println("currentSum: "+ currentSum);
				double currAvg = currentSum/(i-j);
				System.out.println("currAvg: "+ currAvg);
				if (minAvg > currAvg ){
					start = j;
					minAvg = currAvg;
				}
				System.out.println("minAvg: "+ minAvg);
				System.out.println("start: "+ start);
			}
		}
		return start;
	}
	
	public static int[] prefixSum(int[] ar){
		int n = ar.length;
		int[] result = new int[n+1];
		
		result[0]= 0;
		for (int i = 0; i < n; i++) {
			result[i+1] = result[i]+ar[i];
		}
		
		return result;
	}

}