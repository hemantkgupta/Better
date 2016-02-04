package basic;

public class LL013ReverseDLL {

	public static void main(String[] args) {
		DNode root = new DNode(1);
		root.next = new DNode(2);
		root.next.prev = root;
		root.next.next = new DNode(3);
		root.next.next.prev = root.next;
		root = reverse(root);
		printDLL(root);
	}

	public static DNode reverse(DNode root) {

		DNode temp = null;
		DNode current = root;

		while (current != null) {
			// swap current prev and next
			temp = current.prev;
			current.prev = current.next;
			current.next = temp;

			// now update new current
			current = current.prev;
		}

		// empty or single node list
		if (temp != null)
			root = temp.prev;
		return root;
	}

	public static void printDLL(DNode root) {
		DNode tmp = root;
		System.out.println("The list is: ");
		while (tmp != null) {
			System.out.print(tmp.data + ", ");
			tmp = tmp.next;
		}
		System.out.print("null\n");

	}

}
