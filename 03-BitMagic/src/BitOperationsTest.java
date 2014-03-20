

public class BitOperationsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int a = 60;	/* 60 = 0011 1100 */  
	    int b = 13;	/* 13 = 0000 1101 */
	    System.out.println("60 in binary is "+Integer.toBinaryString(60)); 
	    System.out.println("13 in binary is "+Integer.toBinaryString(13)); 
	    
		System.out.println("60 & 13 is "+(60 & 13)+" in binary "+Integer.toBinaryString((60 & 13)));
		System.out.println("60 | 13 is "+(60 | 13)+" in binary "+Integer.toBinaryString((60 | 13)));
		
		System.out.println("13 >> 2 is "+(13 >> 2)+" in binary "+Integer.toBinaryString((13 >> 2)));
		System.out.println("13 << 2 is "+(13 << 2)+" in binary "+Integer.toBinaryString((13 << 2)));
		
		System.out.println("-60 in binary is "+Integer.toBinaryString(-60)); 
		System.out.println("-60 >>> 2 is "+(-60 >>> 2)+" in binary "+Integer.toBinaryString((-60 >>> 2)));
		
	    

	}

}
