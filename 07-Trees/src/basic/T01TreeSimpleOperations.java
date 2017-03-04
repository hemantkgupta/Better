package basic;


public class T01TreeSimpleOperations {

	public static void main(String[] args) {
		BNode root = new BNode(10);

		root.left = new BNode(9);
		root.right = new BNode(8);

		root.left.left = new BNode(7);
		root.left.right = new BNode(6);

		root.left.left.left = new BNode(5);
		root.left.right.right = new BNode(4);

		System.out.println("The height of tree is: " + height(root));
		// System.out.println("The leaf nodes in tree is: " +
		// countLeafNodes(root));
		// printAllRootToLeafPaths(root);

	}

	public static void printAllRootToLeafPaths(BNode root) {
		if (root != null) {
			paths(Integer.toString(root.data), root);
		} else {
			System.out.println("Tree is empty.");
		}
	}
    /*To print out all of its root-to-leaf paths one per line*/
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
	public static int height(BNode root) {

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

	
	/* Function to count leaf nodes in a tree */
	public static int countLeafNodes(BNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		return countLeafNodes(root.left) + countLeafNodes(root.right);
	}

}
