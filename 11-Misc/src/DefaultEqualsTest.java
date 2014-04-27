
public class DefaultEqualsTest {
	
	private int initial = 0;
	public static void main(String[] args) {
		DefaultEqualsTest abc = new DefaultEqualsTest();
		Object xyz = abc;
		if(abc == xyz)
			System.out.println("ref equal");
		if(abc != xyz)
			System.out.println("ref not equal");
		if(abc.equals(xyz))
			System.out.println("equals called from my object");
		if(xyz.equals(abc))
			System.out.println("equals called from object");
	}

}
