
public class ArrayQueue {
	int front,rear,size;
    int capacity;
    int[] array;
    
    
    
 public ArrayQueue(int capacity) {
	    this.size =0;
		this.front=0;
		this.rear =capacity-1;
		this.capacity = capacity;
		array = new int[capacity];
	}

// Queue is full when size becomes equal to the capacity 
    public boolean isFull()
    {  return (this.size == this.capacity);  }
     
    // Queue is empty when size is 0
    public boolean isEmpty()
    {  return (this.size == 0); }
     
    // Function to add an item to the queue.  It changes rear and size
    public void enqueue(int item)
    {
        if (isFull())
            return;
        this.rear = (this.rear + 1)%this.capacity;
        this.array[this.rear] = item;
        this.size = this.size + 1;
        System.out.printf("Enqueued to queue %d\n", item);
    }
     
    // Function to remove an item from queue.  It changes front and size
    public int dequeue()
    {
        if (isEmpty())
            return Integer.MIN_VALUE;
        int item = this.array[this.front];
        this.front = (this.front + 1)%this.capacity;
        this.size = this.size - 1;
        return item;
    }
     
    // Function to get front of queue
    public int front()
    {
        if (isEmpty())
            return Integer.MIN_VALUE;
        return this.array[this.front];
    }
     
    // Function to get rear of queue
    int rear()
    {
        if (isEmpty())
        	 return Integer.MIN_VALUE;
        return this.array[this.rear];
    }
}
