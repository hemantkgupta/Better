package advanced;

import java.util.*;


public class Longest_Prefix_Match_String_Trie_Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 Trie dict = new Trie();
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            for(int a0 = 0; a0 < n; a0++){
                String op = in.next();
                String contact = in.next();
                if (op.equalsIgnoreCase("add")){
                    dict.insert(contact);
                } else if (op.equalsIgnoreCase("find")) {
                    System.out.println(dict.findPartial(contact));
                }
            }



	        /*dict.insert("are");
            dict.insert("base");
            dict.insert("area");
            dict.insert("areb");
            dict.insert("areas");
	        dict.insert("cat");
	        dict.insert("cater");
	        dict.insert("basement");

	        String input = "caterer";
	        System.out.print(input + ":   ");
	        System.out.println(dict.getMatchingPrefix(input));

	        input = "basement";
	        System.out.print(input + ":   ");
	        System.out.println(dict.getMatchingPrefix(input));

	        input = "are";
	        System.out.print(input + ":   ");
	        System.out.println(dict.getMatchingPrefix(input));

	        input = "arex";
	        System.out.print(input + ":   ");
	        System.out.println(dict.getMatchingPrefix(input));

	        input = "basemexz";
	        System.out.print(input + ":   ");
	        System.out.println(dict.getMatchingPrefix(input));

	        input = "xyz";
	        System.out.print(input + ":   ");
	        System.out.println(dict.getMatchingPrefix(input));

            //dict.printAllPaths();
            //System.out.println(dict);
            dict.findPartial("are");*/
    }


	}



class Trie {
    // Constructor
    public Trie()   {     this.root = new TrieNode((char)0);       }

    public int findPartial(String input){
        String result = ""; // Initialize resultant string
        int length = input.length();  // Find length of the input string
        TrieNode crawl = this.root;
        boolean found = true;
        for( int level = 0 ; level < length; level++ ) {
            // Find current character of str
            char ch = input.charAt(level);

            // HashMap of current advanced.Trie node to traverse down
            HashMap<Character, TrieNode> child = crawl.getChildren();

            // See if there is a advanced.Trie edge for the current character
            if (child.containsKey(ch)) {
                crawl = child.get(ch);
            } else {
                //System.out.println("The charcter match failed at "+ ch);
                found = false;
                break;
            }
        }

        //System.out.println("the matches are "+ crawl.getChildren().size());
       /* for (Map.Entry<Character, TrieNode> child : crawl.getChildren().entrySet()) {
            System.out.println("The child starts at "+ child.getKey());
            StringBuilder path = new StringBuilder();
            path.append(child.getKey());
            printPath(child.getValue(), path);
        }*/
        if (!found){
            return 0;
        }
        return countChildren(crawl);

    }

    private int countChildren(TrieNode root){
        int count = 0;
        Queue<TrieNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TrieNode current = queue.poll();
            if( current.isEnd()){
                count++;
            }
            for (Map.Entry<Character, TrieNode> child : current.getChildren().entrySet()) {
                queue.add(child.getValue());
            }
        }
        return count;
    }

    // Method to insert a new word to advanced.Trie
    public void insert(String word)  {

        // Find length of the given word
        int length = word.length();
        TrieNode crawl = this.root;

        // Traverse through all characters of given word
        for( int level = 0; level < length; level++)
        {
            char ch = word.charAt(level);
            HashMap<Character,TrieNode> child = crawl.getChildren();

            // If there is already a child for current character of given word
            if( child.containsKey(ch))
                crawl = child.get(ch);
            else   // Else create a child
            {
                TrieNode temp = new TrieNode(ch);
                child.put( ch, temp );
                crawl = temp;
            }
        }

        // Set bIsEnd true for last character
        crawl.setIsEnd(true);
    }

    // The main method that finds out the longest string 'input'
    public String getMatchingPrefix(String input)  {
        String result = ""; // Initialize resultant string
        int length = input.length();  // Find length of the input string

        // Initialize reference to traverse through advanced.Trie
        TrieNode crawl = root;

        // Iterate through all characters of input string 'str' and traverse
        // down the advanced.Trie
        int level, prevMatch = 0;
        for( level = 0 ; level < length; level++ )
        {
            // Find current character of str
            char ch = input.charAt(level);

            // HashMap of current advanced.Trie node to traverse down
            HashMap<Character,TrieNode> child = crawl.getChildren();

            // See if there is a advanced.Trie edge for the current character
            if( child.containsKey(ch) )
            {
               result += ch;          //Update result
               crawl = child.get(ch); //Update crawl to move down in advanced.Trie

               // If this is end of a word, then update prevMatch
               if( crawl.isEnd() )
                    prevMatch = level + 1;
            }
            else  break;
        }

        // If the last processed character did not match end of a word,
        // return the previously matching prefix
        if( !crawl.isEnd() )
                return result.substring(0, prevMatch);

        else return result;
    }

    public void printAllPaths(){
        TrieNode root = this.root;
        for (Map.Entry<Character, TrieNode> child : root.getChildren().entrySet()) {
            //System.out.println("The child starts at "+ child.getKey());
            StringBuilder path = new StringBuilder();
            path.append(child.getKey());
            printPath(child.getValue(), path);
        }

    }
    private void printPath(TrieNode node, StringBuilder path){

        if (node.getChildren().isEmpty()){
            System.out.println(path);
            return;
        } else {
            if(node.isEnd()){
                System.out.println(path);
            }
            for (Map.Entry<Character, TrieNode> child : node.getChildren().entrySet()) {
                path.append(child.getKey());
                printPath(child.getValue(), path);
            }
        }


    }
    private TrieNode root;

    @Override
    public String toString() {
        return "Trie{" +
                "root=" + root +
                '}';
    }

    static class TrieNode {
        public TrieNode(char ch)  {
            value = ch;
            // Good to have empty collection in place of null
            children = new HashMap<>();
            bIsEnd = false;
        }
        public HashMap<Character,TrieNode> getChildren() {   return children;  }
        public char getValue()                           {   return value;     }
        public void setIsEnd(boolean val)                {   bIsEnd = val;     }
        public boolean isEnd()                           {   return bIsEnd;    }

        private char value;
        private HashMap<Character,TrieNode> children;
        private boolean bIsEnd;

        @Override
        public String toString() {
            return "TrieNode{" +
                    "children=" + children +
                    ", bIsEnd=" + bIsEnd +
                    ", value=" + value +
                    '}';
        }
    }

}
