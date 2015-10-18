package sort.basic;

public class B009ReverseTheBits {

	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(12345));
		System.out.println(Integer.toBinaryString(reverseBits(12345)));
	}
	
	public static int reverseBits(int num){

	    int reverse_num = 0, i, temp;
	 
	    for (i = 0; i < 32; i++)
	    {
	        temp = (num & (1 << i)); // get bit at i
	        if(temp != 0)
	            reverse_num |= (1 << (31 - i)); // put at 31-i
	    }
	  
	    return reverse_num;
}

}
