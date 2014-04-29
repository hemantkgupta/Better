public class InsertSortedCircularList {

	public static void main(String[] args) {
		Node root = new Node(1);

		root.next = new Node(2);
		root.next.next = new Node(4);

		root.next.next.next = new Node(6);
		root.next.next.next.next = root;
		printList(root);
		sortedInsert(root, new Node(3));
		printList(root);

	}

	// insert a new node in sorted circular linked list
	public static void sortedInsert(Node head_ref, Node new_node) {
		Node current = head_ref;

		if (current == null) {
			new_node.next = new_node;
			head_ref = new_node;
		}

		else if (current.data >= new_node.data) {
			while (current.next != head_ref)
				current = current.next;

			current.next = new_node;
			new_node.next = head_ref;
			head_ref = new_node;
		}

		else {
			while (current.next != head_ref
					&& current.next.data < new_node.data)
				current = current.next;

			new_node.next = current.next;
			current.next = new_node;
		}
	}

	public static void printList(Node root) {
		Node tmp = root.next;
		System.out.println("\nThe list is: ");
		System.out.print(root.data + ", ");
		while (tmp != root) {
			System.out.print(tmp.data + ", ");
			tmp = tmp.next;
		}

	}

}
