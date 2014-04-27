package largest.independent.set;

public class LargestIndependentSet {

	public static void main(String[] args) {
		BNode root = new BNode(10);
		root.left = new BNode(20);
		root.right = new BNode(30);
		root.left.left = new BNode(40);
		root.left.right = new BNode(50);
		root.left.right.left = new BNode(70);
		root.left.right.right = new BNode(80);
		root.right.right = new BNode(60);
		System.out.println(LISS(root));
		//System.out.println(LISSDP(root));

	}

	// largest independent set in a binary tree
	public static int LISS(BNode root) {
		if (root == null)
			return 0;

		// Caculate size excluding the current node
		int excl = LISS(root.left) + LISS(root.right);

		// Calculate size including the current node
		int incl = 1;

		if (root.left != null)
			incl += LISS(root.left.left) + LISS(root.left.right);
		if (root.right != null)
			incl += LISS(root.right.left) + LISS(root.right.right);

		// Return the maximum of two sizes
		return Math.max(incl, excl);
	}

	// A memoization for largest independent set binary tree
	public static int LISSDP(BLNode root) {
		if (root == null)
			return 0;

		if (root.liss != 0)
			return root.liss;

		if (root.left == null && root.right == null)
			return (root.liss = 1);

		// Caculate size excluding the current node
		int liss_excl = LISS(root.left) + LISS(root.right);

		// Calculate size including the current node
		int liss_incl = 1;
		if (root.left != null)
			liss_incl += LISS(root.left.left) + LISS(root.left.right);
		if (root.right != null)
			liss_incl += LISS(root.right.left) + LISS(root.right.right);

		// Return the maximum of two sizes
		root.liss = Math.max(liss_incl, liss_excl);

		return root.liss;
	}

}
