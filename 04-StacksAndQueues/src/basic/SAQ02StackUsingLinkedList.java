package basic;

public class SAQ02StackUsingLinkedList {

    public static void main(String[] args) {

        StackUsingLL stack = new StackUsingLL();
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());

    }

	static class StackUsingLL {

        public StackNode top;

        public void push(int item) {
            StackNode node = new StackNode(item);
            if (this.top == null) {
                this.top = node;
                return;
            }
            node.next = this.top;
            this.top = node;
        }

        public int pop() {
            if (this.top == null)
                return Integer.MIN_VALUE;

            int key = this.top.key;
            this.top = this.top.next;
            return key;
        }

        public int peek() {
            if (this.top == null)
                return Integer.MIN_VALUE;

            return this.top.key;
        }

        public boolean isEmpty() {
            return this.top == null;
        }

        static class StackNode {
            int key;
            StackNode next;

            public StackNode(int data) {
                this.key = data;
                this.next = null;
            }
        }

	}

}
