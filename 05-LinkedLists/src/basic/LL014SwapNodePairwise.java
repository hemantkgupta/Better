package basic;

public class LL014SwapNodePairwise {

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
		pairWiseSwap(root);
		System.out.println(root);

	}

	/* Function to pairwise swap data of a linked list */
	public static void pairWiseSwap(Node head) {
		Node temp = head;
		while (temp != null && temp.next != null) {
			swapData(temp, temp.next);
			temp = temp.next.next;
		}
	}

	public static void swapData(Node a, Node b) {
		int temp = a.data;
		a.data = b.data;
		b.data = temp;
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
