package basic;

import java.util.LinkedList;
import java.util.Queue;

public class T33HeightIterative {

	public static void main(String[] args) {
		BNode root = new BNode(50);

		root.left = new BNode(30);
		root.right = new BNode(70);

		root.left.left = new BNode(20);
		root.left.right = new BNode(40);

		root.right.left = new BNode(60);
		root.right.left.right = new BNode(80);
		System.out.println(treeHeight(root));
	}

	// Iterative method to find height of Bianry Tree
	public static int treeHeight(BNode root) {
		if (root == null)
			return 0;
		
		Queue<BNode> q = new LinkedList<BNode>();
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
				BNode node = q.poll();
				if (node.left != null)
					q.offer(node.left);
				if (node.right != null)
					q.offer(node.right);
				nodeCount--;
			}
		}
	}

}
