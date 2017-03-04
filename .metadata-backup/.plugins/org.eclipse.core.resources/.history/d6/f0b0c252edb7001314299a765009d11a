public class TreeTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BNode root = new BNode(1);
		root.left = new BNode(2);
		root.right = new BNode(3);
		root.left.left = new BNode(4);
		root.left.right = new BNode(5);
		/*
		 * System.out.println("The pre order traversal is : ");
		 * printPreorder(root);
		 * System.out.println("\nThe in order traversal is : ");
		 * printInorder(root);
		 * System.out.println("\nThe post order traversal is : ");
		 * printPostorder(root);
		 * System.out.println("\nThe size of the tree is : "+size(root));
		 */

		BNode rootb = new BNode(1);
		rootb.left = new BNode(2);
		rootb.right = new BNode(3);
		rootb.left.left = new BNode(4);
		rootb.left.right = new BNode(5);
		rootb.left.right.left = new BNode(6);
		rootb.left.right.left.left = new BNode(7);
	//	System.out.println(identicalTrees(root, rootb));
	//	System.out.println("\n The depth of the tree is: "+maxDepth(rootb));
		
		 System.out.println("\nThe in order traversal is : ");
		 printInorder(root);
		 mirror(root);
		 System.out.println("\nThe in order traversal is : ");
		 printInorder(root);
	}
	
	/* Change a tree so that the roles of the  left and 
    right pointers are swapped at every node.
    */
	public static void mirror(BNode node) 
	{
	  if (node==null) 
	    return;  
	  else
	  {
	    BNode temp = new BNode();
	     
	    /* do the subtrees */
	    mirror(node.left);
	    mirror(node.right);
	 
	    /* swap the pointers in this node */
	    temp        = node.left;
	    node.left  = node.right;
	    node.right = temp;
	  }
	} 

	/*
	 * Compute the "maxDepth" of a tree -- the number of nodes along the longest
	 * path from the root node down to the farthest leaf node.
	 */
	public static int maxDepth(BNode node) {
		if (node == null)
			return 0;
		else {
			/* compute the depth of each subtree */
			int lDepth = maxDepth(node.left);
			int rDepth = maxDepth(node.right);

			/* use the larger one */
			if (lDepth > rDepth)
				return (lDepth + 1);
			else
				return (rDepth + 1);
		}
	}

	/*
	 * Given two trees, return true if they are structurally identical
	 */
	public static boolean identicalTrees(BNode a, BNode b) {
		/* 1. both empty */
		if (a == null && b == null)
			return true;

		/* 2. both non-empty . compare them */
		else if (a != null && b != null) {
			return (a.data == b.data && identicalTrees(a.left, b.left) && identicalTrees(
					a.right, b.right));
		}
		/* 3. one empty, one not . false */
		else
			return false;
	}

	/* Computes the number of nodes in a tree. */
	public static int size(BNode node) {
		if (node == null)
			return 0;
		else
			return (size(node.left) + 1 + size(node.right));
	}

	/*
	 * Given a binary tree, print its nodes according to the "bottom-up"
	 * postorder traversal.
	 */
	public static void printPostorder(BNode node) {
		if (node == null)
			return;

		printPostorder(node.left);
		printPostorder(node.right);
		System.out.print(node.data + " ");
	}

	/* Given a binary tree, print its nodes in inorder */
	public static void printInorder(BNode node) {
		if (node == null)
			return;
		printInorder(node.left);
		System.out.print(node.data + " ");
		printInorder(node.right);
	}

	/* Given a binary tree, print its nodes in pre order */
	public static void printPreorder(BNode node) {
		if (node == null)
			return;
		System.out.print(node.data + " ");
		printPreorder(node.left);
		printPreorder(node.right);
	}

}

class BNode {
	int data;
	BNode left;
	BNode right;

	public BNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public BNode() {

	}
}
