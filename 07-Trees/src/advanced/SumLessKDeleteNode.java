package advanced;

public class SumLessKDeleteNode {

	public static void main(String[] args) {
		BNode root = new BNode(1);

		root.left = new BNode(2);
		root.right = new BNode(3);

		root.left.left = new BNode(4);
		root.left.right = new BNode(5);

		root.right.left = new BNode(6);
		root.right.right = new BNode(7);

		root.left.left.left = new BNode(8);
		root.left.left.right = new BNode(9);

		root.left.right.left = new BNode(10);
		root.left.right.right = new BNode(11);

		root.right.right.left = new BNode(12);
		root.right.right.right = new BNode(13);

		root.right.left.left = new BNode(14);
		root.right.left.right = new BNode(15);
		System.out.println("Before : ");
		printInorder(root);
		root = prune(root, 45);
		System.out.println("\nAfter : ");
		printInorder(root);
	}

	public static int sum;
	public static int lsum;
	public static int rsum;

	/* Main function which truncates the binary tree. */
	public static BNode prune(BNode root, int k) {
		// Base Case
		if (root == null)
			return null;

		// Initialize left and right sums as sum from root to
		// this node (including this node)
		lsum = sum + (root.data);
		rsum = lsum;

		// Recursively prune left and right subtrees
		root.left = prune(root.left, k);
		root.right = prune(root.right, k);

		// Get the maximum of left and right sums
		sum = Math.max(lsum, rsum);

		// to delete
		if (sum < k) {
			root = null;
		}

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
