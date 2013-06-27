package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap<String, Integer>();

		String [] values = new String []{"if", "it", "is", "to" ,"be" ,"it" ,"is" ,"up" ,"to", "me" ,"to" ,"delegate"};
        for (String a : values) {
            Integer freq = m.get(a);
            m.put(a, (freq == null) ? 1 : freq + 1);
        }

        System.out.println(m.size() + " distinct words:");
        System.out.println(m);
        
        System.out.println("Does HashMap contains it as key: " + m.containsKey("it"));
        System.out.println("Does HashMap contains 7 as value: " + m.containsValue(7));
        
        System.out.println("Output by keySet().iterator() while loop");
        
        Iterator<String> it = m.keySet().iterator();
          
        while(it.hasNext()){
        	String key = it.next();
        	System.out.println(key);
        }
        
        System.out.println("Output by keySet()");
        for (String key : m.keySet())
        	System.out.println(key);
        
        System.out.println("Output by entrySet()");
        for (Map.Entry<String, Integer> e : m.entrySet())
            System.out.println(e.getKey() + ": " + e.getValue());
        
        System.out.println("Output by keySet().iterator()");
        for (Iterator<String> it2 = m.keySet().iterator(); it2.hasNext(); )
        	System.out.println(it2.next());
	}

}
