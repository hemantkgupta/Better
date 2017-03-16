package basic;

class SAQ01StackUsingArray {

	public static void main(String[] args) {
        SAQ01StackUsingArray stack = new SAQ01StackUsingArray(5);
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
	}

	int top;
	int capacity;
	int[] array;

	public SAQ01StackUsingArray(int capacity) {
		this.capacity = capacity;
		this.top = -1;
		this.array = new int[capacity];

	}

	public boolean isFull() {
		return this.top == this.capacity - 1;
	}

	public boolean isEmpty() {
		return this.top == -1;
	}

	public void push(int item) {
		if (isFull())
			return;
		this.array[++this.top] = item;
	}

	public int pop() {
		if (isEmpty())
			return Integer.MIN_VALUE;
		return this.array[this.top--];
	}

	public int peek() {
		if (isEmpty())
			return Integer.MIN_VALUE;
		return this.array[this.top];
	}
}
