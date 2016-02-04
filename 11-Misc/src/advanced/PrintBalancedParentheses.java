package advanced;

/**
 * Created by hemant on 22/10/15.
 */
public class PrintBalancedParentheses {

    public static void main(String[] args) {
            printParentheses(3,0,0,0, new char[6]);
    }

    public static void printParentheses(int total, int open, int close, int position, char[] result){
        if ( close == total-1){
            System.out.println(result);
            return;
        } else {
            if (open > close) {
                result[position] = '}';
                printParentheses(total, open, close + 1, position+1, result);
            }
            if (open < total) {
                result[position] = '{';
                printParentheses(total, open + 1, close, position+1 , result);
            }


        }

    }


}
