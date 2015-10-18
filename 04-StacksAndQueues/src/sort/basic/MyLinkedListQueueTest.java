package sort.basic;

public class MyLinkedListQueueTest {

	public static void main(String[] args) {
		SAQ004QueueUsingLinkedList queue =  new SAQ004QueueUsingLinkedList();
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
