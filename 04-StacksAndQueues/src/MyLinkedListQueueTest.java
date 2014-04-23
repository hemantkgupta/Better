
public class MyLinkedListQueueTest {

	public static void main(String[] args) {
		LinkedListQueue queue =  new LinkedListQueue();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}

}
