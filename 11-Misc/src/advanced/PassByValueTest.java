package advanced;

public class PassByValueTest {

	
	public static void main(String[] args) {
		String x = new String("ab");
		change(x);
		System.out.println(x);
		
		StringBuilder xb = new StringBuilder("ab");
		change(xb);
		System.out.println(xb);
		
		Apple apple = new Apple();
		System.out.println(apple.color);
 
		changeApple(apple);
		System.out.println(apple.color);
	}
	 
    // to confuse, use param name x in place of z	
	public static void change(String z) {
		z = "cd";
	}
	
	public static void change(StringBuilder xb) {
		xb.delete(0, 2).append("cd");
	}
	
	public static void changeApple(Apple apple){
		apple.color = "green";
	}
	
	
}

class Apple {
	public String color="red";
}

