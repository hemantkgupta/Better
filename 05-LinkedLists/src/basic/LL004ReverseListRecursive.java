package basic;

public class LL004ReverseListRecursive {

	public static void main(String[] args) {
		Node root = new Node(5);
		Node n1 = new Node(4);
		root.next = n1;


		printList(root);
		root = reverseRecr(root);
		printList(root);
	}

	public static Node reverseRecr(Node current) {
        // Base case if node is null
		// Or if node is last node
		if (current == null || current.next == null)
			return current;

        //1. Going down save node next to current
		Node nextItem = current.next;

		//2. Disconnect the link
		current.next = null;

        //3. Do recursion
		Node reverseRest = reverseRecr(nextItem);

        //4. Coming up, connect the link using saved node
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
