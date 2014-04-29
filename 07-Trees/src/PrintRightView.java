public class PrintRightView {

	public static void main(String[] args) {
		BNode root = new BNode(20);
		root.left = new BNode(8);
		root.right = new BNode(22);
		root.left.left = new BNode(4);
		root.left.right = new BNode(12);
		root.left.right.left = new BNode(10);
		root.left.right.right = new BNode(14);
		rightViewUtil(root, 1);
	}

	private static int max_level = 0;

	// Recursive function to print right view of a binary tree.
	public static void rightViewUtil(BNode root, int level) {
		// Base Case
		if (root == null)
			return;

		// If this is the first Node of its level
		if (max_level < level) {
			System.out.printf("%d\t", root.data);
			max_level = level;
		}

		// Recur for right subtree first, then left subtree
		rightViewUtil(root.right, level + 1);
		rightViewUtil(root.left, level + 1);
	}

}
