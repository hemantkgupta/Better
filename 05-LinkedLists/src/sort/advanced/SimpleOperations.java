package sort.advanced;

public class SimpleOperations {

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
		//n4.next = n2; Comment out this line to test loop

		// System.out.println(getNthNode(root, 4).data);
		// System.out.println(getNthNodeWhile(root, 4).data);
		// System.out.println(middleNode(root).data);
		// System.out.println(getNthNodeFromEnd(root, 4).data);
		// printList(root);
		// printList(reverse(root));
		// reversePrintRecursive(root);
		// printList(root);
		System.out.println(testLoopInList(root));

	}

	public static Node getNthNode(Node root, int n) {
		if (n <= 0 | root == null)
			return null; // Not exist the node
		if (n == 1)
			return root;
		Node tmp = root;
		for (int i = 1; i < n; i++) {
			if (tmp.next == null)
				return null;
			tmp = tmp.next;
		}
		return tmp;
	}

	public static Node getNthNodeWhile(Node root, int n) {
		if (n <= 0 | root == null)
			return null; // Not exist the node
		while (--n > 0) {
			if (root.next == null) {
				return null;
			} else {
				root = root.next;
			}
		}
		return root;
	}

	public static Node middleNode(Node root) {

		Node tmp = root;
		Node tmp2 = root;

		while (tmp2 != null) {
			if (tmp2.next == null || tmp2.next.next == null)
				break;
			tmp2 = tmp2.next.next;
			tmp = tmp.next;
		}

		return tmp;

	}

	public static Node getNthNodeFromEnd(Node root, int n) {

		Node tmp = root;
		Node ntmp = root;
		for (int i = 1; i <= n; i++) {
			if (ntmp == null) {
				return null;
			}
			ntmp = ntmp.next;
		}
		while (ntmp != null) {
			ntmp = ntmp.next;
			tmp = tmp.next;
		}
		return tmp;

	}

	public static Node reverse(Node head) {
		if (head == null)
			return head;

		Node current = head;
		Node previous = null;

		while (current != null) {
			Node nextNode = current.next;

			current.next = previous;
			previous = current;
			current = nextNode;
		}

		head = previous;
		return head;
	}
	
	public static Node reverseRecur(Node current) {		
			if (current == null || current.next == null )
				return current ;

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
		System.out.print("null");
	}

	public static void reversePrintRecursive(Node current) {
		if (null == current.next) {
			System.out.println("End Item is: " + current.data);
			return;
		} else {
			// Store the current element and print next element recursively
			int value = current.data;
			reversePrintRecursive(current.next);
			System.out.println("Item is: " + value);
		}
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

}


