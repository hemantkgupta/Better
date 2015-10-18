package advanced;


import basic.*;

public class T015ConvertToChildrenSumProperty {

	public static void main(String[] args) {
		basic.BNode root = new basic.BNode(10);

		root.left = new basic.BNode(8);
		root.right = new basic.BNode(3);

		root.left.left = new basic.BNode(3);
		root.left.right = new basic.BNode(5);
		root.right.left = new basic.BNode(2);
		convertTree(root);
		System.out.println(new T13ChildrenSumPropertyTest()
				.childrenSumProperty(root));
	}

	public static void convertTree(basic.BNode BNode) {
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
	public static void increment(basic.BNode BNode, int diff) {
		if (BNode.left != null) {
			BNode.left.data = BNode.left.data + diff;
			increment(BNode.left, diff);
		} else if (BNode.right != null) {
			BNode.right.data = BNode.right.data + diff;
			increment(BNode.right, diff);
		}
	}

}
