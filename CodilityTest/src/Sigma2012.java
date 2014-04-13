import java.util.ArrayDeque;
import java.util.Deque;

public class Sigma2012 {

	public static void main(String[] args) {
		int[] H = { 8, 8, 5, 7, 9, 8, 7, 4, 8 };
		System.out.println(solution1(H));
	}

	public static int solution1(int[] H) {
		Deque<Integer> stack = new ArrayDeque<Integer>();
		int blocks = 0;
		for (int i : H) {
			while (!stack.isEmpty() && stack.peek() > i) {
				stack.pop();
				blocks++;
			}
			if (stack.isEmpty() || stack.peek() < i) {
				stack.push(i);
			}
		}
		return blocks + stack.size();
	}

	public static int solution(int[] data) {
		int[] stack = new int[data.length];
		int stack_num = 0;
		int stones = 0;
		for (int i : data) {
			System.out.println("start loop for i: " + i);
			System.out.println("start stack_num: " + stack_num);
			while (stack_num > 0 && stack[stack_num - 1] > i) {
				stack_num -= 1;
			}
			if (!(stack_num > 0 && stack[stack_num - 1] == i)) {
				System.out.println("inside if i: " + i);
				System.out.println("inside if stack_num: " + stack_num);
				stack[stack_num] = i;
				stones++;
				stack_num++;
			}
		}
		return stones;
	}

}