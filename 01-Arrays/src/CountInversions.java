public class CountInversions {

	public static void main(String[] args) {
		int[] ar = { 2, 3, 5, 4, 9, 8, 7, 6, 0 };
		System.out.println(getInvCount(ar, ar.length));
		int[] aux = new int[9];
		System.out.println(_mergeSort(ar, aux, 0, 8));

	}

	public static int getInvCount(int arr[], int n) {
		int inv_count = 0;
		int i, j;

		for (i = 0; i < n - 1; i++)
			for (j = i + 1; j < n; j++)
				if (arr[i] > arr[j])
					inv_count++;

		return inv_count;
	}

	public static int _mergeSort(int arr[], int temp[], int left, int right) {
		int mid, inv_count = 0;

		if (right > left) {
			mid = (right + left) / 2;

			inv_count = _mergeSort(arr, temp, left, mid);
			inv_count += _mergeSort(arr, temp, mid + 1, right);

			inv_count += merge(arr, temp, left, mid + 1, right);
		}
		return inv_count;
	}

	public static int merge(int arr[], int temp[], int left, int mid, int right) {
	
		int inv_count = 0;
		int i = left;
		int j = mid;
		int k = left;
		
		while ((i <= mid - 1) && (j <= right)) {
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];

				// important - all items after i in left sub-array inverted
				inv_count = inv_count + (mid - i);
			}
		}

		while (i <= mid - 1)
			temp[k++] = arr[i++];
		while (j <= right)
			temp[k++] = arr[j++];
		for (i = left; i <= right; i++)
			arr[i] = temp[i];

		return inv_count;
	}

}
