
public class BSTInorderSuccessor {

	public static void main(String[] args) {

	}
	
	public static BNode inOrderSuccessor(BNode root, BNode n) {
		
		// if right subtree is not null
		if (n.right != null)
			return minValue(n.right);

		BNode succ = null;

		// Start from root and search for successor down the tree
		while (root != null) {
			if (n.data < root.data) {
				succ = root;
				root = root.left;
			} else if (n.data > root.data)
				root = root.right;
			else
				break;
		}

		return succ;
	}
	
	public static BNode minValue(BNode BNode) {
		BNode current = BNode;

		/* loop down to find the leftmost leaf */
		while (current.left != null) {
			current = current.left;
		}
		return current;
	}

}
