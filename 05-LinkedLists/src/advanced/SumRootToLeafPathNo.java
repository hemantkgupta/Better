package advanced;

public class SumRootToLeafPathNo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Returns sum of all root to leaf paths.
	public static int treePathsSum(BNode root) {
		return treePathsSumUtil(root, 0);
	}

	public static int treePathsSumUtil(BNode root, int val) {
		// Base case
		if (root == null)
			return 0;

		// Update val
		val = (val * 10 + root.data);

		// if current node is leaf, return the current value of val
		if (root.left == null && root.right == null)
			return val;

		// recur sum of values for left and right subtree
		return treePathsSumUtil(root.left, val)
				+ treePathsSumUtil(root.right, val);
	}

}
