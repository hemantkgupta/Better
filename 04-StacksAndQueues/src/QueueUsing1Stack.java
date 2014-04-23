public class QueueUsing1Stack {
	LinkedListStack stack1;

	public QueueUsing1Stack() {
		stack1 = new LinkedListStack();
	}

	public void enqueue(int x) {
		this.stack1.push(x);
	}

	public int dequeue() {
		int x, res;

		if (this.stack1.isEmpty()) {
			System.out.printf("Q is empty");
			return Integer.MIN_VALUE;
			
		} else if (this.stack1.top.next == null) {
			return this.stack1.pop();
			
		} else {
			x = this.stack1.pop();
			res = dequeue();
			this.stack1.push(x);
			return res;
		}

	}

}
