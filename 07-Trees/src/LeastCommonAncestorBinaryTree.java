public class LeastCommonAncestorBinaryTree {

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
		System.out.println(findLCA(root, 8, 10).data);

	}

	// Get LCA of two given values n1 and n2, both are present
	public static BNode findLCA(BNode root, int n1, int n2) {
		// Base case
		if (root == null)
			return null;

		// If either n1 or n2 matches with root's key, report
		// the presence by returning root (Note that if a key is
		// ancestor of other, then the ancestor key becomes LCA
		if (root.data == n1 || root.data == n2)
			return root;

		// Look for keys in left and right subtrees
		BNode left_lca = findLCA(root.left, n1, n2);
		BNode right_lca = findLCA(root.right, n1, n2);

		// If both of the above calls return Non-NULL, then one key
		// is present in once subtree and other is present in other,
		// So this node is the LCA
		if (left_lca != null && right_lca != null)
			return root;

		// Otherwise check if left subtree or right subtree is LCA
		return (left_lca != null) ? left_lca : right_lca;
	}

}
