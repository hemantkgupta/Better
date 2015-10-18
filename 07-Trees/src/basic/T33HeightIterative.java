package basic;

import advanced.*;

import java.util.LinkedList;
import java.util.Queue;

public class T33HeightIterative {

	public static void main(String[] args) {
		advanced.BNode root = new advanced.BNode(50);

		root.left = new advanced.BNode(30);
		root.right = new advanced.BNode(70);

		root.left.left = new advanced.BNode(20);
		root.left.right = new advanced.BNode(40);

		root.right.left = new advanced.BNode(60);
		root.right.left.right = new advanced.BNode(80);
		System.out.println(treeHeight(root));
	}

	// Iterative method to find height of Bianry Tree
	public static int treeHeight(advanced.BNode root) {
		if (root == null)
			return 0;
		
		Queue<advanced.BNode> q = new LinkedList<advanced.BNode>();
		q.offer(root);
		int height = 0;

		while (true) {
			// nodeCount (queue size) is number of nodes
			// at current lelvel.
			int nodeCount = q.size();
			if (nodeCount == 0)
				return height;

			height++;

			// Dequeue all nodes of current level and Enqueue all
			// nodes of next level
			while (nodeCount > 0) {
				advanced.BNode node = q.poll();
				if (node.left != null)
					q.offer(node.left);
				if (node.right != null)
					q.offer(node.right);
				nodeCount--;
			}
		}
	}

}
