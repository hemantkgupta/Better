package longest.zigzag.sequence;

public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 };
		int[] zig = { 1,  2, 1,  1,  1,  1,  1,  1, 1,  1, 1};
		//int[] arr = { 70, 55, 13, 2, 99, 2, 80, 80, 80, 80, 100, 19, 7, 5, 5, 5, 1000, 32, 32 };
		//int[] zig = {  1,  2,  1, 1,  1, 1,  1,  1,  1,  1,   1,  1, 1, 1, 1, 1,    1,  1,  1 };
		longestZigZag(arr,zig);
		for (int i = 0; i < zig.length; i++) {			
	    	System.out.println(zig[i]);
		}
	}
	public static void longestZigZag(int[] arr, int[] zig){
		int max_ending_here = 2;
		boolean lastSign = ( arr[1] > arr[0] ) ?  true : false;
		
		for(int i = 2; i < arr.length; i++){
			boolean currentSign = ( arr[i] > arr[i-1] ) ?  true : false;
			System.out.println("For i: "+i+" last sign: "+lastSign+" and current sign: "+ currentSign);
			if( lastSign != currentSign){
				max_ending_here = max_ending_here +1;
				zig[i] =  max_ending_here;
				lastSign = currentSign;
			}		
			
		}

    }
	
}	

/*
int max_ending_here = 1;
 for(int i = 1; i < arr.length; i++){
	 if(arr[i-1]<= arr[i]){
		 max_ending_here = max_ending_here +1;
		 LIS[i] = max_ending_here;
	 }
	 
    }*/
