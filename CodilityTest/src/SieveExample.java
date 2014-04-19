import java.util.Arrays;


public class SieveExample {

	public static void main(String[] args) {
		/*boolean[] result = seive(17);
		
		for (int i = 0; i < result.length; i++) {
			if(result[i]==true)
				System.out.println(i);
		}*/
		
		int[] factor = onePrimeFactor(20);
		for (int i = 0; i < factor.length; i++) {
		
				System.out.print(factor[i]+ " ");
		}
	}
	
	public static boolean[] seive(int N){
		boolean[] seive = new boolean[N+1];
		Arrays.fill(seive, true);
		seive[0]=seive[1]=false;
		int i=2;
		while (i*i<=N){
			if (seive[i]== true){
				int k = i*i;
				while(k <= N){
					seive[k]=false;
					k+=i;
				}
			}
			i++;
		}
		return seive;
	}
	
	public static int[] onePrimeFactor(int N){
		int[] factor = new int[N+1];
		
		int i=2;
		while (i*i<=N){
			if (factor[i]== 0){
				int k = i*i;
				while(k <= N){
					if (factor[k]== 0){
						factor[k] = i;
					}
					k+=i;					
				}
			}
			i++;
		}
		return factor;
		
	}


} 