import java.util.Arrays;

public class InfixToPostfixTest {

	public static void main(String[] args) {
		char exp[] = "a+b*(c^d-e)^(f+g*h)-i".toCharArray();
		System.out.println(Arrays.toString(infixToPostfix(exp)));
	}

	public static char[] infixToPostfix(char[] exp) {

		ArrayStackChar stack = new ArrayStackChar(exp.length);
		char[] output = new char[exp.length];
		int k = -1;

		for (int i = 0; i < exp.length; i++) {

			if (isOperand(exp[i]))
				output[++k] = exp[i];
			else if (exp[i] == '(')
				stack.push(exp[i]);

			else if (exp[i] == ')') {

				while (!stack.isEmpty() && stack.peek() != '(')
					output[++k] = stack.pop();

				if (!stack.isEmpty() && stack.peek() != '(')
					return new char[0]; // invalid expression
				else
					stack.pop(); // popped '('

			} else // an operator is encountered
			{
				while (!stack.isEmpty()
						&& (precedence(exp[i]) <= precedence(stack.peek())))
					output[++k] = stack.pop();
				stack.push(exp[i]);
			}

		}
		// pop all the operators from the stack
		while (!stack.isEmpty())
			output[++k] = stack.pop();

		return output;
	}

	public static boolean isOperand(char ch) {
		return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
	}

	public static int precedence(char ch) {
		switch (ch) {
		case '+':
		case '-':
			return 1;

		case '*':
		case '/':
			return 2;

		case '^':
			return 3;
		}
		return -1;
	}
}
