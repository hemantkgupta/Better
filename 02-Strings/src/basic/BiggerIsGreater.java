package basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by ghemant on 3/10/17.
 */
public class BiggerIsGreater {
    public static void main(String[] args) {

    }
    public static String getNextPermutaions(String input){
        String result = "no answer";
        if(input.length() ==1)
            return result;
        char[] charsInput = input.toCharArray();
        Map<Character, List<Integer>> mapToIndexes = new TreeMap<>();
        for (int i = 0; i <input.length() ; i++) {
            if(mapToIndexes.containsKey(charsInput[i])){
                mapToIndexes.get(charsInput[i]).add(i);
            } else{
                List<Integer> listOfIndexes  = new ArrayList<>();
                listOfIndexes.add(i);
                mapToIndexes.put(charsInput[i], listOfIndexes);
            }
        }
        return "";
    }
}
