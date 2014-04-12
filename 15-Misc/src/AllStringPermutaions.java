import java.util.Arrays;

public class AllStringPermutaions {

	public static void main(String[] args) {
		permute ("ABC".toCharArray(), 0, 2);
	}

	public static void permute(char[] a, int startIndex, int nendIndex) {
		   int j; 
		   if (startIndex == nendIndex) {
		     System.out.println(Arrays.toString(a));
		   } else {
		        for (j = startIndex; j <= nendIndex; j++){
		          swap(a, startIndex, j);
		          permute(a, startIndex+1, nendIndex);
		          swap(a, j, startIndex); 
		       }
		   }
	}
	public static void swap(char[]a, int i, int j){
		char temp = a[i];
		a[i]= a[j];
		a[j] = temp;
	}
}
