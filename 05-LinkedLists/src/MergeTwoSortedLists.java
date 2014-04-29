public class MergeTwoSortedLists {

	public static void main(String[] args) {
		Node root = new Node(1);
		Node n1 = new Node(3);
		root.next = n1;
		Node n2 = new Node(5);
		n1.next = n2;
		Node n3 = new Node(7);
		n2.next = n3;
		Node n4 = new Node(9);
		n3.next = n4;
		
		Node root2 = new Node(2);
		root2.next = new Node(4);
		root2.next.next = new Node(6);
		System.out.println(SortedMerge(root, root2));
	}

	public static Node SortedMerge(Node a, Node b) {
		Node result = null;

		/* Base cases */
		if (a == null)
			return (b);
		else if (b == null)
			return (a);

		/* Pick either a or b, and recur */
		if (a.data <= b.data) {
			result = a;
			result.next = SortedMerge(a.next, b);
		} else {
			result = b;
			result.next = SortedMerge(a, b.next);
		}
		return (result);
	}

}
