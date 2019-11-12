package basic;

public class STRB02MaxOccurringChar {

	public static void main(String[] args) {
		System.out.println(getMaxOccurringChar("cmpfmeomneur"));

	}
	/*	If more than one character have the same and maximum count
	    then function returns only the first character in alphabetical order.
	 */
	
	public static char getMaxOccurringChar(String string){
		int len = string.length();
		int [] count = new int[256] ;
		
		for (int i = 0; i < len; i++) {
			char val = string.charAt(i);
			int pos = (int )(val -'a');
			count[pos]++;
		}
		
		int maxIndex = 0;
		for (int i = 0; i < count.length; i++) {
			if (count[maxIndex] < count[i])
				maxIndex = i;
		}
		return (char)(maxIndex +'a');
	}

}
