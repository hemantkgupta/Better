
public class PrintReverseStringRecursion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		printReverse("abcde");
	}
	
	public static void printReverse(String str){
		
		if(str.length() == 1){
			System.out.print(str);
			return;
		}		
		printReverse(str.substring(1));		
		System.out.print(str.charAt(0));
	}

}
