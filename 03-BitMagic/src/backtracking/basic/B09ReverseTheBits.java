package backtracking.basic;

public class B09ReverseTheBits {

	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(12345));
		System.out.println(Integer.toBinaryString(reverseBits(12345)));
	}

	/**
	 * Get the set bit for all positions and
	 * put them in 31-position
	 * @param num
	 * @return
	 */
	public static int reverseBits(int num){

	    int reverse_num = 0, i, temp;
	 
	    for (i = 0; i < 32; i++)
	    {
			//Get the bit at i th position
			temp = (num & (1 << i));
			//Check if bit is set
	        if(temp != 0)
				//set the bit at 31-i th position
	            reverse_num |= (1 << (31 - i));
	    }
	  
	    return reverse_num;
	}

}
