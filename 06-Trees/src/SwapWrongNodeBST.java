public class SwapWrongNodeBST {
	
	static BNode first = null;  
	static BNode  middle = null;
	static BNode last = null;
	static BNode prev = null; 
	
	public static void main(String[] args) {
		BNode root = new BNode(6);
		root.left = new BNode(10);
		root.right = new BNode(2);
		root.left.left = new BNode(1);
		root.left.right = new BNode(3);
		root.right.right = new BNode(12);
		root.right.left = new BNode(7);
		printInorder(root);
		correctBST(root);
		System.out.println();
		printInorder(root);
	}

	// A function to fix a given BST where two nodes are swapped. This
	// function uses correctBSTUtil() to find out two nodes and swaps the
	// nodes to fix the BST
	public static void correctBST(BNode root) {
		
		correctBSTUtil(root);
		if (first != null && last != null) {
			System.out.println("reached to swap");
			int t = first.data;
			first.data = last.data;
			last.data = t;
			
		} else if (first != null && middle != null) { 
			int t = first.data;
			first.data = middle.data;
			middle.data = t;
		}

	}

	public static void correctBSTUtil(BNode root) {
		if (root != null) {

			correctBSTUtil(root.left);

			// If this node is smaller than the previous node, it's violating
			// the BST rule.
			if (prev != null && root.data < prev.data) {
				System.out.println("reached");
				if (first == null) {
					first = prev;
					middle = root;
				} else {
					last = root;
				}
			}

			// Mark this node as previous
			prev = root;

			// Recur for the right subtree
			correctBSTUtil(root.right);
		}
	}

	public static void printInorder(BNode node) {
		if (node == null)
			return;

		printInorder(node.left);
		System.out.format("%d ", node.data);
		printInorder(node.right);
	}

	public static void swap(int a, int b) {
		int t = a;
		a = b;
		b = t;
	}

}
