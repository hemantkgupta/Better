package longest.nondecreasing.sequence;

public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//int[] arr = {5, 3, 4, 8, 6, 7};
		int[] arr =  { 10, 22, 9, 33, 21, 50, 41, 60 };
		int[] seqL = {  1,  1, 1,  1,  1,  1,  1,  1};
		longestNDSequense(arr, seqL	);
		for (int i = 0; i < seqL.length; i++) {			
			System.out.println(seqL[i]);
		}
	}
	
	public static void longestNDSequense(int[] arr, int[] seqL){
		
		for(int i = 0; i < arr.length-1; i++){			
			if(arr[i] <= arr[i+1] && seqL[i] + 1 > seqL[i+1]){
				seqL[i+1] = seqL[i]+1; 
			}
		}
	}
}
