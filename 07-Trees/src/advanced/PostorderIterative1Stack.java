package advanced;

import java.util.Deque;
import java.util.LinkedList;

public class PostorderIterative1Stack {

	public static void main(String[] args) {
		BNode root = new BNode(5);
		root.left = new BNode(3);
		root.right = new BNode(9);
		root.left.left = new BNode(1);
		root.left.right = new BNode(4);
		root.right.left = new BNode(6);
		postOrderIterative(root);
	}

	// An iterative function to do postorder traversal
	public static void postOrderIterative(BNode root) {
		if (root == null)
			return;

		Deque<BNode> stack = new LinkedList<BNode>();

		do {
			// Move to leftmost node
			while (root != null) {
				// Push root's right child and then root to stack.
				if (root.right != null)
					stack.push(root.right);
				stack.push(root);
				root = root.left;
			}

			// Pop an item from stack and set it as root
			root = stack.pop();

			// item has a right child and the right child is not
			// processed yet, then process right child before root
			if (root.right != null && stack.peek() == root.right) {
				stack.pop(); // remove right child from stack
				stack.push(root); // push root back to stack
				root = root.right; // change root to process right child
			} else // Else print root's data and set root as NULL
			{
				System.out.printf("%d ", root.data);
				root = null;
			}
		} while (!stack.isEmpty());
	}

}
