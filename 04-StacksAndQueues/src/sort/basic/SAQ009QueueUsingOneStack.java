package sort.basic;

public class SAQ009QueueUsingOneStack {
	SAQ002StackUsingLinkedList stack1;

	public SAQ009QueueUsingOneStack() {
		stack1 = new SAQ002StackUsingLinkedList();
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

}