package basic;


public class T15HeightBalanceTest {

	public static void main(String[] args) {
		BNode root = new BNode(10);
		root.left = new BNode(8);
		root.right = new BNode(3);

		root.left.left = new BNode(3);
		root.left.right = new BNode(5);
		root.right.left = new BNode(2);
		//root.right.left.right = new advanced.BNode(4);
		//root.right.left.right.right = new advanced.BNode(7);
		System.out.println(isBalanced(root));
	}

	/* Returns true if binary tree with root as root is height-balanced */
	public static boolean isBalanced(BNode root) {
		int lh, rh;
		
		if (root == null)
			return true;

		lh = height(root.left);
		rh = height(root.right);

		if (Math.abs(lh - rh) <= 1 
				&& isBalanced(root.left)
				&& isBalanced(root.right))
			return true;

		return false;
	}

	/* Function to calculate height of a tree */
	public static int height(BNode root) {

		if (root == null) {
			return 0;
		}
		int lheight = height(root.left);
		int rheight = height(root.right);
		if (lheight > rheight) {
			return lheight + 1;
		} else
			return rheight + 1;
	}
}
