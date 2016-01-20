package sort.basic;

public class LL002GetMiddleNodeOfList {

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
		//System.out.println(middleNode(root).data);
		System.out.println(getMiddleNodeFromList(root).data);
		
	}

	public static Node middleNode(Node root) {

		Node tmp = root;  // iterate 1 step
		Node tmp2 = root; // Iterate 2 step

		while (tmp2 != null) {
			if (tmp2.next == null || tmp2.next.next == null)
				break;
			tmp2 = tmp2.next.next;
			tmp = tmp.next;
		}

		return tmp;

	}
	
	static int myListLength = 0;
	static int currentReverseIndex = 0;								
	public static Node getMiddleNodeFromList(Node root) {
			if (root != null) {
				myListLength++;
				Node mid = getMiddleNodeFromList(root.next);
				if (mid != null) {
					return mid;
				}
				currentReverseIndex++;
			}
			if (currentReverseIndex * 2 == myListLength
					|| currentReverseIndex * 2 == myListLength + 1){
				return root;
			}
			return null;
	}

}
