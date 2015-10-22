package sort.advanced;

public class A002MajorityElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 1, 3, 3, 3, 2, 4, 3 };
		printMajority(a);
	}

	public static void printMajority(int[] a) {
		int cand = findCandidate(a);
		if (isMajority(a, cand))
			System.out.println(cand);
		else
			System.out.println("NO Majority Element");
	}
	public static int findCandidate(int[] a) {
		int majorityIndex = 0, count = 1;
		for (int i = 1; i < a.length; i++) {
			if (a[majorityIndex] == a[i]) {
				count++;
			} else {
				count--;
			}
			if (count == 0) {
				majorityIndex = i;
				count = 1;
			}
		}
		return a[majorityIndex];
	}	
	public static boolean isMajority(int a[], int cand) {
		int i, count = 0;
		int size = a.length;
		for (i = 0; i < size ; i++)
			if (a[i] == cand)
				count++;
		if (count > size / 2)
			return true;
		else
			return false;
	}

}