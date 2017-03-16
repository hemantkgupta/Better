package advanced;

import java.util.Stack;

/**
 * Created by root on 19/12/15.
 */
public class SortStackUsingAnotherStack {
    public static void main(String[] args) {
        Stack<Integer> start = new Stack<>();
        start.push(4);
        start.push(1);
        start.push(5);
        start.push(2);
        start = sort(start);
        System.out.println(start.pop());
        System.out.println(start.pop());
        System.out.println(start.pop());
        System.out.println(start.pop());
     }

    public static Stack<Integer> sort(Stack<Integer> s) {
        Stack<Integer> r = new Stack<Integer>();
        while (!s.isEmpty()) {
            int tmp = s.pop(); // Step 1
            while (!r.isEmpty() && r.peek() > tmp) { // Step 2
                s.push(r.pop());
            }
            r.push(tmp); // Step 3
        }
        return r;
    }
}
