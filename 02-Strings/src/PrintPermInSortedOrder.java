import java.util.Arrays;


public class PrintPermInSortedOrder {

	public static void main(String[] args) {
		char str[] = "ABCD".toCharArray();
		sortedPermutations(str);

	}
	
	// This function finds the index of the smallest character
	// which is greater than 'first' and is present in str[l..h]
	public static int findCeil (char str[], char first, int l, int h)
	{
	    // initialize index of ceiling element
	    int ceilIndex = l;
	 
	    // Now iterate through rest of the elements and find
	    // the smallest character greater than 'first'
	    for (int i = l+1; i <= h; i++)
	      if (str[i] > first && str[i] < str[ceilIndex])
	            ceilIndex = i;
	 
	    return ceilIndex;
	}
	 
	// Print all permutations of str in sorted order
	public static void sortedPermutations ( char str[] )
	{
	    // Get size of string
	    int size = str.length;
	 
	    Arrays.sort(str);
	 
	    // Print permutations one by one
	    boolean isFinished = false;
	    while ( ! isFinished )
	    {
	        // print this permutation
	        System.out.println(Arrays.toString(str));
	 
	        // Find the rightmost character which is smaller than its next
	        // character. Let us call it 'first char'
	        int i;
	        for ( i = size - 2; i >= 0; --i )
	           if (str[i] < str[i+1])
	              break;
	 
	        // If there is no such chracter, all are sorted in decreasing order,
	        // means we just printed the last permutation and we are done.
	        if ( i == -1 )
	            isFinished = true;
	        else
	        {
	            // Find the ceil of 'first char' in right of first character.
	            // Ceil of a character is the smallest character greater than it
	            int ceilIndex = findCeil( str, str[i], i + 1, size - 1 );
	 
	            // Swap first and second characters
	            swap( str[i], str[ceilIndex] );
	           // Sort the string on right of 'first char'
	            if (i+1 < size - i - 1){
	            	Arrays.sort(str, i+1, size - i - 1);
	            }
	        }
	    }
	}
	
	public static void swap(char a, char b){
		char temp = a;
		a = b;
		b = temp;
		
	}

}
