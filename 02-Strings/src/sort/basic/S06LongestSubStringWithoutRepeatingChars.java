package sort.basic;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hemant on 16/10/15.
 */
public class S06LongestSubStringWithoutRepeatingChars {

    public static void main(String[] args) {
        System.out.println(getNonrepeatingSubstring("abccccdesftcsdsesr"));
    }

    public static int getNonrepeatingSubstring(String str){
        char[] string = str.toCharArray();
        Map<Character, Integer> charIndexMap = new HashMap<Character, Integer>();
        int maxLen = 1;
        int currLen = 1;
        int startIndex = 0;
        charIndexMap.put(str.charAt(0), 0);
        for (int i = 1; i < string.length; i++) {
            char c = str.charAt(i);
            if(charIndexMap.containsKey(c)){
                int prevIndex = charIndexMap.get(c);
                if (prevIndex >= startIndex){
                    //Update new start index
                    startIndex = prevIndex+1;
                    // update new length
                    currLen = i-startIndex+1;
                    // put in new position
                    charIndexMap.put(c, i);
                }else{
                    currLen++;
                    charIndexMap.put(c, i);
                }
            }else{
                currLen++;
                charIndexMap.put(c, i);
            }
            if (maxLen < currLen ){
                maxLen = currLen;
            }
        }
        return maxLen;
    }

}
