package advanced;

public class TA03BoundaryTraversal {

	public static void main(String[] args) {
		BNode root = new BNode(20);
		root.left = new BNode(8);
		root.left.left = new BNode(4);
		root.left.right = new BNode(12);
		root.left.right.left = new BNode(10);
		root.left.right.right = new BNode(14);
		root.right = new BNode(22);
		root.right.right = new BNode(25);
		printBoundary(root);

	}
	
	public static void printBoundary(BNode root) {
		if (root != null) {
			System.out.printf("%d ", root.data);
			printBoundaryLeft(root.left);
			printLeaves(root.left);
			printLeaves(root.right);
			printBoundaryRight(root.right);
		}
	}

	public static void printLeaves(BNode root) {
		if (root != null) {
			printLeaves(root.left);
			if (root.left == null && root.right == null)
				System.out.printf("%d ", root.data);
			printLeaves(root.right);
		}
	}

	public static void printBoundaryLeft(BNode root) {
		if (root != null) {
			if (root.left != null) {
				// to ensure top down order, print the node
				// before calling itself for left subtree
				System.out.printf("%d ", root.data);
				printBoundaryLeft(root.left);
			} else if (root.right != null) {
				System.out.printf("%d ", root.data);
				printBoundaryLeft(root.right);
			}

		}
	}

	public static void printBoundaryRight(BNode root) {
		if (root != null) {
			if (root.right != null) {
				// to ensure bottom up order, first call for right
				// subtree, then print this node
				printBoundaryRight(root.right);
				System.out.printf("%d ", root.data);
			} else if (root.left != null) {
				printBoundaryRight(root.left);
				System.out.printf("%d ", root.data);
			}

		}
	}

	

}
