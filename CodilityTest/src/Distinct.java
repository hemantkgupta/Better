import java.util.Arrays;


public class Distinct {

	public static void main(String[] args) {
		int[] A = {2,3,4,3,4,4,5,3,2,6,7,3,8,8,9,9};
		System.out.println(solution(A));
	}
	public static int solution(int[] A) {
		int len = A.length;
		if (len == 0){
			return 0;
		}else if (len == 1){
			return 1;
		}
        Arrays.sort(A);
        System.out.println(Arrays.toString(A));
        int count = 1;
        for (int i = 1; i < A.length; i++) {
			if(A[i-1]!=A[i]){
				count++;
			}
		}
        return count;
    }

}
