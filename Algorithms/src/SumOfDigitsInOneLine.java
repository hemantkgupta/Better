
public class SumOfDigitsInOneLine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getSum(1234));
		System.out.println(sumDigits(1234));
	}
	
	public static int getSum(int n)
	{
	    int sum;
	    for(sum=0; n > 0; sum+=n%10,n/=10);
	    return sum;
	}
	
	public static int sumDigits(int no)
	{
	  return no == 0 ? 0 : no%10 + sumDigits(no/10) ;
	}

}
