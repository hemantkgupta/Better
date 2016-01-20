package sort.basic;

public class SAQ02StackUsingLinkedList {

	StackNode top;

	public SAQ02StackUsingLinkedList() {
		top = null;
	}

	public void push(int item) {
		StackNode node = new StackNode(item);
		if (top == null) {
			top = node;
			return;
		}
		node.next = top;
		top = node;
	}

	public int pop() {
		if (top == null)
			return Integer.MIN_VALUE;

		int temp = top.key;
		top = top.next;
		return temp;
	}

	public int peek() {
		if (top == null)
			return Integer.MIN_VALUE;

		return this.top.key;
	}

	public boolean isEmpty() {
		return this.top == null;
	}

	class StackNode {
		int key;
		StackNode next;

		public StackNode(int data) {
			this.key = data;
			this.next = null;
		}
	}
}
