package advanced;

public class DeleteAList {

	public static void main(String[] args) {

	}

	public static void deleteList(Node root) {
		Node current = root;
		Node next;

		while (current != null) {
			next = current.next;
			current = null;
			current = next;
		}

		root = null;
	}

}
