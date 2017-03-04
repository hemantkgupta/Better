package backtracking.basic;

class SAQ01StackUsingArray {
	int top;
	int capacity;
	char[] array;

	public SAQ01StackUsingArray(int capacity) {
		this.capacity = capacity;
		this.top = -1;
		this.array = new char[capacity];

	}

	public boolean isFull() {
		return this.top == this.capacity - 1;
	}

	public boolean isEmpty() {
		return this.top == -1;
	}

	public void push(char item) {
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
