package basic;

/**
 * The program reverse a given string using
 * recursion
 */
public class STRB04ReverseStringUsingRecursion {

	public static void main(String[] args) {
		System.out.println(reverseString("hkg"));
	}
	
	public static String reverseString(String str){
		if(str.length()==0){
			return str;
		}else{
			char cur = str.charAt(0);
			return reverseString(str.substring(1)) + cur;
		}
	}

}
