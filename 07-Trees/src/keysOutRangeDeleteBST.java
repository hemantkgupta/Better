public class keysOutRangeDeleteBST {
	public static void main(String[] args) {
		BNode root = new BNode(6);

		root.left = new BNode(-13);
		root.right = new BNode(14);

		root.left.right = new BNode(-8);

		root.right.left = new BNode(7);
		root.right.right = new BNode(15);
		System.out.println("Before");
		printInorder(root);
		root= removeOutsideRange(root, -10, 13);
		System.out.println("\nAfter");
		printInorder(root);
	}

	// remove outside range nodes and returns the root of BST
	public static BNode removeOutsideRange(BNode root, int min, int max) {
		if (root == null)
			return null;

		// First fix the left and right subtrees of root
		root.left = removeOutsideRange(root.left, min, max);
		root.right = removeOutsideRange(root.right, min, max);

		
		if (root.data < min) {
			return  root.right;
		}
		if (root.data > max) {
			return  root.left;
		}
		//Root is in range
		return root;
	}

	public static void printInorder(BNode node) {
		if (node == null)
			return;

		printInorder(node.left);
		System.out.format("%d ", node.data);
		printInorder(node.right);
	}
}
