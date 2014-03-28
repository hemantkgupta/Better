public class ReverseListRecursive {

	public static void main(String[] args) {
		Node root = new Node(5);
		Node n1 = new Node(4);
		root.next = n1;
		Node n2 = new Node(3);
		n1.next = n2;
		Node n3 = new Node(2);
		n2.next = n3;
		Node n4 = new Node(1);
		n3.next = n4;

		printList(root);
		root = reverseRecur(root);
		printList(root);
	}

	public static Node reverseRecur(Node current) {
		if (current == null || current.next == null)
			return current;

		Node nextItem = current.next;
		current.next = null;
		Node reverseRest = reverseRecur(nextItem);
		nextItem.next = current;
		return reverseRest;
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
