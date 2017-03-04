package backtracking.basic;

import java.util.Stack;

/**
 * Created by root on 19/12/15.
 */
public class SAQ10StackWithMin {
    public static void main(String[] args) {

        StackWithMin testStack = new StackWithMin();
        testStack.push(4);
        testStack.push(5);
        testStack.push(3);
        System.out.println(testStack.min());
        System.out.println(testStack.pop());
        System.out.println(testStack.min());
        System.out.println(testStack.peek());

    }

    static class StackWithMin extends Stack<Integer>{
        Stack<Integer> s2;
        public StackWithMin(){
            s2 = new Stack<Integer>();
        }
        public void push(int value){
            if(value <= min()){
                s2.push(value);
            }
            super.push(value);
        }
        public Integer pop(){
            int value = super.pop();
            if(value ==  min()){
                s2.pop();
            }
            return value;
        }

        public Integer min(){
            if(s2.isEmpty())
                return Integer.MAX_VALUE;
            else
                return s2.peek();
        }
    }
}
