package advanced;


public class LL027SegregateEvensAndOddsInList {

	public static void main(String[] args) {
		
			Node root = new Node(12);
			root.next = new Node(15);
			root.next.next = new Node(10);
			root.next.next.next = new Node(11);
			root.next.next.next.next = new Node(5);
			root.next.next.next.next.next = new Node(6);
			root.next.next.next.next.next.next = new Node(2);
			root.next.next.next.next.next.next.next = new Node(3);
			segregateEvenOdd(root);
			System.out.println(root);

	}

	public static void segregateEvenOdd(Node head_ref) {
		Node end = head_ref;

		Node prev = null;
		Node curr = head_ref;

		/* Get pointer to the last node */
		while (end.next != null)
			end = end.next;

		Node new_end = end;

		/*
		 * Consider all odd nodes before the first even node and move then after
		 * end
		 */
		while (curr.data % 2 != 0 && curr != end) {
			new_end.next = curr;
			curr = curr.next;
			new_end.next.next = null;
			new_end = new_end.next;
		}

		/* Do following steps only if there is any even node */
		if (curr.data % 2 == 0) {
			/* Change the head pointer to point to first even node */
			head_ref = curr;

			/* now current points to the first even node */
			while (curr != end) {
				if ((curr.data) % 2 == 0) {
					prev = curr;
					curr = curr.next;
				} else {
					/* break the link between prev and current */
					prev.next = curr.next;

					/* Make next of curr as null */
					curr.next = null;

					/* Move curr to end */
					new_end.next = curr;

					/* make curr as new end of list */
					new_end = curr;

					/* Update current pointer to next of the moved node */
					curr = prev.next;
				}
			}
		}

		else
			prev = curr;

		/*
		 * If there are more than 1 odd nodes and end of original list is odd
		 * then move this node to end to maintain same order of odd numbers in
		 * modified list
		 */
		if (new_end != end && (end.data) % 2 != 0) {
			prev.next = end.next;
			end.next = null;
			new_end.next = end;
		}
		return;
	}

}
