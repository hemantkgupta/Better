public class AllSubSets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RecSubsets("","abc");
	}

	public static void RecSubsets(String soFar, String rest) {
		if (rest.isEmpty())
			System.out.println(soFar);
		else {
			RecSubsets(soFar + rest.charAt(0), rest.substring(1)); // include first char
			RecSubsets(soFar, rest.substring(1)); // exclude first char
		}
	}

}
