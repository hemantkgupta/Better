package basic;

import java.util.Arrays;


public class BT01PrintAllPermutations {

	public static void main(String[] args) {
		printAllpermutations("ABC");
	}
	
	public static void printAllpermutations(String str){
		char[] chars = str.toCharArray();
		printPerms(chars, 0, str.length()-1);
		
	}
	
	public static void printPerms(char[] ar, int startIndex, int endIndex){
		if(startIndex == endIndex ){
			System.out.println(Arrays.toString(ar));
		}else {
			for(int j=startIndex; j<= endIndex; j++){
				swap(ar, startIndex, j);
				printPerms(ar, startIndex+1, endIndex);
				swap(ar, j, startIndex); // backtrack
			}
		}
	}
	
	public static void swap(char[] ar, int i, int j){
		char c = ar[i];
		ar[i]= ar[j];
		ar[j]=c;
	}

}
