public class BSTSimpleOperations {

	public static void main(String[] args) {
		BNode root = new BNode(5);
		root.left = new BNode(3);
		root.right = new BNode(9);
		root.left.left = new BNode(1);
		root.left.right = new BNode(4);
		root.right.left = new BNode(6);

		// System.out.println("The tree is BST: "+ isBST(root));
		// System.out.println("The minimum value in BST is: "+ minvalue(root));
		// System.out.println("The maximum value in BST is: "+ maxvalue(root));
		//System.out.println("The BST is: ");
		//printInorder((root));
		//System.out.println("The sum is 9: "+hasPathSum(root, 9));
		//doubleTree(root);
		System.out.println("The BST is: ");
		printInorder((root));
		System.out.println("The node is found in BST:"+lookup(root, 4));
		root = insert(root, 7);
		System.out.println("The BST is: ");
		printInorder((root));
	}

	/*
	 * Returns true if the given tree is a binary search tree (efficient
	 * version).
	 */
	public static boolean isBST(BNode node) {
		return (isBSTUtil(node, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

	/*
	 * Returns true if the given tree is a BST and its values are >= min and <=
	 * max.
	 */
	public static boolean isBSTUtil(BNode node, int min, int max) {

		/* an empty tree is BST */
		if (node == null)
			return true;

		/* false if this node violates the min/max constraint */
		if (node.data < min || node.data > max)
			return false;

		/*
		 * otherwise check the subtrees recursively, tightening the min or max
		 * constraint
		 */
		return isBSTUtil(node.left, min, node.data)
				&& isBSTUtil(node.right, node.data + 1, max); // Allow only
																// distinct
																// values
	}

	/*
	 * Given a non-empty binary search tree, return the minimum data value found
	 * in that tree. Note that the entire tree does not need to be searched.
	 */
	public static int minvalue(BNode node) {
		BNode current = node;
		while (current.left != null) {
			current = current.left;
		}
		return current.data;
	}

	/*
	 * Given a non-empty binary search tree, return the maximum data value found
	 * in that tree. Note that the entire tree does not need to be searched.
	 */
	public static int maxvalue(BNode node) {
		BNode current = node;
		while (current.right != null) {
			current = current.right;
		}
		return current.data;
	}

	/*
	 * Given a binary search tree, print out its data elements in increasing
	 * sorted order.
	 */
	public static void printInorder(BNode node) {
		if (node == null)
			return;

		printInorder(node.left);
		System.out.format("%d ", node.data);
		printInorder(node.right);
	}

	/*
	 * Given a tree and a sum, return true if there is a path from the root down
	 * to a leaf, such that adding up all the values along the path equals the
	 * given sum. Strategy: subtract the node value from the sum when recurring
	 * down, and check to see if the sum is 0 when you run out of tree.
	 */
	public static boolean hasPathSum(BNode node, int sum) {
		if (node == null) {
			return (sum == 0);
		} else {
			// otherwise check both subtrees
			int subSum = sum - node.data;
			return (hasPathSum(node.left, subSum) || hasPathSum(node.right,
					subSum));
		}

	}
	/* 
	 For each node in a binary search tree, 
	 create a new duplicate node, and insert 
	 the duplicate as the left child of the original node. 
	 The resulting tree should still be a binary search tree.
	 So the tree... 
	    2 
	   / \ 
	  1   3

	 Is changed to... 
	       2 
	      / \ 
	     2   3 
	    /   / 
	   1   3 
	  / 
	 1

	*/ 
	public static void doubleTree(BNode node) {
		BNode oldLeft;

		if (node == null)
			return;

		// do the subtrees
		doubleTree(node.left);
		doubleTree(node.right);

		// duplicate this node to its left
		oldLeft = node.left;
		node.left = new BNode(node.data);
		node.left.left = oldLeft;
	}
	
	/* 
	 Given a binary tree, return true if a node 
	 with the target data is found in the tree. Recurs 
	 down the tree, chooses the left or right 
	 branch by comparing the target to each node. 
	*/ 
	public static boolean lookup(BNode node, int target) { 
	  // 1. Base case == empty tree 
	  // in that case, the target is not found so return false 
	  if (node == null) { 
	    return false; 
	  } 
	  else { 
	    // 2. see if found here 
	    if (target == node.data) return true; 
	    else { 
	      // 3. otherwise recur down the correct subtree 
	      if (target < node.data) 
	    	  return(lookup(node.left, target)); 
	      else 
	    	  return(lookup(node.right, target)); 
	    } 
	  } 
	} 
	
	/* 
	 Give a binary search tree and a number, inserts a new node 
	 with the given number in the correct place in the tree. 
	 Returns the new root pointer which the caller should 
	 then use. 
	*/ 
	public static BNode insert(BNode node, int data) { 
	  // 1. If the tree is empty, return a new, single node 
	  if (node == null) { 
	    return(new BNode(data)); 
	  } 
	  else { 
	    // 2. Otherwise, recur down the tree 
	    if (data <= node.data) 
	    	node.left = insert(node.left, data); 
	    else 
	    	node.right = insert(node.right, data);

	    return node; // return the (unchanged) node pointer 
	  } 
	} 
	
	/*private BNode delete(BNode x, int key) {
		if (x == null)
			return null;
		int cmp = key-x.data;
		if (cmp < 0)
			x.left = delete(x.left, key);
		else if (cmp > 0)
			x.right = delete(x.right, key);
		else {
			if (x.right == null)
				return x.left;
			if (x.left == null)
				return x.right;
			BNode t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	*/

}