package coin.sum.problem;

public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		coinSum();
	}
	
			
	public static void coinSum(){
		int [] v = {1, 3, 5};
		int s = 11;
		int[] min = new int[12];
		for (int i = 0; i < min.length; i++) {
			min[i]=Integer.MAX_VALUE;
		}
		
		for(int i = 0; i <= s ; i++){
			for (int j=0; j< 3;j++){
				int temp = v[j];
				if( temp <=i && min[i-temp]+1 < min[i] ){
					min[i]= min[i-temp] + 1;
				}
			}
		}
		for (int i = 0; i < min.length; i++) {
			
			System.out.println(min[i]-Integer.MAX_VALUE);
		} 
	}

}
