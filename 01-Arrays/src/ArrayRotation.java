public class ArrayRotation {

	public static void main(String[] args) {
		int[] ar = { 1, 2, 3, 4, 5, 6, 7,8,9,10,11,12,13,14,15,16,17,18,19,20,21 };
		leftRotate(ar, 6);
		printArray(ar);
		/*rotateByThreeReverese(ar,2, ar.length);
		printArray(ar);
		leftRotateBlockRecur(ar, 2, ar.length);
		printArray(ar);*/
		 
	}

	
	public static int gcd(int a, int b) {		
		if (a%b==0)
			return b;
		return gcd(b, a%b);
	}	
	public static void leftRotate(int arr[], int d) {
		int i, j, k, temp;
		int n = arr.length;
		for (i = 0; i < gcd(d, n); i++) {
			temp = arr[i];
			j = i;
			while (true) {
				k = j + d;
				if (k >= n)
					k = k - n;
				if (k == i)
					break;
				arr[j] = arr[k];
				j = k;
			}
			arr[j] = temp;
		}
	}

	
	public static void rotateByThreeReverese(int arr[], int d, int n) {
		revereseArray(arr, 0, d - 1);
		revereseArray(arr, d, n - 1);
		revereseArray(arr, 0, n - 1);
	}

	public static void revereseArray(int arr[], int start, int end) {
		int temp;
		while (start < end) {
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	public static void leftRotateBlockRecur(int arr[], int d, int n) {
		if (d == 0 || d == n)		return;

		if (n - d == d) {
			swap(arr, 0, n - d, d);
			return;
		}

		/* If A is shorter */
		if (d < n - d) {
			swap(arr, 0, n - d, d);
			leftRotateBlockRecur(arr, d, n - d);
		} else 
		{
			swap(arr, 0, d, n - d);
			leftRotateBlockRecur(arr, 2 * d - n, d); /* This is tricky */
		}
	}

	public static void leftRotateBlockIter(int arr[], int d, int n) {
		int i, j;
		if (d == 0 || d == n)
			return;
		i = d;
		j = n - d;
		while (i != j) {
			if (i < j) /* A is shorter */
			{
				swap(arr, d - i, d + j - i, i);
				j -= i;
			} else 
			{
				swap(arr, d - i, d, j);
				i -= j;
			}
			
		}
		/* Finally, block swap A and B */
		swap(arr, d - i, d, i);
	}

	/* Swap d elements in arr from range fi to si */
	public static void swap(int arr[], int fi, int si, int d) {
		int i, temp;
		for (i = 0; i < d; i++) {
			temp = arr[fi + i];
			arr[fi + i] = arr[si + i];
			arr[si + i] = temp;
		}
	}

	public static void printArray(int[] arr) {
		System.out.println("");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" " + arr[i]);
		}

	}

}
