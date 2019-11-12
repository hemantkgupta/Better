package basic;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The program finds the size of longest possible substring
 * containing non-repeating characters from a string
 * Created by hemant on 16/10/15.
 */
public class STRB07LongestSubStringWithoutRepeatingChars {

    public static void main(String[] args) {
        //System.out.println(getNonrepeatingSubstring("abccccdesftcsdsesr"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        //System.out.println(lengthOfLongestSubstring("bbbbbb"));
       // System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int startIndex = 0;
        int currentLength = 0;
        int maxLength = 0;
        LinkedHashMap<Character, Integer> charIndexMap = new LinkedHashMap<>();
        for (int i=0; i < s.length(); i ++){
            Character c = s.charAt(i);
            if (!charIndexMap.containsKey(c)){
                currentLength++;
                if (maxLength < currentLength)
                    maxLength = currentLength;
                charIndexMap.put(c, i);
            }else{
                int duplicateIndex = charIndexMap.get(c);
                System.out.println("duplicate index "+ duplicateIndex);
                for (int j = startIndex; j <= duplicateIndex ; j++) {
                    charIndexMap.remove(s.charAt(j));
                }
                startIndex = duplicateIndex + 1;
                System.out.println("after removal start index is "+ startIndex);
                charIndexMap.put(c, i);
                currentLength = i - startIndex + 1;
                System.out.println(" the current length is "+ currentLength);
            }
        }
        return maxLength;
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

                // Test if current char is present in substring
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
