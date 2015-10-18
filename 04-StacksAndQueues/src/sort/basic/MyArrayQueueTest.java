package sort.basic;

public class MyArrayQueueTest {

	public static void main(String[] args) {
		//SAQ003QueueUsingArray queue =  new SAQ003QueueUsingArray(10);
		//SAQ008QueueUsingTwoStack queue = new SAQ008QueueUsingTwoStack(10);
		SAQ009QueueUsingOneStack queue = new SAQ009QueueUsingOneStack();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}

}
