import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class PalindromeTest {

	public static void main(String[] args) {
		Node root = new Node(5);
		Node n1 = new Node(4);
		root.next = n1;
		Node n2 = new Node(5);
		n1.next = n2;
		System.out.println(isPalindromeRecrQueue(root));
		System.out.println(isPalindromeStack(root));
	}

	public static Queue<Integer> queue = new LinkedList<Integer>();
	public static boolean isPalindromeRecrQueue(Node root) {
		
		if (root != null) {
			queue.offer(root.data);
			if (!isPalindromeRecrQueue(root.next))
				return false;
			if (root.data != queue.poll().intValue())
				return false;
		}
		return true;
	}
	
	public static boolean isPalindromeStack(Node head) {
		Node fast = head;
		Node slow = head;
		
		Deque<Integer> stack = new ArrayDeque<Integer>();
		
		while (fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;			
		}
		
		/* Has odd number of elements, so skip the middle */
		if (fast != null) { 
			slow = slow.next;
		}
		
		while (slow != null) {
			int top = stack.pop().intValue();
			if (top != slow.data) {
				return false;
			}
			slow = slow.next;
		}
		return true;
	}


}
