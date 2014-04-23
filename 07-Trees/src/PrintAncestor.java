public class PrintAncestor {

	public static void main(String[] args) {
		BNode root = new BNode(20);
		root.left = new BNode(8);
		root.right = new BNode(22);

		root.left.left = new BNode(4);
		root.left.right = new BNode(12);
		root.left.right.left = new BNode(10);
		root.left.right.right = new BNode(14);
		printAncestors(root, 12);
	}

	public static boolean printAncestors(BNode root, int target) {

		if (root == null)
			return false;

		if (root.data == target)
			return true;

		if (printAncestors(root.left, target)
				|| printAncestors(root.right, target)) {
			System.out.print(root.data + " ");
			return true;
		}

		return false;
	}

}
