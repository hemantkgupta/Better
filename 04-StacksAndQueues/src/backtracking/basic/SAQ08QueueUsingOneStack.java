package backtracking.basic;

public class SAQ08QueueUsingOneStack {
	SAQ02StackUsingLinkedList stack1;

	public SAQ08QueueUsingOneStack() {
		stack1 = new SAQ02StackUsingLinkedList();
	}

	public void enqueue(int x) {
		this.stack1.push(x);
	}

	public int dequeue() {
		int x, res;

		if (this.stack1.isEmpty()) {
			System.out.printf("Q is empty");
			return Integer.MIN_VALUE;
			
		} else if (this.stack1.top.next == null) { // only one element
			return this.stack1.pop();
			
		} else {
			x = this.stack1.pop();
			res = dequeue();
			this.stack1.push(x);
			return res;
		}

	}

	public static void main(String[] args) {
		SAQ08QueueUsingOneStack stack = new SAQ08QueueUsingOneStack();
		stack.enqueue(1);
		stack.enqueue(2);
		stack.enqueue(3);
		stack.enqueue(4);
		System.out.println(stack.dequeue());
		System.out.println(stack.dequeue());
		System.out.println(stack.dequeue());
		System.out.println(stack.dequeue());
	}

}
