package backtracking.basic;

/**
 * In this approach, stackNewest has the newest elements on top and stackOldest
 has the oldest elements on top. When we dequeue an element, we want to remove
 the oldest element first, and so we dequeue from stackOldest. If stackOldest is
 empty, then we want to transfer all elements from stackNewest into this stack in
 reverse order.To insert an element, we push onto stackNewest, since it has the newest
 elements on top.
 */
public class SAQ07QueueUsingTwoStack {
	SAQ01StackUsingArray stackNewest;
	SAQ01StackUsingArray stackOldest;

	public SAQ07QueueUsingTwoStack(int capacity) {
		stackNewest = new SAQ01StackUsingArray(capacity);
		stackOldest = new SAQ01StackUsingArray(capacity);
	}

	//To enqueue put the new element into to newest
	public void enqueue(char x) {
		this.stackNewest.push(x);
	}

	/**
	 * To dequeue check if both are not empty
	 * If oldest is empty, fill it from newest
	 * and then return the top
	 * @return
	 */
	public int dequeue() {
		char x;

		/* If both stacks are empty then error */
		if (this.stackNewest.isEmpty() && this.stackOldest.isEmpty()) {
			System.out.printf("Q is empty");
			return Integer.MIN_VALUE;
		}

		/*
		 * Move elements only if stackOldest is empty
		 */
		if (this.stackOldest.isEmpty()) {
			while (!this.stackNewest.isEmpty()) {
				x = (char) this.stackNewest.pop();
				this.stackOldest.push(x);
			}
		}

		x = (char) this.stackOldest.pop();
		return x;
	}
}
