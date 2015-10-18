package sort.basic;

public class LL016ReverseEveryKNodesOfList {

	public static void main(String[] args) {
		
		Node root = new Node(10);
		Node n1 = new Node(9);
		root.next = n1;
		Node n2 = new Node(8);
		n1.next = n2;
		Node n3 = new Node(7);
		n2.next = n3;
		Node n4 = new Node(6);
		n3.next = n4;
		Node n5 = new Node(5);
		n4.next = n5;
		Node n6 = new Node(4);
		n5.next = n6;
		Node n7 = new Node(3);
		n6.next = n7;
		Node n8 = new Node(2);
		n7.next = n8;
		Node n9 = new Node(1);
		n8.next = n9;

		root=reverse(root, 3);
		printList(root);
	}

	
	// Reverses the linked list in groups of size k
	public static Node reverse(Node head, int k) {
		Node current = head;
		Node next = null;
		Node prev = null;
		int count = 0;

		/* reverse first k nodes of the linked list */
		while (current != null && count < k) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}

		// next is now a pointer to (k+1)th node. 
		// Make rest of the list as next of first node
		
		if (next != null) {
			head.next = reverse(next, k);
		}
		
		/* prev is new head of the input list */
		return prev;
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
