import java.util.Arrays;

public class InfixToPostfixTest {

	public static void main(String[] args) {
		char exp[] = "a+b*(c^d-e)^(f+g*h)-i".toCharArray();
		System.out.println(Arrays.toString(infixToPostfix(exp)));
	}
	public static char[] infixToPostfix(char[] exp) {

		// Create a stack of capacity equal to expression size
		ArrayStackChar stack = new ArrayStackChar(exp.length);
		
		// Good to create separate output array!
		char[] output = new char[exp.length];
		int k = -1;
		
		for (int i = 0; i < exp.length; i++) {
			
			if (isOperand(exp[i]))
				output[++k] = exp[i];
			else if (exp[i] == '(')
				stack.push(exp[i]);
			
			// If found ‘)’, pop and output until an ‘(‘ found in stack.
			else if (exp[i] == ')') {
				
				while (!stack.isEmpty() && stack.peek() != '(')
					output[++k] = stack.pop();
				
				if (!stack.isEmpty() && stack.peek() != '(')
					return new char[0]; // invalid expression
				else
					stack.pop();  // popped '('
				
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

	// A utility function to check if the given character is operand
	public static boolean isOperand(char ch) {
		return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
	}

	// A utility function to return precedence of a given operator
	// Higher returned value means higher precedence
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
