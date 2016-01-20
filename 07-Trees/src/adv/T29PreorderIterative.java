package adv;


import java.util.Deque;
import java.util.LinkedList;

public class T29PreorderIterative {

	public static void main(String[] args) {
		BNode root = new BNode(5);
		root.left = new BNode(3);
		root.right = new BNode(9);
		root.left.left = new BNode(1);
		root.left.right = new BNode(4);
		root.right.left = new BNode(6);
		iterativePreorder(root);
	}

	// An iterative process to print preorder traversal of Binary tree
	public static void iterativePreorder(BNode root) {
		if (root == null)
			return;

		// Create an empty stack and push root to it
		Deque<BNode> nodeStack = new LinkedList<BNode>();
		nodeStack.push(root);

		/*
		 * Pop all items one by one. Do for every popped item
		 * a) print it b) push right child c) push left child
		 */
		while (!nodeStack.isEmpty()) {
			// Pop the top item from stack and print it
			BNode node = nodeStack.pop();
			System.out.printf("%d ", node.data);

			// Push right and left children of the popped node to stack
			if (node.right != null)
				nodeStack.push(node.right);
			if (node.left != null)
				nodeStack.push(node.left);
		}
	}

}
