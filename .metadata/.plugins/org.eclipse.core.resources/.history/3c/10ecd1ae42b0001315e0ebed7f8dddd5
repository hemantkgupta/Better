

public class BitUtility {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getBit(15, 3));
		System.out.println(setBit(15, 0));
		System.out.println(clearBit(15, 0));
		System.out.println(clearBitsMSBthroughI(15, 3));
		System.out.println(clearBitsIthrough0(15, 3));
		System.out.println(updateBit(64, 0, 1));
	}
	
	public static boolean getBit(int num, int i) {
		 return ((num & (1<< i)) != 0);
		 }
	public static int setBit(int num, int i) {
		 return num | (1 << i);
		 }
	
	public static int clearBit(int num, int i) {
		 int mask = ~(1 << i);
		 System.out.println("Mask is : "+Integer.toBinaryString(mask));
	 return num & mask;
		 }
	
	public static int clearBitsMSBthroughI(int num, int i) {
		 int mask = (1 << i) - 1;
		 System.out.println("Mask is : "+Integer.toBinaryString(mask));
		 return num & mask;
		 }
	
	public static int clearBitsIthrough0(int num, int i) {
		 int mask = ~((1 << (i+1)) - 1);
		 return num & mask;
		 }
	
	public static int updateBit(int num, int i, int v) {
		 int mask = ~(1<< i);
		 return (num & mask) | (v << i);
		 }
	

}
