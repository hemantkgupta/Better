package backtracking.basic;

public class B16AdditionWithoutAO {

	public static void main(String[] args) {
		System.out.println(Add(23, 14));
		System.out.println(AddRecr(23, 14));
	}
	public static int Add(int x, int y)
	{
	    // Iterate till there is no carry  
	    while (y != 0)
	    {
	        //Carry now contains common set bits of x and y
	        int carry = x & y;  
	 
	        //Sum of bits of x and y where only one bit is set
	        x = x ^ y; 
	 
	        // Carry is shifted by one bit so that adding it to x gives the required sum
	        y = carry << 1;
	    }
	    return x;
	}
	
	public static int AddRecr(int x, int y)
	{
	    if (y == 0)
	        return x;
	    else
	        return AddRecr( x ^ y, (x & y) << 1);
	}

}
