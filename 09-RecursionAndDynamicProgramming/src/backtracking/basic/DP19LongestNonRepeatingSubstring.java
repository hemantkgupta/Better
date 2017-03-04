package backtracking.basic;

/**
 * Created by root on 11/12/15.
 */
public class DP19LongestNonRepeatingSubstring {

    public static void main(String[] args) {
        System.out.println(longestUniqueSubsttr("abcsad".toCharArray()));
    }

    public static int longestUniqueSubsttr(char[] str)
    {
        int n = str.length;
        int currentLength = 1;  // lenght of current substring
        int maxLength = 1;  // result
        int previousIndex;  //  previous index
        int i;
        int[] visited = new int [256];

    /* Initialize the visited array as -1 to represent all are not visited yet. */
        for (i = 0; i < n;  i++)
            visited[i] = -1;

    /* Mark first character as visited by storing the index
       of first   character in visited array. */
        int pos = (int) str[0]  - 'a';
        visited[pos] = 0;

    /* Start from the second character. First character is
       already processed (currentLength and maxLength are initialized
       as 1, and visited[str[0]] is set */
        for (i = 1; i < n; i++)
        {
            previousIndex =  visited[(int) str[i]  - 'a'];

        /* If the current character is not present in the
           already processed substring or it is not part of
           the current NRCS, then do currentLength++ */
            if (previousIndex == -1 || i - currentLength > previousIndex)
                currentLength++;

        /* If the current character is present in currently
           considered NRCS, then update NRCS to start from
           the next character of previous instance. */
            else
            {
            /* Also, when we are changing the NRCS, we
               should also check whether length of the
               previous NRCS was greater than maxLength or
               not.*/
                if (currentLength > maxLength)
                    maxLength = currentLength;

                currentLength = i - previousIndex;
            }

            // update the index of current character
            visited[(int) str[i]  - 'a'] = i;
        }

        // Compare the length of last NRCS with maxLength and
        // update maxLength if needed
        if (currentLength > maxLength)
            maxLength = currentLength;

        return maxLength;
    }


}
