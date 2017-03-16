package basic;

import java.util.ArrayDeque;
import java.util.Deque;

public class SAQ06ReverseStackByRecursion {

	public static void main(String[] args) {
		Deque<Integer> stack = new ArrayDeque<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		reverse(stack);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

	}

	public static void reverse(Deque<Integer> stack) {
		int temp;
		if (!stack.isEmpty()) {
			temp = stack.pop();
			reverse(stack);
			stack.push(temp);
		}
	}

}
