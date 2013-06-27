package map;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String, Integer> m = new LinkedHashMap<String, Integer>();

		String [] values = new String []{"if", "it", "is", "to" ,"be" ,"it" ,"is" ,"up" ,"to", "me" ,"to" ,"delegate"};
        for (String a : values) {
            Integer freq = m.get(a);
            m.put(a, (freq == null) ? 1 : freq + 1);
        }

        System.out.println(m.size() + " distinct words:");
        System.out.println(m);
        
        
	}

}
