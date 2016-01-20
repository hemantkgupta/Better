package advanced;

public class SimpleExamples {

	public static void main(String[] args) {

		System.out.println(oppositeSigns(2,-3));
	}


	public static int modulusDivisionByPowerOfTwo(int n, int d) {

		return n & (d - 1);
	}
	
	public static boolean oppositeSigns(int x, int y)
	{
	    return ((x ^ y) < 0);
	}

}
