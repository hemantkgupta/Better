package sort.basic;

public class SAQ008QueueUsingTwoStack {
	SAQ001StackUsingArray stack1;
	SAQ001StackUsingArray stack2;

	public SAQ008QueueUsingTwoStack(int capacity) {
		stack1 = new SAQ001StackUsingArray(capacity);
		stack2 = new SAQ001StackUsingArray(capacity);
	}

	public void enqueue(int x) {
		this.stack1.push(x);
	}

	public int dequeue() {
		int x;

		/* If both stacks are empty then error */
		if (this.stack1.isEmpty() && this.stack2.isEmpty()) {
			System.out.printf("Q is empty");
			return Integer.MIN_VALUE;
		}

		/*
		 * Move elements only if stack2 is empty
		 */
		if (this.stack2.isEmpty()) {
			while (!this.stack1.isEmpty()) {
				x = this.stack1.pop();
				this.stack2.push(x);
			}
		}

		x = this.stack2.pop();
		return x;
	}
}