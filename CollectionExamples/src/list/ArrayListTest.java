package list;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ArrayListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		
		for (ListIterator<Integer> it = list.listIterator(list.size()); it.hasPrevious(); ) {
			Integer t = it.previous();
			System.out.println(t);
		}
	}

}
