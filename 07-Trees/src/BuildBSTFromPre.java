public class BuildBSTFromPre {

	public static void main(String[] args) {
		int pre[] = { 10, 5, 1, 7, 40, 50 };
		BNode root = constructTree(pre);
		printInorder(root);

	}

	public static int preIndex;
	
	// function to construct BST from given preorder traversal.
	public static BNode constructTree(int pre[]) {
			int size = pre.length;
			return constructTreeUtil(pre, 0, size - 1, size);
	}

	// Build BST from Preorder
	public static BNode constructTreeUtil(int pre[], int low, int high, int size) {
		if (preIndex >= size || low > high)
			return null;

		// The first node in preorder traversal is root
		BNode root = new BNode(pre[preIndex]);
		preIndex = preIndex + 1;

		if (low == high)
			return root;

		// Search for the first element greater than root
		int i;
		for (i = low; i <= high; ++i)
			if (pre[i] > root.data)
				break;

		//  divide array by found index
		root.left = constructTreeUtil(pre, preIndex, i - 1, size);
		root.right = constructTreeUtil(pre, i, high, size);

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
