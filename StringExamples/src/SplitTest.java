public class SplitTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 ="ab5 ccc 45 @";
		String pattern = "\\d";		
		String[] tokens = s1.split(pattern);
		System.out.println("count " + tokens.length);
		for (String s : tokens)
			System.out.println(">" + s + "<");
	}

}
