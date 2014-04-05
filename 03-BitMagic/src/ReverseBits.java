
public class ReverseBits {

	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(12345));
		System.out.println(Integer.toBinaryString(reverseBits(12345)));
	}
	
	public static int reverseBits(int num){
	    int  NO_OF_BITS = 32;
	    int reverse_num = 0, i, temp;
	 
	    for (i = 0; i < NO_OF_BITS; i++)
	    {
	        temp = (num & (1 << i));
	        if(temp != 0)
	            reverse_num |= (1 << ((NO_OF_BITS - 1) - i));
	    }
	  
	    return reverse_num;
}

}