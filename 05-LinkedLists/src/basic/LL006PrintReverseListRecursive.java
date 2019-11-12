package basic;

public class LL006PrintReverseListRecursive {

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
		printReverseListRecr(root);

	}
	private static void printReverseListRecr(Node current) {
		// if reached the end of the list, just print the tail
		if (null == current.next) {
			System.out.println("End Item is: " + current.data);
			return;
		} else {
			// Save the current element value
			int value = current.data;

            // Do the recursion
			printReverseListRecr(current.next);

            // while coming back print saved element value
			System.out.println("Item is: " + value);
		}
	}

}
