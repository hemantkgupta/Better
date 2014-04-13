import java.util.ArrayList;


public class Peaks {

	public static void main(String[] args) {
		int[] A = new int[12];
		A[0] = 1;
			    A[1] = 2;
			    A[2] = 3;
			    A[3] = 4;
			    A[4] = 3;
			    A[5] = 4;
			    A[6] = 1;
			    A[7] = 2;
			    A[8] = 3;
			    A[9] = 4;
			    A[10] = 6;
			    A[11] = 2;
			    System.out.println(solution(A));

	}
	
	public static int solution(int[] A){
		int N = A.length;

	    ArrayList<Integer> peaks = new ArrayList<Integer>();
	    for(int i = 1; i < N-1; i++){
	        if(A[i] > A[i-1] && A[i] > A[i+1]) peaks.add(i);
	    }

	    for(int size = 1; size <= N; size++){
	        if(N % size != 0) continue;
	        int find = 0;
	        int groups = N/size;
	        boolean ok = true;
	        for(int peakIdx : peaks){
	            if(peakIdx/size > find){
	                ok = false;
	                break;
	            }
	            if(peakIdx/size == find) find++;
	        }
	        if(find != groups) ok = false;
	        if(ok) return groups;
	    }

	    return 0;
	}

}
