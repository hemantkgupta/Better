import java.util.Vector;


public class VectorTest {

	public static void main(String[] args) {
		Vector<Integer> v = new Vector<Integer>();
		v.add(1);
		v.add(2);
		System.out.println(v);
		System.out.println(v.firstElement());
		System.out.println(v.lastElement());
		v.setElementAt(3, 1);
		System.out.println(v);
		v.set(1, 4);
		System.out.println(v);
		v.remove(0);
		v.removeElement(2);
	    System.out.println(v);	
	    v.insertElementAt(3, 1);
		
	}

}
