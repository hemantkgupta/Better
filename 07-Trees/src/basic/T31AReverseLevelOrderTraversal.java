package basic;

import advanced.*;

public class T31AReverseLevelOrderTraversal {

	public static void main(String[] args) {
		advanced.BNode root = new advanced.BNode(10);
		root.left = new advanced.BNode(9);
		root.right = new advanced.BNode(2);
		root.left.left = new advanced.BNode(7);
		root.left.right = new advanced.BNode(6);
		root.left.left.left = new advanced.BNode(5);
		root.left.right.right = new advanced.BNode(4);
		printReverseLevelOrder(root);
	}
	
	/* Function to print level order traversal a tree */
	public static void printReverseLevelOrder(advanced.BNode root) {
		 int h = height(root);
		 for (int i = h; i >= 1; i--){
			 System.out.println("\nThe level "+ i+ " is : ");
			 printGivenLevel(root, i);
		 }
	}
	
	private static void printGivenLevel(advanced.BNode root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.format("%d ", root.data);
		else if (level > 1) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}
	
	public static int height(advanced.BNode root) {

		if (root == null) {
			return 0;
		}
		int lheight = height(root.left);
		int rheight = height(root.right);
		if (lheight > rheight) {
			return lheight + 1;
		} else
			return rheight + 1;
	}


}
