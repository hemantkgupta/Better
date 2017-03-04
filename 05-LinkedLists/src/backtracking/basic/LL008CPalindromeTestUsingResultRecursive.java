package backtracking.basic;

public class LL008CPalindromeTestUsingResultRecursive {

	public static void main(String[] args) {
		Node root = new Node(5);
		Node n1 = new Node(4);
		root.next = n1;
		Node n2 = new Node(5);
		n1.next = n2;
		System.out.println(isPalindrome(root));
	}

	public static Result isPalindromeRecurse(Node head, int length) {
		
		//base case
		if (head == null || length == 0) {
			return new Result(null, true);
		} else if (length == 1) {
			return new Result(head.next, true);
		} else if (length == 2) {
			return new Result(head.next.next, head.data == head.next.data);
		}
		// recursive call
		Result res = isPalindromeRecurse(head.next, length - 2);
		
		
		if (!res.result || res.node == null) {
			return res;
		} else {
			res.result = head.data == res.node.data;
			res.node = res.node.next;
			return res;
		}
	}

	public static boolean isPalindrome(Node head) {
		int size = 0;
		Node n = head;
		while (n != null) {
			size++;
			n = n.next;
		}
		Result p = isPalindromeRecurse(head, size);
		return p.result;
	}

static class Result {
	public Node node;
	public boolean result;

	public Result(Node n, boolean res) {
		node = n;
		result = res;
	}
}
}

