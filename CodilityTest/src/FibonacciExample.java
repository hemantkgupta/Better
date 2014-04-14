
public class FibonacciExample {

	public static void main(String[] args) {
		for (int i = 0; i < 32; i++) {
			System.out.println(fibonacciDynPrg(i));
		}
	} 
	public static int fibonacci(int n){
		if (n <= 1)
			return n;
		return fibonacci(n-1)+fibonacci(n-2);
	}
	
	public static int fibonacciDynPrg(int n){
		int[] fib = new int[n+2];
	    fib[0]=0;
	    fib[1]=1;
	    for (int i=2; i<= n;i++){
	    	fib[i]=fib[i-1]+fib[i-2];
	    }
	    return fib[n];
	}

}
