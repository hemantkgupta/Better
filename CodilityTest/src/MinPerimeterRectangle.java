import java.util.Arrays;


public class MinPerimeterRectangle {

	public static void main(String[] args) {
		System.out.println(solution(30));

	}
	
	public static int solution(int N) {
		
		if (N==1){
			return 4;
		}		
		int noOfDivisors = (int) Math.sqrt((double)N);
		int[] divisors = new int[noOfDivisors];
		int  divisorsIndex = 0;
		int i=1;
		while (i*i <= N){
			if (N%i==0){
				divisors[divisorsIndex] =i;
				divisorsIndex++;
			}
			i++;
		}
	//	System.out.println(Arrays.toString(divisors));
		int minPerimeter = Integer.MAX_VALUE;
		for (int k=0; k< divisors.length;k++){
			int firstDivisor = divisors[k];
			if(firstDivisor !=0){ 
				int currPeri = 2* (divisors[k] + (N/divisors[k]));
				if (currPeri < minPerimeter){
					minPerimeter = currPeri;
				}
			}	
		}
		return minPerimeter;
    }

}