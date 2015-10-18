package advanced;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedListToCompleteBTree {

	public static void main(String[] args) {
		Node root = new Node(10);
		root.next = new Node(12);
		root.next.next = new Node(15);
		root.next.next.next = new Node(25);
		root.next.next.next.next = new Node(30);
		root.next.next.next.next.next = new Node(36);
		BNode tree = convertList2Binary(root);
		printInorder(tree);
	}

	// converts a given linked list to complete binary
	public static BNode convertList2Binary(Node head) {
		// queue to store the parent nodes
		Queue<BNode> q = new LinkedList<BNode>();

		if (head == null) {
			return null;
		}
		// The first node is always the root node, and add it to the queue
		BNode root = new BNode(head.data);
		q.offer(root);

		head = head.next;

		while (head != null) {
			// Take the parent node from the q
			BNode parent = q.poll();

			BNode leftChild = null, rightChild = null;
			leftChild = new BNode(head.data);
			q.offer(leftChild);
			head = head.next;
			if (head != null) {
				rightChild = new BNode(head.data);
				q.offer(rightChild);
				head = head.next;
			}

			parent.left = leftChild;
			parent.right = rightChild;
		}
		return root;
	}

	public static void printInorder(BNode node) {
		if (node == null)
			return;

		printInorder(node.left);
		System.out.format("%d ", node.data);
		printInorder(node.right);
	}

}
