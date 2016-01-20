package adv;

public class ReArrangeLettersString {

	/**
	 * @param args
	 */
	private static int count = 0; 
	public static void main(String[] args) {
		System.out.println("output is : ");
		RecPermute("", "abc");
	}

	public static void RecPermute(String soFar, String rest) {
		String space = "";
		for(int j=0;j< count; j++){
			space = space +"  ";
		}
		if (rest.isEmpty()) {
			System.out.println(space+soFar);			
		}
		else {
			count++; 
			String tillNow = new String(space);
			System.out.println(space+"For soFar:"+soFar+": and rest:"+rest+":");
			for (int i = 0; i < rest.length(); i++) {
				String remaining = rest.substring(0, i) + rest.substring(i + 1);
				RecPermute(soFar + rest.charAt(i), remaining);
			}
			System.out.println(tillNow+"For soFar:"+soFar+": and rest:"+rest+": is done");
			count--;
		}
	}	
	

}
