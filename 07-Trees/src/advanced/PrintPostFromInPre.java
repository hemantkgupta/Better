package advanced;

import java.util.Arrays;


public class PrintPostFromInPre {

	public static void main(String[] args) {
		  int in[] = {4, 2, 5, 1, 3, 6};
		   int pre[] =  {1, 2, 4, 5, 3, 6};
		 printPostOrder(in, pre, 6);
		

	}
	
	// Prints postorder traversal from given inorder and preorder traversals
	public static void printPostOrder(int in[], int pre[], int n)
	{
	   // The first element in pre[] is always root, search it
	   // in in[] to find left and right subtrees
	   int root = search(in, pre[0], n);
	 
	   // If left subtree is not empty, print left subtree
	   if (root != 0){
	      printPostOrder(in, Arrays.copyOfRange(pre, 1, root), root);
	   }
	   // If right subtree is not empty, print right subtree
	   if (root != n-1){
	      printPostOrder(Arrays.copyOfRange(in, root+1,n-root-1), Arrays.copyOfRange(pre, root+1, n-root-1), n-root-1);
	   }
	   // Print root
	  System.out.println(pre[0]+" ");
	}
	
	public static int search(int arr[], int x, int n)
	{
	    for (int i = 0; i < n; i++)
	      if (arr[i] == x)
	         return i;
	    return -1;
	}
	
	
	 

}
