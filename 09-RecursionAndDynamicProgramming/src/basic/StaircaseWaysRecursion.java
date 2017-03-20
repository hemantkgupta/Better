package basic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ghemant on 3/7/17.
 */
public class StaircaseWaysRecursion {

    static List<Integer> values = new ArrayList<>();
    public static void main(String[] args) {
        values.add(0, 0);
        values.add(1, 1);
        values.add(2, 2);
        values.add(3, 4);
        System.out.println(staircaseWaysTabulation(7));
    }

    public static int staircaseWays(int total){
        if (total == 0)
            return 0;
        if (total == 1)
            return 1;
        if (total == 2)
            return 2;
        if (total == 3)
            return 4;

        return staircaseWays(total-1) + staircaseWays(total-2) +  staircaseWays(total-3);

    }

    public static int staircaseWaysTabulation(int total){
        System.out.println("the total is "+ total);
        if (values.size() > total){
            return values.get(total);
        }
        values.add(total-3, staircaseWaysTabulation(total-3));
        values.add(total-2, staircaseWaysTabulation(total-2));
        values.add(total-1, staircaseWaysTabulation(total-1));
        int val = values.get(total-3)+ values.get(total-2)+ values.get(total-1);
        System.out.println("the value for total "+ total + " is : "+val);
        values.add(total, val);
        return val;

    }
}
