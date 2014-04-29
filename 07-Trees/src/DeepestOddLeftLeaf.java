public class DeepestOddLeftLeaf {

	public static void main(String[] args) {
		BNode root = new BNode(50);

		root.left = new BNode(30);
		root.right = new BNode(70);

		root.left.left = new BNode(20);
		root.left.right = new BNode(40);

		root.right.left = new BNode(60);
		root.right.left.right = new BNode(80);
		System.out.println(depthOfOddLeafUtil(root, 1));

	}

	// A recursive function to find depth of the deepest odd level leaf
	public static int depthOfOddLeafUtil(BNode root, int level) {
		if (root == null)
			return 0;

		if (root.left == null && root.right == null && level % 2 == 1)
			return level;

		return Math.max(depthOfOddLeafUtil(root.left, level + 1),
				depthOfOddLeafUtil(root.right, level + 1));
	}

}
