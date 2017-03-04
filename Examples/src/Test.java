import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by ghemant on 3/2/17.
 */
public class Test {


    static int[]  input2 = {10,20,10};
    static int[] input3 = {10,20,11};
    static int size = 3;
    public static void main(String[] args) {
        //System.out.println(test(20, 0));

    }

    public static  int  test(int input4, int index){
        String prefix= "    ";
        for (int i = -1; i < index ; i++) {
            prefix +="    ";
        }
        System.out.println(prefix+"Working for input4 : "+ input4 + " and index : "+ index);
        if(index == size || input4 <= 0){
            System.out.println(prefix+"Returning 0");
            return 0;
        }
        int val1 = input3[index] +  test(input4-input2[index], index+1);
        int val2 = test(input4, index+1);
        int max = Math.max(val1, val2);
        System.out.println(prefix+"Worked for input4 : "+ input4 + " and index : "+ index + " the return is : "+ max);
        return  max;

    }

    public static  int  test2(int input4, int index){
        if(index == size)
            return 0;
        return  Math.max(input3[index]+test(input4-input2[index], index+1), test(input4, index+1));
    }
}
