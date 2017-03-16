import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by ghemant on 3/10/17.
 */
public class BigFactorial {
    public static void main(String[] args) {
        //Scanner scan = new Scanner(System.in);
        //int n = scan.nextInt();
        System.out.println(getFactorial(100).toString());
    }

    public static BigInteger getFactorial(int n){
        if(n==0 || n==1){
            return new BigInteger("1");
        } else{
            BigInteger nBigInteger = new BigInteger(Integer.toString(n));
            return nBigInteger.multiply(getFactorial(n-1));
        }
    }
}
