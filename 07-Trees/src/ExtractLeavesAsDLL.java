public class ExtractLeavesAsDLL {

	public static void main(String[] args) {
		BNode root = new BNode(1);

		root.left = new BNode(2);
		root.right = new BNode(3);

		root.left.left = new BNode(4);
		root.left.right = new BNode(5);

		root.right.left = new BNode(6);
		root.right.right = new BNode(7);

		root.right.left.left = new BNode(8);
		root.right.left.right = new BNode(9);

		root.right.right.left = new BNode(10);
		root.right.right.right = new BNode(11);
		System.out.println("Initial in-order : ");
		printInorder(root);
		root = extractLeafList(root);
		System.out.println("\nFinal in-order : ");
		printInorder(root);
		System.out.println("\nLeaves DLL : ");
		System.out.println(head_ref);

	}

	private static BNode head_ref;

	// It extracts all leaves from given Binary Tree
	// returns new root of Binary Tree
	// updates static head_ref DLL of leaves
	public static BNode extractLeafList(BNode root) {
		if (root == null)
			return null;

		if (root.left == null && root.right == null) {
			root.right = head_ref;

			// Change left pointer of previous head
			if (head_ref != null)
				head_ref.left = root;

			// Change head of linked list
			head_ref = root;

			return null; // Return new root
		}

		root.right = extractLeafList(root.right);
		root.left = extractLeafList(root.left);

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
