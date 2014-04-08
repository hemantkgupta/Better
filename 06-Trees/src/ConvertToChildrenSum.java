public class ConvertToChildrenSum {

	public static void main(String[] args) {
		BNode root = new BNode(10);

		root.left = new BNode(8);
		root.right = new BNode(3);

		root.left.left = new BNode(3);
		root.left.right = new BNode(5);
		root.right.left = new BNode(2);
		convertTree(root);
		System.out.println(new ChildrenSumPropertyTest()
				.childrenSumProperty(root));
	}

	public static void convertTree(BNode BNode) {
		int left_data = 0, right_data = 0, diff;

		if (BNode == null || (BNode.left == null && BNode.right == null)){
			return;
		} else {
			
			convertTree(BNode.left);
			convertTree(BNode.right);

			if (BNode.left != null)
				left_data = BNode.left.data;

			if (BNode.right != null)
				right_data = BNode.right.data;

			diff = left_data + right_data - BNode.data;
			if (diff > 0)
				BNode.data = BNode.data + diff;
			if (diff < 0)
				increment(BNode, -diff); 
		}
	}

	/* This function is used to increment subtree by diff */
	public static void increment(BNode BNode, int diff) {
		if (BNode.left != null) {
			BNode.left.data = BNode.left.data + diff;
			increment(BNode.left, diff);
		} else if (BNode.right != null) {
			BNode.right.data = BNode.right.data + diff;
			increment(BNode.right, diff);
		}
	}

}
