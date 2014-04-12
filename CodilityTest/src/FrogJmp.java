
public class FrogJmp {

	public static void main(String[] args) {
		System.out.println(solution(10, 85, 30));
	}
	
	public static int solution(int X, int Y, int D) {
		if(X==Y){
			return 0;
		}
		double range = Y-X;
		double d = D;
		return (int) Math.ceil(range/d);
		
	       
    }

}
