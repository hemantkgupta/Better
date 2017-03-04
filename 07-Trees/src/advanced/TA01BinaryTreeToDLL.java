package advanced;

public class TA01BinaryTreeToDLL {

	public static void main(String[] args) {
		BNode root = new BNode(20);

		root.left = new BNode(8);
		root.right = new BNode(22);

		root.left.left = new BNode(4);
		root.left.right = new BNode(12);

		root.left.right.left = new BNode(10);
		root.left.right.right = new BNode(14);

		root = binaryTreeToDLL(root);
		System.out.println(root);
		printList(root);

	}

	// converts binary tree to dll
	public static BNode binaryTreeToDLL(BNode root) {
			// Base case
			if (root == null)
				return root;

			root = binaryTreeToDllUtil(root);

			// root is root node of the converted DLL.
			while (root.left != null)
				root = root.left;

			return root;
	}
	
	public static BNode binaryTreeToDllUtil(BNode root) {
		// Base case
		if (root == null)
			return root;

		// Convert the left subtree and link to root
		if (root.left != null) {
			// Convert the left subtree
			BNode left = binaryTreeToDllUtil(root.left);

			// Find inorder predecessor. After this loop, left
			// will point to the inorder predecessor
			/*for (; left.right != null; left = left.right)
				;*/
			while(left.right != null)
				left = left.right;
			// Make root as next of the predecessor
			left.right = root;

			// Make predecssor as previous of root
			root.left = left;
		}

		// Convert the right subtree and link to root
		if (root.right != null) {
			// Convert the right subtree
			BNode right = binaryTreeToDllUtil(root.right);

			// Find inorder successor. After this loop, right
			// will point to the inorder successor
			/*for (; right.left != null; right = right.left)
				;*/
			while(right.left != null)
				right = right.left;

			// Make root as previous of successor
			right.left = root;

			// Make successor as next of root
			root.right = right;
		}

		return root;
	}

	

	public static void printList(BNode node) {
		while (node != null) {
			System.out.printf("%d ", node.data);
			node = node.right;
		}
	}

}
