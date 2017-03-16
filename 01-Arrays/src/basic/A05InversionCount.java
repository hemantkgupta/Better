package basic;

/**
 * Created by hemant on 17/10/15.
 */
public class A05InversionCount {

    public static void main(String[] args) {
        int[] arr = {1, 20, 6, 4, 5};
        System.out.println(mergeSort(arr,0, arr.length-1));
    }

    /**
     *
     * @param arr
     * @param left is the start index of array
     * @param right is the end index of array
     * @return
     */

    public static int mergeSort(int arr[], int left, int right) {
        int mid, inversionCount = 0;
        if (right > left) {
            mid = (right + left) / 2;

            // Call merge sort for both part
            inversionCount = mergeSort(arr, left, mid);
            inversionCount += mergeSort(arr, mid + 1, right);

            // Call the merge for sorted arrays
            inversionCount += merge(arr, left, mid + 1, right);
        }
        return inversionCount;
    }

    /**
     *
     * @param arr
     * @param left is the start point for first array involve in merge
     * @param mid is start point for second array involve in  in merge
     * @param right is the last point for second array involve in merge
     * @return
     */
    public static int merge(int arr[], int left, int mid, int right) {

        int[] temp = new int[arr.length];
        int inversionCount = 0;
        int i = left;
        int j = mid;
        int k = left;

        while ((i <= mid - 1) && (j <= right)) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                // all items after i in left sub-array are inverted
                inversionCount = inversionCount + (mid - i);
            }
        }
        while (i <= mid - 1)
            temp[k++] = arr[i++];
        while (j <= right)
            temp[k++] = arr[j++];

        for (i = left; i <= right; i++)
            arr[i] = temp[i];

        return inversionCount;
    }

}
