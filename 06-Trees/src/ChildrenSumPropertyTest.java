public class ChildrenSumPropertyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean childrenSumProperty(BNode root) {
		// base case
		if (root == null)
			return true;
		if (root.left == null && root.right == null)
			return true;

		// recursive calls
		if (root.left == null) {
			if (root.data == root.right.data && childrenSumProperty(root.right))
				return true;
		}
		if (root.right == null) {
			if (root.data == root.left.data && childrenSumProperty(root.left))
				return true;
		}
		return (root.data == root.right.data + root.left.data)
				&& childrenSumProperty(root.right)
				&& childrenSumProperty(root.left);
	}

}