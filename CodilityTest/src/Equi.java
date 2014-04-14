
public class Equi {

	public static void main(String[] args) {

	}
	
	public static int equi(int[] arr, int n) {
	    if (n==0) return -1; 
	    long sum = 0;
	    int i; 
	    for(i=0;i<n;i++) sum += arr[i]; 

	    long sumLeft = 0;    
	    for(i=0;i<n;i++) {
	        long sumRight = sum - sumLeft - (long ) arr[i];
	        if (sumLeft == sumRight) return i;
	        sumLeft += arr[i];
	    } 
	    return -1; 
	} 

}
