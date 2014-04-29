public class AddTwoNumbers {

	public static void main(String[] args) {
		Node root = new Node(2);
		root.next = new Node(5);
		root.next.next = new Node(1);
		root.next.next.next = new Node(1);
		
		Node root2 = new Node(5);
		Node n1 = new Node(4);
		root2.next = n1;
		Node n2 = new Node(3);
		n1.next = n2;
		
		System.out.println(addLists(root, root2));
	}

	private static Node addLists(Node l1, Node l2) {
		int len1 = length(l1);
		int len2 = length(l2);
		if (len1 < len2) {
			l1 = padList(l1, len2 - len1);
		} else {
			l2 = padList(l2, len1 - len2);
		}
		PartialSum sum = addListsHelper(l1, l2);
		if (sum.carry == 0) {
			return sum.sum;
		} else {
			Node result = insertBefore(sum.sum, sum.carry);
			return result;
		}
	}

	private static PartialSum addListsHelper(Node l1, Node l2) {
		if (l1 == null && l2 == null) {
			PartialSum sum = new PartialSum();
			return sum;
		}
		PartialSum sum = addListsHelper(l1.next, l2.next);
		int val = sum.carry + l1.data + l2.data;
		Node full_result = insertBefore(sum.sum, val % 10);
		sum.sum = full_result;
		sum.carry = val / 10;
		return sum;
	}

	private static int length(Node l) {
		if (l == null) {
			return 0;
		} else {
			return 1 + length(l.next);
		}
	}

	private static Node padList(Node l, int padding) {
		Node head = l;
		for (int i = 0; i < padding; i++) {
			Node n = new Node(0);
			n.next = head;
			head = n;
		}
		return head;
	}

	private static Node insertBefore(Node list, int data) {
		Node node = new Node(data);
		if (list != null) {
			node.next = list;
		}
		return node;
	}

}

class PartialSum {
	public Node sum = null;
	public int carry = 0;
}
