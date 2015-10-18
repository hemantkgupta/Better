package sort.advanced;

import java.util.ArrayDeque;
import java.util.Deque;


public class MaximumOfAllSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// A Dequeue (Double ended queue) based method for printing maixmum element of
	// all subarrays of size k
	public static void printKMax(int arr[], int n, int k)
	{
	    // Create a Double Ended Queue, Qi that will store indexes of array elements
	    // The queue will store indexes of useful elements in every window and it will
	    // maintain decreasing order of values from front to rear in Qi, i.e., 
	    // arr[Qi.front[]] to arr[Qi.rear()] are sorted in decreasing order
	    Deque<Integer> Qi = new ArrayDeque<Integer>(k);
	 
	    /* Process first k (or first window) elements of array */
	    int i;
	    for (i = 0; i < k; ++i)
	    {
	        // For very element, the previous smaller elements are useless so
	        // remove them from Qi
	        while ( (!Qi.isEmpty()) && arr[i] >= Qi.peekLast())
	            Qi.removeLast() ;// Remove from rear
	 
	        // Add new element at rear of queue
	        Qi.offerLast(i);
	    }
	 
	    // Process rest of the elements, i.e., from arr[k] to arr[n-1]
	    for ( ; i < n; ++i)
	    {
	        // The element at the front of the queue is the largest element of
	        // previous window, so print it
	        System.out.println(Qi.peekFirst());
	 
	        // Remove the elements which are out of this window
	     //   while ( (!Qi.isEmpty()) && Qi.front() <= i - k)
	            Qi.removeFirst();  // Remove from front of queue
	 
	        // Remove all elements smaller than the currently
	        // being added element (remove useless elements)
	        while ( (!Qi.isEmpty()) && arr[i] >= Qi.peekLast())
	            Qi.removeLast();
	 
	         // Add current element at the rear of Qi
	        Qi.offerLast(i);
	    }
	 
	    // Print the maximum element of last window
	   System.out.println(Qi.peekFirst());
	}

}
