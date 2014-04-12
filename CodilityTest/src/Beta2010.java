

public class Beta2010 {

	public static void main(String[] args) {
		int[] A = {1,5,2,1,4,0};
		System.out.println(solution(A));
	}
	
	public  static int solution(int[] A) {
		int len = A.length;
		long result = 0;
		int[] dps = new int[len];
		int[] dpe = new int[len];
		for (int i = 0; i < A.length; i++)
	    {
	        dps[Math.max(0, i - A[i])]++;
	        dpe[Math.min(A.length - 1, i + A[i])]++;
	    }

	    long t = 0;
	    for (int i = 0; i < A.length; i++)
	    {
	        if (dps[i] > 0)
	        {
	            result += t * dps[i];
	            result += dps[i] * (dps[i] - 1) / 2;
	            t += dps[i];
	        }
	        t -= dpe[i];
	    }
	    if (result > 10000000){
	    	return -1;
	    }
	    return (int)result;
		
    }

}
