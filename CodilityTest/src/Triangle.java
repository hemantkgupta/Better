import java.util.Arrays;


public class Triangle {

	public static void main(String[] args) {

	}
	
	 public static int solution(int[] A) {
		 Arrays.sort(A);
		 int len = A.length;
		 for (int i = 0; i < len-2; i++) {
			 long first = A[i];
			 long second = A[i+1];
			 long third = A[i+2];
			 long sum = first+second;
			 if (sum > third){
				 return 1;
			 }
		 }	
		 return 0;
		}
	        
	 }


