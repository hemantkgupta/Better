import java.util.Deque;
import java.util.LinkedList;

public class PrintAncestor {

	public static void main(String[] args) {
		BNode root = new BNode(20);
		root.left = new BNode(8);
		root.right = new BNode(22);

		root.left.left = new BNode(4);
		root.left.right = new BNode(12);
		root.left.right.left = new BNode(10);
		root.left.right.right = new BNode(14);
		// printAncestorsRecr(root, 12);
		printAncestorsIter(root, 12);
	}

	public static boolean printAncestorsRecr(BNode root, int target) {

		if (root == null)
			return false;

		if (root.data == target)
			return true;

		if (printAncestorsRecr(root.left, target)
				|| printAncestorsRecr(root.right, target)) {
			System.out.print(root.data + " ");
			return true;
		}

		return false;
	}

	// Iterative Function to print all ancestors of a given key
	public static void printAncestorsIter(BNode root, int key) {
		if (root == null)
			return;
		Deque<BNode> stack = new LinkedList<BNode>();

		// Traverse postorder till we find the key
		while (true) {
			// Traverse the left side. push the nodes
			while (root != null && root.data != key) {
				stack.push(root);
				root = root.left;
			}

			// if node found
			if (root != null && root.data == key)
				break;

			// Check if right sub-tree doesn't exists pop
			if (stack.peek().right == null) {
				root = stack.pop();

				// If the popped node is right child of top, then remove the top
				// as well. Left child of the top must have processed before.
				while (!stack.isEmpty() && stack.peek().right == root)
					root = stack.pop();
			}

			// if stack is not empty then simply set the root as right child
			// of top and start traversing right sub-tree.
			root = stack.isEmpty() ? null : stack.peek().right;
		}

		// If stack is not empty, print contents of stack
		// Here assumption is that the key is there in tree
		while (!stack.isEmpty())
			System.out.printf("%d ", stack.pop().data);
	}

}
