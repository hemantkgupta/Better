public class IntersectionOfTwoList {

	public static void main(String[] args) {
		
		Node root1 = new Node(5);
		Node n1 = new Node(4);
		root1.next = n1;
		Node n2 = new Node(3);
		n1.next = n2;
		Node n3 = new Node(2);
		n2.next = n3;
		Node n4 = new Node(1);
		n3.next = n4;
		
		
		Node root2 = new Node(6);
		Node m1 = new Node(5);
		root2.next = m1;
		Node m2 = new Node(7);
		m1.next = m2;
		Node m3 = new Node(2);
		m2.next = m3;
		m3.next=n2;
		
		System.out.println(getIntesectionNode(root1,root2));
		
	}

	public static int getIntesectionNode(Node head1, Node head2) {
		int c1 = getCount(head1);
		int c2 = getCount(head2);
		int d;

		if (c1 > c2) {
			d = c1 - c2;
			return _getIntesectionNode(d, head1, head2);
		} else {
			d = c2 - c1;
			return _getIntesectionNode(d, head2, head1);
		}
	}

	/*
	 * function to get the intersection point of two linked lists head1 and
	 * head2 where head1 has d more nodes than head2
	 */
	public static int _getIntesectionNode(int d, Node head1, Node head2) {
		int i;
		Node current1 = head1;
		Node current2 = head2;

		for (i = 0; i < d; i++) {
			if (current1 == null) {
				return -1;
			}
			current1 = current1.next;
		}

		while (current1 != null && current2 != null) {
			if (current1 == current2)
				return current1.data;
			current1 = current1.next;
			current2 = current2.next;
		}

		return -1;
	}

	/*
	 * Takes head pointer of the linked list and returns the count of nodes in
	 * the list
	 */
	public static int getCount(Node head) {
		Node current = head;
		int count = 0;

		while (current != null) {
			count++;
			current = current.next;
		}
		System.out.println("the count is: "+count);
		return count;
	}

}
