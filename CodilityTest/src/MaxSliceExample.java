
public class MaxSliceExample {

	public static void main(String[] args) {
		int[] A ={5, -7, 3, 5, -2, 4, -1};
		System.out.println(maxSliceWithIndex(A));
		int[] sliceWithIndexArray =  maxSliceWithIndex(A);
		

	}
	
	public static int maxSlice(int[] A){
		
		int len = A.length;
		if (len == 1){
			return A[0];
		}
		int maxEndingHere = 0;
		int maxSlice = Integer.MIN_VALUE;
		for (int val : A) {
			maxEndingHere = Math.max(0, maxEndingHere + val);
			maxSlice = Math.max(maxSlice, maxEndingHere);
		}	
		return maxSlice;

	}
	
	public static int[] maxSliceWithIndex(int[] A){
		
		int maxEnding = 0;
		int maxEndingStart = 0;
		int maxEndingEnd = 0;
		int maxSlice = 0;
		int maxSliceStart = 0;
		int maxSliceEnd = 0;
		
		int[] sliceAndIndex = new int[3];
		
		for (int i = 0; i < A.length; i++) {
			int val = A[i];
		    if (maxEnding + val < 0){
		    	maxEnding = 0;
		    	maxEndingStart = i+1;
		    	maxEndingEnd = maxEndingStart;
		    }else {
		    	maxEnding = maxEnding + val;
		    	maxEndingEnd = i;
		    }
			if (maxSlice < maxEnding){
				maxSlice = maxEnding;
				maxSliceStart = maxEndingStart;
				maxSliceEnd = maxEndingEnd;
			}
			
		}	
		System.out.println("maxSliceStart :"+maxSliceStart);
		System.out.println("maxSliceEnd : "+maxSliceEnd);
		sliceAndIndex[0]= maxSlice;
		sliceAndIndex[1] = maxSliceStart;
		sliceAndIndex[2] = maxSliceEnd;

		return sliceAndIndex;
	}

}
