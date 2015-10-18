package sort.basic;

public class S002PrintAndRemoveDuplicateChars {

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
			if (hasCharArray[val]) {
				System.out.println("Duplicate char is: "+ch);
				str = str.substring(0, i)+ str.substring(i+1);
			}
			hasCharArray[val] = true;
		}
		return str;
	}

}
