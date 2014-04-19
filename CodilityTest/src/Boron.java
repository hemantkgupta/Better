import java.util.Arrays;


public class Boron {

	public static void main(String[] args) {
		int[] A = new int[12];
	
		A[0] = 1 ;
			    A[1] = 5 ;
			    A[2] = 3 ;
			    A[3] = 4 ;
			    A[4] = 3 ;
			    A[5] = 4 ;
			    A[6] = 1 ;
			    A[7] = 2 ;
			    A[8] = 3 ;
			    A[9] = 4 ;
			    A[10] = 6 ;
			    A[11] = 2;
			    System.out.println(checkFlags(A, 3));

	}
	
	public static boolean[] createPeaks(int[] A){
			int N = A.length;
			boolean[] peaks = new boolean[N];
			 for(int i = 1; i < N-1; i++){
			        if(A[i] > A[i-1] && A[i] > A[i+1])
			        	peaks[i]=true;
			}
			 System.out.println(Arrays.toString(peaks));
			 return peaks;

	}
	
	public static int checkFlags(int[] A, int x){
		
		int N = A.length;
		boolean[] peaks = createPeaks(A);
		int flags = x;
		int pos = 0;
		while (pos < N && flags > 0){
			if (peaks[pos]){
				flags -= 1;
				pos += x;
			}else{
				pos += 1;
			}
		 }
		System.out.println("flags "+ flags);
		if (flags == 0)
			return x;
	    return 0;
	}

}