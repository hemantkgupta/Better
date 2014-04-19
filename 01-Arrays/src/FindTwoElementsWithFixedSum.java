import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindTwoElementsWithFixedSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = { 1, 4, 45, 6, 10, -8 };
		int n = 16;
		// System.out.println(hasArrayTwoCandidates(A,16));
		//printPairs(A, 16);
		System.out.println(Arrays.toString(twoSum(A,16)));

	}
	
	public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            int temp = target - numbers[i];
            if (map.containsKey(temp)) {
            	int index1 = i+1;
                int index2 =  map.get(temp)+1;
                if(index1 < index2){
                	result[0] = index1;
                	result[1] = index2;
                }else{
                	result[1] = index1;
                	result[0] = index2;
                }
                
            }
            map.put(numbers[i], i);
        }  
        return result;
    }

	public static boolean hasArrayTwoCandidates(int[] A, int sum) {

		Arrays.sort(A);
		int l = 0;
		int r = A.length - 1;
		while (l < r) {
			if (A[l] + A[r] == sum)
				return true;
			else if (A[l] + A[r] < sum)
				l++;
			else
				r--;
		}
		return false;
	}

	

}
