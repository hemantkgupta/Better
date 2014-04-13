
public class EuclideanExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int gcd(int a, int b){
		if (a%b==0)
			return b;
		return gcd(b, a%b);
	}

}
