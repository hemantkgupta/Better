package sort.basic;

public class S003ReverseStringUsingRecursion {

	public static void main(String[] args) {
		System.out.println(reverseString("hkg"));
	}
	
	public static String reverseString(String str){
		if(str.length()==0){
			return str;
		}else{
			char cur = str.charAt(0);
			String rev = reverseString(str.substring(1));
			return new StringBuilder(rev).append(cur).toString();
		}
	}

}
