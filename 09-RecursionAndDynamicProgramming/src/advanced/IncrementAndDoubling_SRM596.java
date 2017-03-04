package advanced;

/**
 * Created by ghemant on 01/07/16.
 *
 *    You have an array with N elements. Initially, each element is 0. You can perform the following operations:
 *
 *    Increment operation: Choose one element of the array and increment the value by one.
 *    Doubling operation: Double the value of each element.
 *    You are given a int[] desiredArray containing N elements.
 *    Compute and return the smallest possible number of operations needed to change the array from all zeros to desiredArray.
 *
 *    Solution summary:
 *    result : (maximum length of the numbers in binary representation) -1 + (total number of '1' bits).
 *
 *    The number of 1 bits can be increased by at most 1 per increment operation.
 *    This happens when the original integer is even
 *    It follows that for a number that has x '1' bits, we need to do at least x increment operations.
 *    It is guaranteed to always do only x increment operations.
 *    In terms of recursion:
 *    For a number `y` of `n` bits, we first find the minimum number of moves needed to create the left-most `n-1` bits.
 *    Then we need 1 doubling operation to shift those bits left if number is even, and we add 1 if the number `y` is odd.
 *    The number of doubling operations equals the number of bits of the number minus 1
 *    because each doubling adds one bit in number and we starts with 1 bit that is 0
 *    so the answer is  (Maximum number of bits) - 1 + (number of '1' bits).
 *
 *
 */
public class IncrementAndDoubling_SRM596 {

    public static void main(String[] args) {
        int[] desiredArray = {2, 1};
        //System.out.println(Integer.toBinaryString(10));
        //System.out.println(getMin(desiredArray));
       // System.out.println(minop(1, 10));
        printOperation(10);

    }

    public static int getMin(int[] desiredArray)
    {
        int mx = 1;  // '0' has length of bits 1
        int sum = 0; // To hold total number of '1' bits
        for (int x: desiredArray) {
            int c = 0;
            // extract bits from x:
            while (x > 0) {
                c++;

                sum += x % 2; //the last bit
                x /= 2;
            }
            mx = Math.max(mx, c);
            // the number c of bits is wrong for '0', but it doesn't matter
            // because mx is initially set to 1.
        }
        return mx - 1 + sum;
    }

    public static int minop (int k, int n){
        if (k == n)
            return 0 ;
        if (k > n)
            return Integer.MAX_VALUE;
        return Math.min(minop(k+1, n), minop(2*k, n)) +1;
    }

    public static void printOperation(int x){
        if (x != 0){
            if (x%2==0){
                printOperation(x/2);
                System.out.println("Double");
            }else{
                printOperation(x-1);
                System.out.println("Increment");
            }
        }

    }





}
