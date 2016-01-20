package sort.basic;

public class SAQ04QueueUsingLinkedList {

	QNode front, rear;

	public SAQ04QueueUsingLinkedList() {
		this.front = null;
		this.rear = null;
	}

	public void enqueue(int k) {
		QNode node = new QNode(k);
		if (this.rear == null) {
			this.front = this.rear = node;
			return;
		}
		this.rear.next = node;
		this.rear = node;
	}

	public int dequeue() {
		if (this.front == null)
			return Integer.MIN_VALUE;

		QNode node = this.front;
		this.front = this.front.next;
		if (this.front == null)
			this.rear = null;
		return node.key;
	}
	
	public boolean isEmpty() {
		return (this.front == null);
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
