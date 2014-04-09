public class LevelOfNode {

	public static void main(String[] args) {
		BNode root = new BNode(20);
		root.left = new BNode(8);
		root.right = new BNode(22);
		root.left.left = new BNode(4);
		root.left.right = new BNode(12);
		root.left.right.left = new BNode(10);
		root.left.right.right = new BNode(14);
		System.out.println(levelOfNode(root, root.left.right.left, 1));
	}

	public static int levelOfNode(BNode root, BNode node, int level) {

		if (root == null)
			return 0;
		if (root.data == node.data)
			return level;

		int leftLevel = levelOfNode(root.left, node, level + 1);
		if (leftLevel != 0)
			return leftLevel;
		return levelOfNode(root.right, node, level + 1);

	}

}
