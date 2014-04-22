
public class ParityOddEven {

	public static void main(String[] args) {
		System.out.println(getParity(7));

	}
	/* Function to get parity of number n. It returns true
	   if n has odd parity, and returns false if n has even
	   parity */
	public static boolean getParity(int n)
	{
	    boolean parity = false;
	    while (n != 0)
	    {
	        parity = !parity;
	        n      = n & (n - 1);
	    }        
	    return parity;
	}

}
