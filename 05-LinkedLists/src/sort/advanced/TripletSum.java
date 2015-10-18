package sort.advanced;

public class TripletSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/* A function to chech if there are three elements in a, b and c whose sum 
	   is equal to givenNumber.  The function assumes that the list b is sorted
	   in ascending order and c is sorted in descending order. */
	public boolean isSumSorted(Node headA, Node headB, 
	                 Node headC, int givenNumber)
	{
	    Node a = headA;
	 
	    // Traverse through all nodes of a
	    while (a != null)
	    {
	        Node b = headB;
	        Node c = headC;
	 
	        // For every node of list a, prick two nodes from lists b abd c
	        while (b != null && c != null)
	        {
	            // If this a triplet with given sum, print it and return true
	            int sum = a.data + b.data + c.data;
	            if (sum == givenNumber)
	            {
	               System.out.printf ("Triplet Found: %d %d %d ", a.data, b.data, c.data);
	               return true;
	            }
	 
	            // If sum of this triplet is smaller, look for greater values in b
	            else if (sum < givenNumber)
	                b = b.next;
	            else // If sum is greater, look for smaller values in c
	                c = c.next;
	        }
	        a = a.next;  // Move ahead in list a
	    }
	 
	    System.out.printf ("No such triplet");
	    return false;
	}

}
