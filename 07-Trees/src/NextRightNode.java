import java.util.LinkedList;
import java.util.Queue;

public class NextRightNode {

	public static void main(String[] args) {
		BNode root = new BNode(20);
		root.left = new BNode(8);
		root.right = new BNode(22);
		root.left.left = new BNode(4);
		root.left.right = new BNode(12);
		root.left.right.left = new BNode(10);
		root.left.right.right = new BNode(14);
		System.out.println(nextRight(root, 8).data);
	}

	// Method to find next right of given key k, it returns null if k is
	// not present in tree or k is the rightmost node of its level
	public static BNode nextRight(BNode root, int k) {
		if (root == null)
			return null;

		Queue<BNode> qn = new LinkedList<BNode>(); 
		Queue<Integer> ql = new LinkedList<Integer>(); 

		int level = 0; 
		qn.offer(root);
		ql.offer(level);
		System.out.println(qn.peek().data);

		// A standard BFS loop
		while (!qn.isEmpty()) {
			BNode node = qn.poll();
			level = ql.poll();

			// If the dequeued node has the given key k
			if (node.data == k) {
				System.out.println("Got data node");
				// If there are no more items in queue or given node is
				// the rightmost node of its level, then return null
				if (ql.size() == 0 || ql.peek() != level)
					return null;

				return qn.poll();
			}

			// Standard BFS steps: enqueue children of this node
			if (node.left != null) {
				qn.offer(node.left);
				ql.offer(level + 1);
			}
			if (node.right != null) {
				qn.offer(node.right);
				ql.offer(level + 1);
			}
		}
		return null;
	}

}
