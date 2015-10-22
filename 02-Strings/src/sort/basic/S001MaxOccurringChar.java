package sort.basic;

public class S001MaxOccurringChar {

	public static void main(String[] args) {
		System.out.println(getMaxOccuringChar("cmpfmeomneur"));

	}
	
	public static char getMaxOccuringChar(String string){
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