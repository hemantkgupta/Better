import java.util.ArrayList;
import java.util.List;

public class FindWordInDictionary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> dict = new ArrayList<String>();
		dict.add("Go");
		dict.add("Goa");
		dict.add("Gone");
		dict.add("Ho");
		dict.add("cnu");
		dict.add("ceiocine");
		dict.add("einj");
		System.out.println(FindWord("", "ceiocine", dict));
	}

	public static String FindWord(String soFar, String rest, List<String> lex) {
		if (rest.isEmpty()) {
			return (lex.contains(soFar) ? soFar : "");
		} else {
			for (int i = 0; i < rest.length(); i++) {
				String remain = rest.substring(0, i) + rest.substring(i + 1);
				String found = FindWord(soFar + rest.charAt(0), remain, lex);
				if (!found.isEmpty())
					return found;
			}
		}
		return ""; // empty string indicates failure
	}

}
