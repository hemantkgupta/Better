import java.util.Arrays;


public class ChocolatesByNumbers {

	public static void main(String[] args) {
		System.out.println(solution(10,4));
	}
	
	public static int solution(int N, int M){
		return N/gcd(N,M);
	}
	public static int gcd(int a, int b){
		if (a<b){
			return gcd(b,a);
		}
		if (a%b==0)
			return b;
		return gcd(b, a%b);
	}
	public static int solution1(int N, int M){
		if(M==1){
			return N;
		}
		if(N==1){
			return 1;
		}
		int chocolatesEaten = 0;
		boolean[] chocolates = new boolean[N];
		Arrays.fill(chocolates, true);
		int i=0;
		while(true){
			chocolates[i] = false;
			chocolatesEaten++;
			i = (i+M) % N;
			if(chocolates[i]==false)
				break;
		}
		return chocolatesEaten;
	}

}
