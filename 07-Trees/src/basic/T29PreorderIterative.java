package basic;

import advanced.*;

import java.util.Deque;
import java.util.LinkedList;

public class T29PreorderIterative {

	public static void main(String[] args) {
		advanced.BNode root = new advanced.BNode(5);
		root.left = new advanced.BNode(3);
		root.right = new advanced.BNode(9);
		root.left.left = new advanced.BNode(1);
		root.left.right = new advanced.BNode(4);
		root.right.left = new advanced.BNode(6);
		iterativePreorder(root);
	}

	// An iterative process to print preorder traversal of Binary tree
	public static void iterativePreorder(advanced.BNode root) {
		if (root == null)
			return;

		// Create an empty stack and push root to it
		Deque<advanced.BNode> nodeStack = new LinkedList<advanced.BNode>();
		nodeStack.push(root);

		/*
		 * Pop all items one by one. Do for every popped item
		 * a) print it b) push right child c) push left child
		 */
		while (!nodeStack.isEmpty()) {
			// Pop the top item from stack and print it
			advanced.BNode node = nodeStack.pop();
			System.out.printf("%d ", node.data);

			// Push right and left children of the popped node to stack
			if (node.right != null)
				nodeStack.push(node.right);
			if (node.left != null)
				nodeStack.push(node.left);
		}
	}

}
