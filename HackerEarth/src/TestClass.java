import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * Created by ghemant on 10/16/16.
 */
public class TestClass {

    public static void main(String args[] ) throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String line = br.readLine();
        //int N = Integer.parseInt(line);
        //String line2 = br.readLine();
        //System.out.println(2*N);
        //System.out.println(line2);
        System.out.println(toggleCase("testA"));
    }
    private static String toggleCase(String line){
        String output = "";
        for(int i=0; i< line.length(); i++){
            Character currentChar = line.charAt(i);
            if(Character.isUpperCase(currentChar)){
                Character currentCharinLower = Character.toLowerCase(currentChar);
                output = output + currentCharinLower;
            }else{
                Character currentCharinUpper = Character.toUpperCase(currentChar);
                output = output + currentCharinUpper;
            }
        }
        return output;

    }
}
