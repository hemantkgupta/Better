package advanced;

import java.util.Deque;
import java.util.LinkedList;

public class MergeTwoBST2 {

	public static void main(String[] args) {
		BNode root1 = new BNode(100);
		root1.left = new BNode(50);
		root1.right = new BNode(300);
		root1.left.left = new BNode(20);
		root1.left.right = new BNode(70);

		BNode root2 = new BNode(80);
		root2.left = new BNode(40);
		root2.right = new BNode(120);
		merge(root1, root2);
		// printInorder(root);
	}

	// The function to print data of two BSTs in sorted order
	public static void merge(BNode root1, BNode root2) {
		// s1 is stack to hold nodes of first BST
		Deque<BNode> s1 = new LinkedList<BNode>();

		// Current node of first BST
		BNode current1 = root1;

		// s2 is stack to hold nodes of second BST
		Deque<BNode> s2 = new LinkedList<BNode>();

		// Current node of second BST
		BNode current2 = root2;

		// If first BST is empty, then output is inorder
		// traversal of second BST
		if (root1 == null) {
			printInorder(root2);
			return;
		}
		// If second BST is empty, then output is inorder
		// traversal of first BST
		if (root2 == null) {
			printInorder(root1);
			return;
		}

		// Run the loop while there are nodes not yet printed.
		// The nodes may be in stack(explored, but not printed)
		// or may be not yet explored
		while (current1 != null || !s1.isEmpty() || current2 != null
				|| !s2.isEmpty()) {
			// Following steps follow iterative Inorder Traversal
			if (current1 != null || current2 != null) {
				// Reach the leftmost node of both BSTs and push ancestors of
				// leftmost nodes to stack s1 and s2 respectively
				if (current1 != null) {
					s1.push(current1);
					current1 = current1.left;
				}
				if (current2 != null) {
					s2.push(current2);
					current2 = current2.left;
				}

			} else {
				// If we reach a null node and either of the stacks is empty,
				// then one tree is exhausted, ptint the other tree
				if (s1.isEmpty()) {
					while (!s2.isEmpty()) {
						current2 = s2.pop();
						current2.left = null;
						printInorder(current2);
					}
					return;
				}
				if (s2.isEmpty()) {
					while (!s1.isEmpty()) {
						current1 = s1.pop();
						current1.left = null;
						printInorder(current1);
					}
					return;
				}

				// Pop an element from both stacks and compare the
				// popped elements
				current1 = s1.pop();
				current2 = s2.pop();

				// If element of first tree is smaller, then print it
				// and push the right subtree. If the element is larger,
				// then we push it back to the corresponding stack.
				if (current1.data < current2.data) {
					System.out.printf("%d ", current1.data);
					current1 = current1.right;
					s2.push(current2);
					current2 = null;
				} else {
					System.out.printf("%d ", current2.data);
					current2 = current2.right;
					s1.push(current1);
					current1 = null;
				}
			}
		}
	}

	public static void printInorder(BNode node) {
		if (node == null)
			return;

		printInorder(node.left);
		System.out.format("%d ", node.data);
		printInorder(node.right);
	}

}
