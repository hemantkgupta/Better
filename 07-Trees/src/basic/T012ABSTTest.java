package basic;

import advanced.BNode;

public class T012ABSTTest {

	public static void main(String[] args) {
		BNode root = new BNode(5);
		root.left = new BNode(3);
		root.right = new BNode(9);
		root.left.left = new BNode(1);
		root.left.right = new BNode(4);
		root.right.left = new BNode(6);
		System.out.println(isBST(root));
	}
	
	public static boolean isBST(BNode node) {
		return (isBSTUtil(node, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

	/*
	 * Returns true if the given tree is a BST and its values are >= min and <=
	 * max.
	 */
	public static boolean isBSTUtil(BNode node, int min, int max) {

		//base case
		if (node == null)
			return true;

		/* false if this node violates the min/max constraint */
		if (node.data < min || node.data > max)
			return false;

		//recursive call
		return isBSTUtil(node.left, min, node.data-1)
				&& isBSTUtil(node.right, node.data + 1, max); 
																
																
	}

}
