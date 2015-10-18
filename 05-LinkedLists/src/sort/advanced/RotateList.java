package sort.advanced;

public class RotateList {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.next = new Node(2);
		root.next.next = new Node(3);
		root.next.next.next = new Node(4);
		root.next.next.next.next = new Node(5);
		root.next.next.next.next.next = new Node(6);
		root.next.next.next.next.next.next = new Node(7);
		root.next.next.next.next.next.next.next = new Node(8);
		root.next.next.next.next.next.next.next.next = new Node(9);
		root = rotate(root, 3);
		System.out.println(root);

	}

	// rotates list counter-clockwise by k steps
	// if k >= size of list , same head is returned
	public static Node rotate(Node head_ref, int k) {
		if (k == 0)
			return null;

		Node current = head_ref;

		// current will either point to kth or null after this loop.
		int count = 1;
		while (count < k && current != null) {
			current = current.next;
			count++;
		}

		if (current == null)
			return head_ref;

		Node kthNode = current;

		while (current.next != null)
			current = current.next;

		current.next = head_ref;

		// Change head to (k+1)th node
		head_ref = kthNode.next;

		// change next of kth node to null
		kthNode.next = null;

		return head_ref;
	}

}
