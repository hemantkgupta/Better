package basic;

/**
 * The program find the duplicate characters in a
 * string from a set. It prints them and also removes
 * them from the string
 *
 */

public class STRB03PrintAndRemoveDuplicateChars {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Unique chars string: "+printAndremoveDuplicateChars("atest"));
	}
	
	public static String printAndremoveDuplicateChars(String str){

		boolean[] hasCharArray = new boolean[256];

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);
			int val = str.charAt(i);
			System.out.println(" The val in int is "+val);

			if (hasCharArray[val]) {
				System.out.println("Duplicate char is: "+ch);
				str = str.substring(0, i)+ str.substring(i+1);
			}

			hasCharArray[val] = true;
		}
		return str;
	}

}
