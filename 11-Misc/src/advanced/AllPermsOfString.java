package advanced;

public class AllPermsOfString {

	public static void main(String[] args) {
	permute(new char[] {'a','b','c'},0,2);
	}
	/* Function to print permutations of string
	   This function takes three parameters:
	   1. String
	   2. Starting index of the string
	   3. Ending index of the string. */
	public static void permute(char[] a, int i, int n) 
	{
	   int j; 
	   if (i == n)
	     printArray(a);
	   else
	   {
	        for (j = i; j <= n; j++)
	       {
	          swap(a, i, j);
	          permute(a, i+1, n);
	          swap(a, j, i); //backtrack
	       }
	   }
	}
	public static void printArray(char[] arr){
		System.out.println("");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" "+arr[i]);
		}
		
	}
	public static void swap(char[] arr, int fi, int si)
	{
	   char temp;
	  
	     temp = arr[fi];
	     arr[fi] = arr[si];
	     arr[si] = temp;
	 }     
}
	


