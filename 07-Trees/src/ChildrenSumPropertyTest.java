public class ChildrenSumPropertyTest {

	public static void main(String[] args) {
		BNode root = new BNode(10);
		
		root.left = new BNode(8);
		root.right = new BNode(2);
		
		root.left.left = new BNode(3);
		root.left.right = new BNode(5);
		root.right.left = new BNode(2);
		System.out.println(childrenSumProperty(root));
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
