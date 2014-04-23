public class LinkedListQueue {

	QNode front, rear;

	public LinkedListQueue() {
		this.front = null;
		this.rear = null;
	}

	// The function to add a key k to q
	public void enQueue(int k) {
		// Create a new LL node
		QNode node = new QNode(k);

		// If queue is empty, then new node is front and rear both
		if (this.rear == null) {
			this.front = this.rear = node;
			return;
		}

		// Add the new node at the end of queue and change rear
		this.rear.next = node;
		this.rear = node;
	}

	// Function to remove a key from given queue q
	public int deQueue() {
		// If queue is empty, return MIN.
		if (this.front == null)
			return Integer.MIN_VALUE;

		// Store previous front and move front one node ahead
		QNode node = this.front;
		this.front = this.front.next;

		// If front becomes NULL, then change rear also as NULL
		if (this.front == null)
			this.rear = null;
		return node.key;
	}

	class QNode {
		int key;
		QNode next;

		public QNode(int key) {
			this.key = key;
			this.next = null;
		}
	}

}
