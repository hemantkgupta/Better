
public class AbsTest {

	public static void main(String[] args) {
		System.out.println(getAbs(-7));
		System.out.println(getAbs(7));

	}
	/* This function will return absoulte value of n*/
	public static int getAbs(int n)
	{
	  int  mask = n >> 31;
	  return ((n + mask) ^ mask);
	}
}