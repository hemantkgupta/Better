import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class LuckyNumber {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        List<Integer> src = new ArrayList<Integer>();
        Scanner s = null;
        List<HashSet<Integer>> luckdigits = new ArrayList<HashSet<Integer>>();
        
        for (int i = 0; i < N; i++) {
        	 line = br.readLine();
        	 HashSet<Integer> digits = new HashSet<Integer>();
        	 s = new Scanner(line);
             while(s.hasNext()){
            	 digits.add(s.nextInt());
             }
             luckdigits.add(digits);
             line = br.readLine();
             src.add(Integer.parseInt(line));
		}
        s.close();
        List<String> results = getResults(luckdigits,src);
       for (String string : results) {
		System.out.println(string);
	}
	}
	
	public static List<String> getResults(List<HashSet<Integer>> luckdigits, List<Integer> src ){
		List<String> results = new ArrayList<String>();
		for (int i = 0; i < src.size(); i++) {
			HashSet<Integer> digits = luckdigits.get(i);
			int start = src.get(i);
			if(digits.size() == 1 && digits.contains(0)){
				results.add(i, "Impossible");
				break;
			}	
			if (start% 10 == 5 && !digits.contains(5)){
				results.add(i, "Impossible");
				break;
			}
			results.add(testLucky(digits,start));
		}
		return results;
	}	
		public static String testLucky(HashSet<Integer> digits, int start){
			int temp = start;
			Set<Integer> check = getSetFromNumber (start);
			int i = 1 ;
			while(!digits.containsAll(check)){
				i++;
				start = start*i;
				check = getSetFromNumber (start);
			}	
			return 	temp + "*" + i;
			
		}
		
		public static HashSet<Integer> getSetFromNumber(int number){
			HashSet<Integer> setNumber = new HashSet<Integer>();
			while (number > 0){
				setNumber.add(number%10);
				number = number/10;
			}	
			return setNumber;
			
		}
			
	
	}


