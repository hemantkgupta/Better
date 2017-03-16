import java.util.ArrayList;
import java.util.List;

/**
 * Created by ghemant on 3/4/17.
 */
public class Prime {

    public static void main(String[] args) {
        //System.out.println(isPrime(25));
        findPrimeSieveOfEratosthenes(10);
        findPrimeFactors(36);
    }
    public static boolean isPrime(int n){
        if (n==1 || n==2){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n%i == 0){
                return false;
            }
        }
        return true;
    }

    public static void findPrimeSieveOfEratosthenes(int n){
        List<Integer> numbers = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            numbers.add(i);
        }

        for (int i = 0; i < numbers.size() ; i++) {
            int dividor = numbers.get(i);
            for (int j = i+1; j < numbers.size() ; j++) {
                if(numbers.get(j)%dividor ==0 ){
                    numbers.remove(j);
                }
            }
        }

        System.out.println(numbers);
    }

    public static void findPrimeFactors(int n){
        if (n < 2)
            return;
        for (int i = 2 ; i < n ; i++) {
            if(n%i== 0){
                int counter = 0;
                while (n%i== 0){
                    n = n/i;
                    counter++;
                }
                System.out.println("The factor is: "+i+ " and the power is:"+counter);
            }
        }
    }
    
}
