import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;


public class NullConcatenateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s= null;
		String y ="i";
		String z= s+y;
		System.out.println(z);
		
		/*try { 			
			File file = new File ("fileWrite1.txt");
			System.out.println(file.exists()); // look for a real file so false
			boolean newFile = file.createNewFile(); // if creation occurs - true
			System.out.println(file.exists()); // look again
			} catch(IOException e) { }*/
		
		try {
			File file = new File("fileWrite2.txt"); // just an object		
			FileWriter fw =	new FileWriter(file); // create an actual file & a FileWriter obj
			fw.write("howdy\nfolks\n"); // write characters to the file
			fw.flush(); // flush before closing
			fw.close(); // close file when done
		
			FileReader fr =		new FileReader(file); // create a FileReader object
			char[] in = new char[1024];
			int size = fr.read(in ); // read the whole file!
			System.out.print(size + " "); // how many bytes read
			for(char c : in) // print the array
				System.out.print(c);
			fr.close(); // again, always close
			} catch(IOException e) { }
		}

	

}
