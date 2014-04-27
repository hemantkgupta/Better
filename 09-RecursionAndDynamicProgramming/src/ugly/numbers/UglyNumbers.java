package ugly.numbers;

import java.util.Arrays;

public class UglyNumbers {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(getNthUglyNo(10)));
	}

	public static int[] getNthUglyNo(int n) {
		
		int powerOf2 = 0, powerOf3 = 0, powerOf5 = 0;
		int nextMulOf2 = 2, nextMulOf3 = 3, nextMulOf5 = 5;
		int nextUgly = 1;
		
		int[] ugly = new int[n];
		ugly[0] = 1;
		
		for (int i = 1; i < n; i++) {

			nextUgly = Math.min(nextMulOf2,
					Math.min(nextMulOf3, nextMulOf5));
			
			ugly[i] = nextUgly;

			if (nextUgly == nextMulOf2) {
				powerOf2 = powerOf2 + 1;
				nextMulOf2 = ugly[powerOf2] * 2;
			}
			if (nextUgly == nextMulOf3) {
				powerOf3 = powerOf3 + 1;
				nextMulOf3 = ugly[powerOf3] * 3;
			}
			if (nextUgly == nextMulOf5) {
				powerOf5 = powerOf5 + 1;
				nextMulOf5 = ugly[powerOf5] * 5;
			}
		}

		return ugly;
	}

}
