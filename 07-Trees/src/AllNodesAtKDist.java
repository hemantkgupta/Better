public class AllNodesAtKDist {

	public static void main(String[] args) {
		BNode root = new BNode(20);
		root.left = new BNode(8);
		root.right = new BNode(22);
		root.left.left = new BNode(4);
		root.left.right = new BNode(12);
		root.left.right.left = new BNode(10);
		root.left.right.right = new BNode(14);
		printkdistanceNode(root, root.left.right, 2);
	}

	// Prints all nodes at distance k from a given target node.
	public static int printkdistanceNode(BNode root, BNode target, int k) {
		// Base Case 1: If tree is empty, return -1
		if (root == null)
			return -1;

		// If target is same as root. Use the downward function
		if (root == target) {
			printkdistanceNodeDown(root, k);
			return 0;
		}

		// Recur for left subtree
		int dl = printkdistanceNode(root.left, target, k);

		// Check if target node was found in left subtree
		if (dl != -1) {
			// If root is at distance k from target, print root
			// Note that dl is Distance of root's left child from target
			if (dl + 1 == k)
				System.out.println(root.data);

			// Else go to right subtree and print all k-dl-2 distant nodes
			// Note that the right child is 2 edges away from left child
			else
				printkdistanceNodeDown(root.right, k - dl - 2);

			// Add 1 to the distance and return value for parent calls
			return 1 + dl;
		}

		// MIRROR OF ABOVE CODE FOR RIGHT SUBTREE
		// Note that we reach here only when node was not found in left subtree
		int dr = printkdistanceNode(root.right, target, k);
		if (dr != -1) {
			if (dr + 1 == k)
				System.out.println(root.data);
			else
				printkdistanceNodeDown(root.left, k - dr - 2);
			return 1 + dr;
		}

		// If target was neither present in left nor in right subtree
		return -1;
	}

	// print all the nodes at distance k from root
	public static void printkdistanceNodeDown(BNode root, int k) {
		if (root == null || k < 0)
			return;
		if (k == 0) {
			System.out.println(root.data);
			return;
		}
		printkdistanceNodeDown(root.left, k - 1);
		printkdistanceNodeDown(root.right, k - 1);
	}

}
