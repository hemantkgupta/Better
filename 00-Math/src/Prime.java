import java.util.ArrayList;
import java.util.List;

/**
 * Created by ghemant on 3/4/17.
 */
public class Prime {

    public static void main(String[] args) {
        System.out.println(isPrime(25));
        findPrimeSieveOfEratosthenes(10);
        findPrimeFactors(36);
    }

    /**
     * If the number N is divisible by any number
     * between 2 and the sqrt(N) then the N is not prime
     * @param n the input number
     * @return true if n is prime
     */
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

    /**
     * Prints all prime numbers from one to n
     * @param n the input number
     */

    public static void findPrimeSieveOfEratosthenes(int n){

        // Add all numbers from 2 to n in a list
        List<Integer> numbers = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            numbers.add(i);
        }

        // For each number in the list, check if rest
        // of the numbers are divisible or not, if yes
        // remove it from the list
        for (int i = 0; i < numbers.size() ; i++) {
            int divider = numbers.get(i);

            for (int j = i+1; j < numbers.size() ; j++) {
                if(numbers.get(j)%divider ==0 ){
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
