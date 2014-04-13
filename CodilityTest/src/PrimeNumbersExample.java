
public class PrimeNumbersExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int divisors (int n){
		int i=1;
		int result = 0;
		while (i*i < n){
			if (n%i==0){
				result +=2;
			}
			i++;
		}
		if (i * i == n)
			result += 1;

		return result;
	}
	
	public static boolean primality(int n){
		int i = 2;
		while( i*i <= n){
			if (n%i==0)
				return false;
			i++;
		}
		return true;
	}
	
	/*public static int coin(int n){
		int result = 0;
		int [] coin = new int[n + 1];
		for (int j = 1; j < n+1; j++) {
			int k = j;
			while (k <= n){
				coin[k] = (coin[k] + 1) % 2;
				k += j;
			}
			result += coin[j];
		}
		
		
		return result;

	}*/

}
