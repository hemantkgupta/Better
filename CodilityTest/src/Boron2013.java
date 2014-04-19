import java.util.ArrayList;


public class Boron2013 {

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
			    System.out.println(solution(A));
	}
	
	public static int solution(int[] A){
		int N = A.length;

	    ArrayList<Integer> peaks = new ArrayList<Integer>();
	    for(int i = 1; i < N-1; i++){
	        if(A[i] > A[i-1] && A[i] > A[i+1]) peaks.add(i);
	    }
	    
	    int noOfPeaks = peaks.size();
	    if(peaks.size()== 0){
	    	return 0;
	    }else if(peaks.size()== 1){
	    	return 1;
	    }
	    
	  //  int noOfFlags = (int) Math.sqrt((double)noOfPeaks);
	    int noOfFlags = noOfPeaks;
	    System.out.println("noOfFlags : "+noOfFlags);
	    for (int i=noOfFlags; i >= 1;i-- ){
	    	for (int j = 1; j < peaks.size(); j++) {
	    		int countOfFlags = 1;
	    		if (peaks.get(j)-peaks.get(j-1)< i){
	    			continue;
	    		} else {
	    			countOfFlags++;
	    		}
	    		if (countOfFlags < i){
	    			continue;
	    		} else {
	    			System.out.println("countOfFlags : "+ countOfFlags);
	    			break;
	    		}
			}
	    }
	    
	    return 0;
		
	}

}