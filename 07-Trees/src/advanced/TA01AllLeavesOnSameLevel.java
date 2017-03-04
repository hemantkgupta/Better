package advanced;

public class TA01AllLeavesOnSameLevel {

	public static void main(String[] args) {
		BNode root = new BNode(50);

		root.left = new BNode(30);
		root.right = new BNode(70);

		root.left.left = new BNode(20);
		root.left.right = new BNode(40);

		root.right.left = new BNode(60);
		root.right.right = new BNode(80);
		System.out.println(checkAllLeavesOnSameLevel(root, 0));

	}

	public static int leafLevel;

	/* Recursive function which checks whether all leaves are at same level */
	public static boolean checkAllLeavesOnSameLevel(BNode root, int level) {
		if (root == null)
			return true;

		// If a leaf node is encountered
		if (root.left == null && root.right == null) {
			// Check if leaf level is not set
			if (leafLevel == 0) {
				leafLevel = level;
				return true;
			}

			return (level == leafLevel);
		}
		return checkAllLeavesOnSameLevel(root.left, level + 1)
				&& checkAllLeavesOnSameLevel(root.right, level + 1);
	}

}
