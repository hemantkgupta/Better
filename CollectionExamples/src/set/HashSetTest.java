package set;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] words = new String[] {"i", "came", "i", "saw",  "i",  "left"};
		Set<String> s = new HashSet<String>();
        for (String a : words)
            if (!s.add(a))
                System.out.println("Duplicate detected: " + a);

        System.out.println(s.size() + " distinct words: " + s);
	}

}
