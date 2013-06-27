
public class TestAPI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String str = "All String function Example in java";
		String Lowercase = str.toLowerCase();
		System.out.println("Lower case String ==>" + Lowercase);

		String Uppercase = str.toUpperCase();
		System.out.println("Upper case String ==>" + Uppercase);

		System.out.println("Length of the given string ==>" + str.length());
		
		// Trim the given string i.e. remove all first and last the spaces from the string
		String tempstr = "    String trimming example   ";
		System.out.println("String before trimming ==>" + tempstr+"<==");
		System.out.println("String after trimming ==>" + tempstr.trim());
		
		System.out.println("Character at the index 3 is ==>" + str.charAt(4));
		System.out.println("Character at the index 9 is ==>" + str.charAt(9));

		// find the substring between two index range
		//The substring begins at the specified beginIndex and extends to the character at index endIndex - 1. 
		System.out.println("String between index 3 to 9 is ==>"+ str.substring(4, 9));

		System.out.println("String after replacement ==>"+ str.replace('a', 'Y'));
		
		// replace the substring with another substring
		System.out.println("String after replacement ==>"+ str.replace("java", "loan"));
	}

}
