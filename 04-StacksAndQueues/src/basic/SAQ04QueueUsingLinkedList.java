package basic;

public class SAQ04QueueUsingLinkedList {

    public static void main(String[] args) {
        SAQ04QueueUsingLinkedList queue = new SAQ04QueueUsingLinkedList();
        System.out.println(queue.isEmpty());
        System.out.println(queue.peek());
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println(queue.peek());
        System.out.println(queue.isEmpty());

    }

	QNode front, rear;

	public SAQ04QueueUsingLinkedList() {
		this.front = null;
		this.rear = null;
	}

	public void enqueue(int k) {
		QNode node = new QNode(k);

        //First do rear work
        if (this.rear != null){
            this.rear.next = node;
        }
        this.rear = node;

        //Now do front work if First Item
        if (this.front == null) {
            this.front =  node;
        }
	}

	public int peek(){
        if (isEmpty())
            return Integer.MIN_VALUE;
        return this.front.key;
    }

	public int dequeue() {
        // First do the front work
		if (this.front == null){
            this.rear = null;
            return Integer.MIN_VALUE;
        }

		int key = this.front.key;
		this.front = this.front.next;
		return key;
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
