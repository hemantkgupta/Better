public class GetNthNode {

	public static void main(String[] args) {

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

}
