package sort.basic;

public class B013GetAbsWithoutBranching {

	public static void main(String[] args) {
		System.out.println(getAbs(-7));
		System.out.println(getAbs(7));

	}

	public static int getAbs(int n) {
		int mask = n >> 31;
		return ((n + mask) ^ mask);
	}
}
