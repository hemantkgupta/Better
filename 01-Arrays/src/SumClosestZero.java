import java.util.Arrays;

public class SumClosestZero {

	public static void main(String[] args) {
		int arr[] = { 1, 60, -10, 70, -80, 85 };
		minAbsSumPair(arr, arr.length);
		minAbsSumPairUsingSort(arr, arr.length);
	}

	public static void minAbsSumPairUsingSort(int arr[], int n) {
		int sum, minSum = Integer.MAX_VALUE;

		int l = 0, r = n - 1;
		int minleft = l, minright = n - 1;

		if (n < 2) {
			System.out.println("Invalid Input");
			return;
		}

		Arrays.sort(arr);

		while (l < r) {
			sum = arr[l] + arr[r];

			if (Math.abs(sum) < Math.abs(minSum)) {
				minSum = sum;
				minleft = l;
				minright = r;
			}
			if (sum < 0)
				l++;
			else
				r--;
		}

		System.out.println(" The two elements are:" + arr[minleft] + " and: "
				+ arr[minright]);
	}

	public static void minAbsSumPair(int arr[], int arr_size) {
		int l, r, minsum, sum, minleft, minright;

		if (arr_size < 2) {
			System.out.println(("Invalid Input"));
			return;
		}

		minleft = 0;
		minright = 1;
		minsum = arr[0] + arr[1];

		for (l = 0; l < arr_size - 1; l++) {
			for (r = l + 1; r < arr_size; r++) {
				sum = arr[l] + arr[r];
				if (Math.abs(minsum) > Math.abs(sum)) {
					minsum = sum;
					minleft = l;
					minright = r;
				}
			}
		}
		System.out.println(" The two elements are:" + arr[minleft] + " and: "
				+ arr[minright]);
	}

}
