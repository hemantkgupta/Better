import java.util.Arrays;


public class AllpermsWithRepitition {

	public static void main(String[] args) {
		printAllPermsWithRepitition("ABC");
	}
	
	public static void printAllPermsWithRepitition(String str){
		int len = str.length();
		char[] input = str.toCharArray();
		char[] print = new char[len];
		Arrays.sort(input);
		printPerms(input, print, 0);
	}
	
	public static void printPerms(char[] ar, char[] print, int index){
		
		int len = ar.length;
		
		for (int i = 0; i < len; i++) {
			
			print[index] = ar[i];
			
			if ((len-1) == index){
				System.out.println(Arrays.toString(print));
			}else{
				printPerms(ar, print, index+1);
			}
		}
	}

}
