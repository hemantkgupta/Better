package advanced;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by ghemant on 3/3/17.
 *
 * Given an array of integers, sort the array into a wave like array and return it,
 * In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....
 *
 *
 */
public class WaveArray {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(6);
        input.add(12);
        input.add(9);
        input.add(1);
        input.add(2);
        input.add(7);
        System.out.println(wave(input));
    }

    public static ArrayList<Integer> wave(ArrayList<Integer> a) {

        if (a.size() == 1)
            return a;

        Collections.sort(a);

        ArrayList<Integer> result = new ArrayList<>();

        int mid = a.size()/2;

        // Swap pairwise
        int index = 0;
        for(int i =1; i <= mid; i++){
            result.add (index, a.get(index+1));
            result.add (index+1, a.get(index));
            index +=2;
        }

        if (a.size()%2 == 1)
            result.add(a.get(a.size()-1));

        return result;
    }
}
