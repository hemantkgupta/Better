package advanced;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

import static advanced.ChangingSounds_SRM366.print2DArray;

/**
 * Created by ghemant on 01/07/16.
 */
public class ChangingSounds_SRM366 {

    public static int max=0;
    public static void main(String[] args) {
        int[] intervals = {3, 5};
        //getMaxVolume(3, intervals, 0);
        //System.out.println(max);
        System.out.println(getMax2(4, intervals, 0));
       // System.out.println(maxFinal(intervals, 5, 10));
       // System.out.println(maxFinal(intervals, 5, 10));

    }

    public static int maxFinal(int[] changeIntervals, int beginLevel, int maxLevel) {
        boolean[][] canHave = new boolean[changeIntervals.length+1][maxLevel+1];
        for(int i = 0; i <= changeIntervals.length; i++)
            Arrays.fill(canHave[i], false);

        canHave[0][beginLevel] = true;
        for(int i = 0; i < changeIntervals.length; i++) {
            for(int j = 0; j <= maxLevel; j++) {
                if(canHave[i][j]) {
                    if(j + changeIntervals[i] <= maxLevel)
                        canHave[i+1][j + changeIntervals[i]] = true;
                    if(j - changeIntervals[i] >= 0)
                        canHave[i+1][j - changeIntervals[i]] = true;
                }
            }
        }

        int max = -1;
        for(int j = 0; j <= maxLevel; j++)
            if(canHave[changeIntervals.length][j])
                max = j;
        print2DArray(canHave);
        return max;
    }

    public static void print2DArray(boolean[][] ar){
        for (int i = 0; i <ar.length ; i++) {
            System.out.println("");
            for (int j = 0; j <ar[i].length ; j++) {
                System.out.print(ar[i][j]+" ");
            }
        }
    }

    public static void getMaxVolume(int currentValue, int[] changeIntervals,  int index){
        if (index < changeIntervals.length){
           if ((currentValue + changeIntervals[index]) <= 10 ){
               System.out.println("In plus for index "+ index + " value "+ ( currentValue + changeIntervals[index]) );
               getMaxVolume(currentValue + changeIntervals[index],changeIntervals, index+1 );
           }
           if ((currentValue - changeIntervals[index]) > 0){
               System.out.println("In minus for index "+ index + " value "+ (currentValue - changeIntervals[index]) );
               getMaxVolume(currentValue - changeIntervals[index],changeIntervals, index+1 );
           }
        } else {
            System.out.println("the current value is "+ currentValue);
            max = Math.max(max, currentValue);
        }
    }

    public static int getMax2 (int currentValue, int[] changeIntervals,  int index){
        System.out.println("working for current value:"+ currentValue+ " and index "+index);
        if (index == changeIntervals.length-1){
            if(currentValue + changeIntervals[index] <=10 )
                return currentValue + changeIntervals[index];
            else if (currentValue - changeIntervals[index] > 0) {
                return currentValue - changeIntervals[index];
            }
        }
        int a=0, b=0;
        if (currentValue + changeIntervals[index] <=10 ){
            a = getMax2(currentValue + changeIntervals[index], changeIntervals, index+1 );
        }
        if (currentValue - changeIntervals[index] > 0){
            b = getMax2(currentValue - changeIntervals[index], changeIntervals, index+1 );
        }
        return Math.max(a, b);

    }

}
