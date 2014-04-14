import java.util.Arrays;


public class Ladder {

	public static void main(String[] args) {
		int[] A = new int[5];
		int[] B = new int[5];
				 A[0] = 4  ; B[0] = 3;
				    A[1] = 4  ; B[1] = 2;
				    A[2] = 5  ; B[2] = 4;
				    A[3] = 5;   B[3] = 3;
				    A[4] = 1 ;  B[4] = 1;
		System.out.println(Arrays.toString(solution(A,B)));
	}
	
	public static int[] solution(int[] A, int[] B){
		//a given N rungs, the number of different ways of climbing is 
		//the (N+1)th element in the Fibonacci numbers.
		int n = A.length;
		int[] results = new int[n];
		int[] fib = new int[n+2];
	    fib[1]=1;
	    for (int i=2; i<= n+1;i++){
	    	fib[i]=fib[i-1]+fib[i-2];
	    }
	    System.out.println(Arrays.toString(fib));
	    
	    for (int i = 0; i < n; i++) {
	    	B[i]= (1<< B[i])-1;
		}
	    
	    for (int i = 0; i < n; i++) 
	    	results[i]= fib[A[i]+1] & B[i];
		return results;
	}

}
