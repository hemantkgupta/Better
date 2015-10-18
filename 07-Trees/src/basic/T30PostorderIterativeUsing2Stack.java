package basic;

import advanced.*;

import java.util.Deque;
import java.util.LinkedList;

public class T30PostorderIterativeUsing2Stack {

	public static void main(String[] args) {
		advanced.BNode root = new advanced.BNode(5);
		root.left = new advanced.BNode(3);
		root.right = new advanced.BNode(9);
		root.left.left = new advanced.BNode(1);
		root.left.right = new advanced.BNode(4);
		root.right.left = new advanced.BNode(6);
		postOrderIterative(root);

	}

	// An iterative function to do post order traversal of a given binary tree
	public static void postOrderIterative(advanced.BNode root) {
		// Create two stacks
		Deque<advanced.BNode> s1 = new LinkedList<advanced.BNode>();
		Deque<advanced.BNode> s2 = new LinkedList<advanced.BNode>();

		// push root to first stack
		s1.push(root);
		advanced.BNode node;

		// Run while first stack is not empty
		while (!s1.isEmpty()) {
			// Pop an item from s1 and push it to s2
			node = s1.pop();
			s2.push(node);

			// Push left and right children of removed item to s1
			if (node.left != null)
				s1.push(node.left);
			if (node.right != null)
				s1.push(node.right);
		}

		// Print all elements of second stack
		while (!s2.isEmpty()) {
			node = s2.pop();
			System.out.printf("%d ", node.data);
		}
	}

}
