package sort.basic;

public class LL004ReverseListRecursive {

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
		root = reverseRecr(root);
		printList(root);
	}

	public static Node reverseRecr(Node current) {
        // base case
		if (current == null || current.next == null)
			return current;

        // Save next to current
		Node nextItem = current.next;
		current.next = null;

        // Do recursion
		Node reverseRest = reverseRecr(nextItem);

        // Update next of saved
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
