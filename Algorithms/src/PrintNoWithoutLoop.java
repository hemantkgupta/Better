
public class PrintNoWithoutLoop {
	public static void main(String[] args) {
		printNo(100);
	}
	public static void printNo(int num){
		if (num == 1){
			System.out.println(num);
			return;
		}		
		printNo(num-1);
		System.out.println(num);		
	}

}
