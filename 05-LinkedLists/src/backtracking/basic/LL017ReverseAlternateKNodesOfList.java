package backtracking.basic;

public class LL017ReverseAlternateKNodesOfList {

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
        System.out.println(root);
        System.out.println(kAltReverse(root, 3));
	}

	// Reverses alternate k nodes
	public static Node kAltReverse(Node head, int k) {
		Node current = head;
		Node next;
		Node prev = null;
		int count = 0;

		// reverse first k nodes of the linked list */
		while (current != null && count < k) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}

		// Now head points to the kth node
		if (head != null)
			head.next = current;

		// skip next k nodes
		count = 0;
		while (count < k - 1 && current != null) {
			current = current.next;
			count++;
		}

		// Recursively call
		if (current != null)
			current.next = kAltReverse(current.next, k);

		return prev;
	}

}
