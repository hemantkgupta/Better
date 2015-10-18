package advanced;


import basic.*;

public class T019MorrisInorderTraversal {

	public static void main(String[] args) {
		basic.BNode root = new basic.BNode(20);
		root.left = new basic.BNode(9);
		root.right = new basic.BNode(21);
		root.left.left = new basic.BNode(8);
		root.left.right = new basic.BNode(15);
		root.left.right.left = new basic.BNode(10);
		root.left.right.right = new basic.BNode(16);
		MorrisTraversal(root);
	}

	/*
	 * Function to traverse binary tree without recursion and without stack
	 */
	public static void MorrisTraversal(basic.BNode root) {
		basic.BNode current, pre;
		if (root == null)
			return;
		current = root;
		
		while (current != null) {
			
			if (current.left == null) {
				System.out.printf(" %d ", current.data);
				current = current.right;
			} else {
				/* Find the inorder predecessor of current */
				pre = current.left;
				while (pre.right != null && pre.right != current)
					pre = pre.right;

				/* Make current as right child of its inorder predecessor */
				if (pre.right == null) {
					pre.right = current;
					current = current.left;
				}

				/*
				 * Revert the changes made in if part to restore the original
				 * tree i.e., fix the right child of predecssor
				 */
				else {
					pre.right = null;
					System.out.printf(" %d ", current.data);
					current = current.right;
				} 
			} 
		} 
	}

}
