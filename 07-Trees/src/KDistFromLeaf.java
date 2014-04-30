public class KDistFromLeaf {

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

		kDistantFromLeafUtil(root, new int[11], new boolean[11], 0, 2);

	}

	/*
	 * This function prints all nodes that are distance k from a leaf node
	 * path[] -. Store ancestors of a node visited[] -. Stores true if a node is
	 * printed as output.
	 */
	public static void kDistantFromLeafUtil(BNode node, int path[],
			boolean visited[], int pathLen, int k) {

		if (node == null)
			return;

		/* append this Node to the path array */
		path[pathLen] = node.data;
		visited[pathLen] = false;
		pathLen++;

		// it's a leaf, so print the ancestor at distance k if not done
		if (node.left == null && node.right == null && pathLen - k - 1 >= 0
				&& visited[pathLen - k - 1] == false) {
			System.out.println(path[pathLen - k - 1] + " ");
			visited[pathLen - k - 1] = true;
			return;
		}
		kDistantFromLeafUtil(node.left, path, visited, pathLen, k);
		kDistantFromLeafUtil(node.right, path, visited, pathLen, k);
	}

}
