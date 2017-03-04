package basic;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class T31BReverseLevelOrderUsingQ {

	public static void main(String[] args) {
		BNode root = new BNode(10);
		root.left = new BNode(9);
		root.right = new BNode(2);
		root.left.left = new BNode(7);
		root.left.right = new BNode(6);
		root.left.left.left = new BNode(5);
		root.left.right.right = new BNode(4);
		reverseLevelOrder(root);

	}

	/* Given a binary tree, print its nodes in reverse level order */
	public static void reverseLevelOrder(BNode root) {
		Deque<BNode> S = new LinkedList<BNode>();
		Queue<BNode> Q = new LinkedList<BNode>();
		Q.offer(root);

		// 1) Instead of printing a node, we push the node to stack
		// 2) Right subtree is visited before left subtree
		while (!Q.isEmpty()) {
			
			/* Dequeue node and make it root */
			root = Q.poll();
			S.push(root);

			/* Enqueue right child */
			if (root.right != null)
				Q.offer(root.right); 

			/* Enqueue left child */
			if (root.left != null)
				Q.offer(root.left);
		}

		// Now pop all items from stack one by one and print them
		while (!S.isEmpty()) {
			root = S.pop();
			System.out.println(root.data + " ");

		}
	}

}
