package backtracking.basic;

public class LL011DeleteDuplicateNodeOfSortedList {

	public static void main(String[] args) {

		Node root = new Node(1);
		Node n1 = new Node(2);
		root.next = n1;
		Node n2 = new Node(3);
		n1.next = n2;
		Node n3 = new Node(3);
		n2.next = n3;
		Node n4 = new Node(4);
		n3.next = n4;
		removeDuplicates(root);
		printList(root);

	}

	public static void removeDuplicates(Node head) {
		Node current = head;
		Node nextNode;
		if (current == null)
			return;

		while (current.next != null) {
			/* Compare current node with next node */
			if (current.data == current.next.data) {
				/* The sequence of steps is important */
				nextNode = current.next.next;
				current.next = null;
				current.next = nextNode;
			} else /* This is tricky: only advance if no deletion */
			{
				current = current.next;
			}
		}
	}

	public static void printList(Node root) {
		Node tmp = root;
		System.out.println("The list is: ");
		while (tmp != null) {
			System.out.print(tmp.data + ", ");
			tmp = tmp.next;
		}
		System.out.print("null\n");

	}

}
