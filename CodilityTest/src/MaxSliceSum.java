
public class MaxSliceSum {

	public static void main(String[] args) {
		int[] A ={-4,-6, -4, -8 };
		System.out.println(solution(A));
	}
	public static int solution(int[]A){
		
		int maxEndingHere = A[0];
		int maxSlice = A[0];
		for (int i = 1; i < A.length; i++){
			maxEndingHere = Math.max(A[i], maxEndingHere + A[i]);
			maxSlice = Math.max(maxSlice, maxEndingHere);
		}	
		return maxSlice;

	}
}