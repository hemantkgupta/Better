package basic;

/**
 * Created by root on 19/12/15.
 */
public class S00UniqueCharactersTest {

    public static void main(String[] args) {
        System.out.println(isUniqueCharacters("a"));
    }

    /**
     * Test if a give string has unique characters only
     * from the set of 256 characters
     * @param str
     * @return
     */
    public static boolean isUniqueCharacters(String str){
        if (str.length() == 0)
            return true;
        if (str.length() > 256)
            return false;
        boolean[] chars = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) -'a';
            if (chars[val])
                return false;
            else
                chars[val] = true;
        }
        return true;
    }
}
