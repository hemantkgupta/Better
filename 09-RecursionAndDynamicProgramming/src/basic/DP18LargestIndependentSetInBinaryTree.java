package basic;

public class DP18LargestIndependentSetInBinaryTree {

	public static void main(String[] args) {
		BNode root = new BNode(10);
		root.left = new BNode(20);
		root.right = new BNode(30);
		root.left.left = new BNode(40);
		root.left.right = new BNode(50);
		root.left.right.left = new BNode(70);
		root.left.right.right = new BNode(80);
		root.right.right = new BNode(60);
		System.out.println(largestIndependentSetRecursive(root));
		//System.out.println(LISSDP(root));

	}

	// largest independent set in a binary tree

	/**
	 * Find the size of the Largest Independent Set(LIS) in a binary tree.
	 * A subset of all tree nodes is an independent set
	 * 	if there is no edge between any two nodes of the subset.
	 * @param root
	 * @return
	 */
	public static int largestIndependentSetRecursive(BNode root) {
		if (root == null)
			return 0;

		// Calculate size excluding the current node - so calculate from children
		int excl = largestIndependentSetRecursive(root.left) + largestIndependentSetRecursive(root.right);

		// Calculate size including the current node - so calculate from grand-children and add 1
		int incl = 1;

		if (root.left != null)
			incl += largestIndependentSetRecursive(root.left.left) + largestIndependentSetRecursive(root.left.right);
		if (root.right != null)
			incl += largestIndependentSetRecursive(root.right.left) + largestIndependentSetRecursive(root.right.right);

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
		int liss_excl = largestIndependentSetRecursive(root.left) + largestIndependentSetRecursive(root.right);

		// Calculate size including the current node
		int liss_incl = 1;
		if (root.left != null)
			liss_incl += largestIndependentSetRecursive(root.left.left) + largestIndependentSetRecursive(root.left.right);
		if (root.right != null)
			liss_incl += largestIndependentSetRecursive(root.right.left) + largestIndependentSetRecursive(root.right.right);

		// Return the maximum of two sizes
		root.liss = Math.max(liss_incl, liss_excl);

		return root.liss;
	}

}
