import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;


public class StackSpanProblem {

	public static void main(String[] args) {
		int price[] = {10, 4, 5, 90, 120, 80};
		int[] S = new int[price.length];
		calculateSpan(price, price.length, S);
		
	}
	
	// A brute force method to calculate stock span values
	public static void calculateSpan(int price[], int n, int S[])
	{
	   // Create a stack and push index of first element to it
	   Deque<Integer> stack = new ArrayDeque<Integer>();
	   stack.push(0);
	 
	   // Span value of first element is always 1
	   S[0] = 1;
	 
	   for (int i = 1; i < n; i++)
	   {
	      // Pop elements from stack while stack is not empty and top of
	      // stack is smaller than price[i]
	      while (!stack.isEmpty() && price[stack.peek()] < price[i])
	         stack.pop();
	 
	      // If stack becomes empty, then price[i] is greater than all elements
	      // on left of it, i.e., price[0], price[1],..price[i-1].  Else price[i]
	      // is greater than elements after top of stack
	      S[i] = (stack.isEmpty())? (i + 1) : (i - stack.peek());
	 
	      // Push this element to stack
	      stack.push(i);
	   }
	   System.out.println(Arrays.toString(S));
	}

}
