package basic;

import java.util.Deque;
import java.util.LinkedList;

/**
 * In this approach, stackNewest has the newest elements on top and stackOldest
 has the oldest elements on top. When we dequeue an element, we want to remove
 the oldest element first, and so we dequeue from stackOldest. If stackOldest is
 empty, then we want to transfer all elements from stackNewest into this stack in
 reverse order.To insert an element, we push onto stackNewest, since it has the newest
 elements on top.
 */
public class SAQ07QueueUsingTwoStack2 {

    public static void main(String[] args) {
        SAQ07QueueUsingTwoStack2 queue = new SAQ07QueueUsingTwoStack2();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.dequeue();
        System.out.println(queue.peek());
    }

	Deque<Integer> stackNewest;
	Deque<Integer> stackOldest;

	public SAQ07QueueUsingTwoStack2() {
		stackNewest = new LinkedList<>();
		stackOldest = new LinkedList<>();
	}

	//To enqueue put the new element into to newest
	public void enqueue(int x) {
		this.stackNewest.push(new Integer(x));
	}

	/**
	 * To dequeue check if both are not empty
	 * If oldest is empty, fill it from newest
	 * and then return the top
	 * @return
	 */
	public void dequeue() {
		/* If both stacks are empty then error */
		if (this.stackNewest.isEmpty() && this.stackOldest.isEmpty()) {
			return;
		}

		/*
		 * Move elements only if stackOldest is empty
		 */
		if (this.stackOldest.isEmpty()) {
			while (!this.stackNewest.isEmpty()) {
				this.stackOldest.push(this.stackNewest.pop());
			}
		}

		this.stackOldest.pop();
		return;
	}

	/**
	 * Same as dequeue but the at last item is peeked
	 * @return
     */

    public int peek(){
        if (this.stackOldest.isEmpty()) {
            while (!this.stackNewest.isEmpty()) {
                this.stackOldest.push(this.stackNewest.pop());
            }
        }
        return this.stackOldest.peek();
    }

}
