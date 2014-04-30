public class NodesWithoutSiblings {

	public static void main(String[] args) {
		BNode root = new BNode(1);
		root.left = new BNode(2);
		root.right = new BNode(3);

		root.left.left = new BNode(4);
		//root.left.right = new BNode(5);

		root.right.left = new BNode(6);
		root.right.right = new BNode(7);

		root.right.left.left = new BNode(8);
		//root.right.left.right = new BNode(9);

		root.right.right.left = new BNode(10);
		//root.right.right.right = new BNode(11);
		printSingles(root);
	}

	// Function to print all non-root nodes that don't have a sibling
	public static void printSingles(BNode root) {
		if (root == null)
			return;
		
		if (root.left != null && root.right != null) {
			printSingles(root.left);
			printSingles(root.right);
		}

		// If left child is null and right is not
		else if (root.right != null) {
			System.out.println(root.right.data + " ");
			printSingles(root.right);
		}

		// If right child is null and left is not
		else if (root.left != null) {
			System.out.println(root.left.data + " ");
			printSingles(root.left);
		}
	}

}
