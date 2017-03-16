package basic;

/**
 * Created by ghemant on 3/6/17.
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SAQ11BalancedBrackets {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }

    public static boolean isBalanced(String expression) {
        Deque<Character> stack = new ArrayDeque<>();
        boolean match = true;
        for (int i = 0; i < expression.length() ; i++) {
            char achar = expression.charAt(i);
            if (achar == '[' || achar == '{' || achar == '('){
                stack.push(achar);
            }else {
                if (stack.isEmpty()){
                    match = false;
                    break;
                } else {
                    char topchar = stack.peek();
                    if (achar == ']' && topchar == '['){
                        stack.pop();
                    } else if (achar == '}' && topchar == '{'){
                        stack.pop();
                    } else if (achar == ')' && topchar == '('){
                        stack.pop();
                    } else {
                        match = false;
                        break;
                    }
                }
            }
        }

        if (!stack.isEmpty()){
            match = false;
        }
        return match;
    }
}
