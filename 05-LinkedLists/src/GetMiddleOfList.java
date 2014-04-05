public class GetMiddleOfList {

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
		System.out.println(middleNode(root).data);

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

}