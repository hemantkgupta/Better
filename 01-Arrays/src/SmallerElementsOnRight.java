import java.util.Arrays;

public class SmallerElementsOnRight {

	private static int[] countSmaller;

	public static void main(String[] args) {
		int[] arr = {10, 6, 15, 20, 30, 5, 7};
		constructLowerArray(arr);
		System.out.println(Arrays.toString(countSmaller));
		
	}

	// The following function updates the countSmaller array to contain count of
	// smaller elements on right side.
	public static void constructLowerArray(int[] arr) {
		int i, j;
		ABNode root = null;
		int n = arr.length;
		countSmaller = new int[n];
		/*
		 * // initialize all the counts in countSmaller array as 0 for (i = 0; i
		 * < n; i++) countSmaller[i] = 0;
		 */

		// Starting from rightmost element, insert all elements one by one in
		// an AVL tree and get the count of smaller elements
		for (i = n - 1; i >= 0; i--) {
			root = insert(root, arr[i], i);
		}
		printInorder(root);
	}

	// Inserts a new key to the tree rooted with node. Also, updates count
	// to contain count of smaller elements for the new key
	public static ABNode insert(ABNode node, int key, int countIndex) {
		/* 1. Perform the normal BST rotation */
		if (node == null)
			return (new ABNode(key));

		if (key < node.key)
			node.left = insert(node.left, key, countIndex);
		else {
			node.right = insert(node.right, key, countIndex);
			countSmaller[countIndex] = countSmaller[countIndex]
					+ size(node.left) + 1;
		}
		/* 2. Update height of this ancestor node */
		node.height = Math.max(height(node.left), height(node.right)) + 1;
		node.size = size(node.left) + size(node.right) + 1;
		/*
		 * 3. Get the balance factor of this ancestor node to check whether this
		 * node became unbalanced
		 */
		int balance = getBalance(node);

		// If this node becomes unbalanced, then there are 4 cases

		// Left Left Case
		if (balance > 1 && key < node.left.key)
			return rightRotate(node);

		// Right Right Case
		if (balance < -1 && key > node.right.key)
			return leftRotate(node);

		// Left Right Case
		if (balance > 1 && key > node.left.key) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		// Right Left Case
		if (balance < -1 && key < node.right.key) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}

		/* return the (unchanged) node pointer */
		return node;
	}

	// A utility function to right rotate subtree rooted with y
	// See the diagram given above.
	public static ABNode rightRotate(ABNode y) {
		ABNode x = y.left;
		ABNode T2 = x.right;

		// Perform rotation
		x.right = y;
		y.left = T2;

		// Update heights
		y.height = Math.max(height(y.left), height(y.right)) + 1;
		x.height = Math.max(height(x.left), height(x.right)) + 1;
		
		 // Update sizes
	    y.size = size(y.left) + size(y.right) + 1;
	    x.size = size(x.left) + size(x.right) + 1;

		// Return new root
		return x;
	}

	// A utility function to left rotate subtree rooted with x
	// See the diagram given above.
	public static ABNode leftRotate(ABNode x) {
		ABNode y = x.right;
		ABNode T2 = y.left;

		// Perform rotation
		y.left = x;
		x.right = T2;

		// Update heights
		x.height = Math.max(height(x.left), height(x.right)) + 1;
		y.height = Math.max(height(y.left), height(y.right)) + 1;
		
		// Update sizes
	    x.size = size(x.left) + size(x.right) + 1;
	    y.size = size(y.left) + size(y.right) + 1;

		// Return new root
		return y;
	}

	// Get Balance factor of node N
	public static int getBalance(ABNode N) {
		if (N == null)
			return 0;
		return height(N.left) - height(N.right);
	}

	// A utility function to get height of the tree
	public static int height(ABNode N) {
		if (N == null)
			return 0;
		return N.height;
	}

	// A utility function to size of the tree of rooted with N
	public static int size(ABNode N) {
		if (N == null)
			return 0;
		return N.size;
	}

	public static void printInorder(ABNode node) {
		if (node == null)
			return;

		printInorder(node.left);
		System.out.format(" { %d and %d } ", node.key, node.size);
		printInorder(node.right);
	}

}