public class SimpleOperations {

	public static void main(String[] args) {
		BNode root = new BNode(10);
		BNode n1 = new BNode(9);
		BNode n2 = new BNode(8);
		root.left = n1;
		root.right = n2;
		BNode n3 = new BNode(7);
		BNode n4 = new BNode(6);
		n1.left = n3;
		n1.right = n4;
		BNode n5 = new BNode(5);
		BNode n6 = new BNode(4);
		n3.left = n5;
		n4.right = n6;
		// printPostorder(root);
		// printInorder(root);
		// printPreorder(root);
		// System.out.println("The size of tree is: " + size(root));
		System.out.println("The max depth of tree is: " + maxDepth(root));
		//System.out.println("The leaf nodes in tree is: " + countLeafNodes(root));
		System.out.println("The height of tree is: " + height(root));
		//printAllRootToLeafPaths(root);

	}

	public static void printPostorder(BNode node) {
		if (node == null)
			return;

		printPostorder(node.left);

		printPostorder(node.right);

		System.out.format("%d ", node.data);
	}

	public static void printInorder(BNode node) {
		if (node == null)
			return;

		printInorder(node.left);

		System.out.format("%d ", node.data);

		printInorder(node.right);
	}

	public static void printPreorder(BNode node) {
		if (node == null)
			return;

		System.out.format("%d ", node.data);

		printPreorder(node.left);

		printPreorder(node.right);

	}

	public static int size(BNode node) {
		if (node == null)
			return 0;
		else
			return (size(node.left) + 1 + size(node.right));
	}

	public static boolean identicalTrees(BNode a, BNode b) {
		/* 1. both empty */
		if (a == null && b == null)
			return true;

		/* 2. both non-empty . compare them */
		if (a != null && b != null) {
			return (a.data == b.data && identicalTrees(a.left, b.left) && identicalTrees(
					a.right, b.right));
		}

		/* 3. one empty, one not . false */
		return false;
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

	public static void printAllRootToLeafPaths(BNode root) {
		if (root != null) {
			paths(Integer.toString(root.data), root);
		} else {
			System.out.println("Tree is empty.");
		}
	}

	private static void paths(String path, BNode root) {
		if (root.left == null && root.right == null) {
			System.out.println(path);
		}
		if (root.left != null) {
			paths(path + root.left.data, root.left);
		}
		if (root.right != null) {
			paths(path + root.right.data, root.right);
		}
	}
	
	/* Function to calculate height of a tree */
	public static int height(BNode root){
		
		if (root == null){
			return 0;
		}
		int lheight = height(root.left);
		int rheight = height(root.right);
		if (lheight > rheight){
			return lheight + 1;
		}		
		return rheight + 1;
		
	}

	/* Function to print level order traversal a tree */
	public static void printLevelOrder(BNode root) {
		/*int h = height(root);
		for (int i = 1; i <= h; i++)
			printGivenLevel(root, i);*/
	}

	/* Print nodes at a given level */
	public static void printGivenLevel(BNode root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.format("%d ", root.data);
		else if (level > 1) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}
	/* Function to count leaf nodes in a tree */
	public static int countLeafNodes(BNode root){
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		return countLeafNodes(root.left)+countLeafNodes(root.right);		
	}
	

	/* Function to get diameter of a binary tree */
	public static int diameter(BNode tree)
	{
	   /* base case where tree is empty */
	   if (tree == null)
	     return 0;
	 
	  /* get the height of left and right sub-trees */
	  int lheight = height(tree.left);
	  int rheight = height(tree.right);
	 
	  /* get the diameter of left and right sub-trees */
	  int ldiameter = diameter(tree.left);
	  int rdiameter = diameter(tree.right);
	 
	  /* Return max of following three
	   1) Diameter of left subtree
	   2) Diameter of right subtree
	   3) Height of left subtree + height of right subtree + 1 */
	  return Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter));
	} 

}

class BNode {
	int data;
	BNode left;
	BNode right;

	public BNode(int data) {
		super();
		this.data = data;
		this.left = null;
		this.right = null;
	}

}
