package sort.basic;

/**
 * Created by hemant on 17/10/15.
 */
public class A005InversionCount {

    public static void main(String[] args) {
        int[] arr = {1,2,3,6,4,5,7};
        int[] temp = new int[7];
        System.out.println(mergeSort(arr, temp, 0, arr.length-1));
    }

    /**
     *
     * @param arr
     * @param temp
     * @param left is the start index of array to sort
     * @param right is the end index of array to sort
     * @return
     */

    public static int mergeSort(int arr[], int temp[], int left, int right) {
        int mid, inv_count = 0;
        if (right > left) {
            mid = (right + left) / 2;

            // Call merge sort for both part
            inv_count = mergeSort(arr, temp, left, mid);
            inv_count += mergeSort(arr, temp, mid + 1, right);

            // Call the merge for sorted arrays
            inv_count += merge(arr, temp, left, mid + 1, right);
        }
        return inv_count;
    }

    /**
     *
     * @param arr
     * @param temp
     * @param left is the start point for first array involve in merge
     * @param mid
     * @param right is the last point for second point involve in merge
     * @return
     */
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
                // all items after i in left sub-array are inverted
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
