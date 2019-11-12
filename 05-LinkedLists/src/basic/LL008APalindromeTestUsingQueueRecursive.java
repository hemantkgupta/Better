package basic;

import java.util.LinkedList;
import java.util.Queue;

public class LL008APalindromeTestUsingQueueRecursive {

	public static void main(String[] args) {
		Node root = new Node(5);
		Node n1 = new Node(4);
		root.next = n1;
		Node n2 = new Node(5);
		n1.next = n2;
		System.out.println(isPalindromeRecrQueue(root));
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
	



}
