import java.util.Arrays;

public class MaxProfit {

	public static void main(String[] args) {
		int[] A = new int[6];
		A[0] = 23171;
		A[1] = 21011;
		A[2] = 21123;
		A[3] = 21366;
		A[4] = 21013;
		A[5] = 21367;
		System.out.println(solution(A));

	}

	public static int solution(int[] A) {
		int len = A.length;
		if (len == 0|| len ==1){
			return 0;
		}else if( len ==2){
			if (A[1]>A[0])
				return A[1]-A[0];
		}
		int diffSofar =0;
		int min = A[0];
		int diffMin = 0;
		for(int i = 1; i < len; i++){			
			
			diffMin = Math.max(0,A[i]-min);
			if (A[i] < min){
				min = A[i];
			}
			
			if (diffMin > diffSofar)
				diffSofar = diffMin;
		   
		  }
		
		return diffSofar;
	}
	
	public static int solution1(int[] A){
		 if(A.length == 1 || A.length == 0){
		        return 0;
		    }
		    
		    int maxSoFar = 0;
		    int maxEndingHere = 0;
		    int minPrice = A[0];
		    
		    for(int i = 1; i < A.length; i++){
		        maxEndingHere = Math.max(0, A[i] - minPrice);
		        minPrice = Math.min(minPrice, A[i]);
		        maxSoFar = Math.max(maxEndingHere, maxSoFar);
		    }
		    
		    return maxSoFar;
	}

}
