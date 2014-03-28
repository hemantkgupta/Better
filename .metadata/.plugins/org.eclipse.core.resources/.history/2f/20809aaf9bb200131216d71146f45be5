////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
class BubbleSort
  {
  public static void main(String[] args)
   {	  
   int ar[] = {2,6,4,3,5,7,8,9,1};	 
   display(ar);
   bubbleSort(ar);
   display(ar);
  }
  
//--------------------------------------------------------------
  public static void display(int[] a)       // displays array contents
   {
   for(int j=0; j<a.length; j++)    // for each element,
     System.out.print(a[j] + " "); // display it
   System.out.println("");
   }
//--------------------------------------------------------------
  public static void bubbleSort(int[] a)
   {
   int i, j;

   for(i=(a.length-1); i>0; i--)  // outer loop (backward)
	 // write inner loop first so that limits are clear 
     for(j=0; j<i; j++)    // inner loop (forward)
      if( a[j] > a[j+1] )    // out of order?
        swap(a, j, j+1);     // swap them
   } // end bubbleSort()
//--------------------------------------------------------------
  public static void swap(int[] a, int one, int two)
   {
   int temp = a[one];
   a[one] = a[two];
   a[two] = temp;
   }// end main()
  } // end class BubbleSortApp