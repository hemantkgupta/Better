package sort.basic;

public class SAQ003QueueUsingArray {
	int front, rear, size;
	int capacity;
	int[] array;

	public SAQ003QueueUsingArray(int capacity) {
		this.size = 0;
		this.front = 0;
		this.rear = capacity - 1;
		this.capacity = capacity;
		array = new int[capacity];
	}

	public boolean isFull() {
		return (this.size == this.capacity);
	}

	public boolean isEmpty() {
		return (this.size == 0);
	}

	public void enqueue(int item) {
		if (isFull())
			return;
		this.rear = (this.rear + 1) % this.capacity;
		this.array[this.rear] = item;
		this.size = this.size + 1;
	}

	public int dequeue() {
		if (isEmpty())
			return Integer.MIN_VALUE;
		int item = this.array[this.front];
		this.front = (this.front + 1) % this.capacity;
		this.size = this.size - 1;
		return item;
	}

	public int front() {
		if (isEmpty())
			return Integer.MIN_VALUE;
		return this.array[this.front];
	}

	public int rear() {
		if (isEmpty())
			return Integer.MIN_VALUE;
		return this.array[this.rear];
	}
}
