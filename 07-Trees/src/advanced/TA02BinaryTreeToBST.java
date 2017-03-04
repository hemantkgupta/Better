package advanced;

import java.util.Arrays;

public class TA02BinaryTreeToBST {

	public static void main(String[] args) {
		
			BNode root = new BNode(1);
			root.left = new BNode(2);
			root.right = new BNode(3);
			root.left.left = new BNode(4);
			root.left.right = new BNode(5);
			root.right.left = new BNode(6);
			binaryTreeToBST(root);
		
	}
	
	// This function converts a given Binary Tree to BST
	public static void binaryTreeToBST (BNode root)
	{
	    if(root == null)
	       return;

	    //Store inorder traversal of tree in arr[]
	    int n = countNodes (root);
	    int[] arr = new int[n];
	    storeInorder (root, arr);

		// Sort the array
	    Arrays.sort(arr);
	 
	    // Create BST from sorted array
	    BNode bst = sortedArrayToBST (arr, 0, arr.length-1);
	    printInorder(bst);
	 
	  
	}
	
	public static BNode sortedArrayToBST(int arr[], int start, int end) {
		if (start > end)
			return null;
		int mid = (start + end) / 2;
		BNode root = new BNode(arr[mid]);
		root.left = sortedArrayToBST(arr, start, mid - 1);
		root.right = sortedArrayToBST(arr, mid + 1, end);
		return root;
	}
	
	/* A helper function to count nodes in a Binary Tree */
	public static int countNodes (BNode root)
	{
	    if (root == null)
	     return 0;
	    return countNodes (root.left) +
	           countNodes (root.right) + 1;
	}
	 
	public static int index;

	public static void storeInorder(BNode node, int[] in) {
		if (node == null)
			return;
		storeInorder(node.left, in);
		in[index]= node.data;
		index++;
		storeInorder(node.right, in);
	}
	
	public static void printInorder(BNode node) {
		if (node == null)
			return;

		printInorder(node.left);
		System.out.format("%d ", node.data);
		printInorder(node.right);
	}

}
