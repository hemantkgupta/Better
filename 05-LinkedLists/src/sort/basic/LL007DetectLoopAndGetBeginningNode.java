package sort.basic;

public class LL007DetectLoopAndGetBeginningNode {

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
		n4.next = n2;
		System.out.println(testLoopInList(root));
		System.out.println(getStartLoopNode(root).data);
	}

	public static boolean testLoopInList(Node root) {

		Node slow = root;
		Node fast = root;

		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				return true;
		}
		return false;
	}

	public static Node getStartLoopNode(Node head) {
		Node slow = head;
		Node fast = head;

		// Find meeting point
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}

		//If there is no meeting point, then no loop
		if (fast == null || fast.next == null) {
			return null;
		}

		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}

		// Now slow and fast point to start of the loop.
		return fast;
	}

}
