package sort.basic;

import java.util.Arrays;

/**
 * Created by root on 12/12/15.
 */
public class SRT07AMaxHeapSort {

    public static void main(String[] args) {
        int [] ar = {12, 35, 87, 26, 9, 28, 7};
        heapSort(ar);
        System.out.println(Arrays.toString(ar));
    }
    /**
     * This function first builds a max-heap from full array and then
     * put the root of heap to end of the array. Once again same process
     * is repeated but this time the last put element in array is excluded
     * This loop is continued till one element is remaining for process.
     */
    public static void heapSort(int [] array){
        if(array == null || array.length < 2)
            return;

        // Build the max-heap from array
        buildMaxHeap(array, array.length);

        //Get max from heap and put at end
        int heapSize = array.length;
        for (int i = array.length-1; i > 0 ; i--) {
            swap(array, 0, i);
            heapSize = heapSize -1;
            maxHeapify(array, 0, heapSize);
        }


    }


    /**
     * For parent i (including 0), left child at 2*i+1 and right child at 2*i+2
     * For child i parent is (i-1)/2 for i >= 1
     * If last leaf node is at i then its parent is the last internal node
     * @param array
     * @param heapSize
     */

    public static void buildMaxHeap(int[] array, int heapSize){

        int lastElementIndex = array.length - 1;
        int parentIndex = (lastElementIndex - 1)/2;
        for(int i = parentIndex; i >= 0; i--){
            maxHeapify(array, i, heapSize);
        }
    }

    /**
     * For parent i (including 0), left child at 2*i+1 and right child at 2*i+2
     * for child i parent is (i-1)/2 where is greater than 1
     * If last leaf node is at i than index of its parent is the last internal node
     * This method will be executed for all internal nodes
     * The max-heap is a complete binary tree which has following property:
     * Value of a node is greater or equal to value of its both child nodes.
     * The property is applicable to each node.
     */
    public static void maxHeapify(int[] a, int nodeIndex, int heapSize){

            int left = 2 * nodeIndex + 1;

            int right = left + 1;

            int largest = nodeIndex;

            if (left < heapSize && a[left] > a[nodeIndex] )
                largest = left;

            if (right < heapSize && a[right] > a[largest] )
                largest = right;

            if (largest != nodeIndex){
                swap(a, nodeIndex, largest);
                maxHeapify(a,largest, heapSize);
            }

    }


    private static void swap(int[] array, int first, int second) {
        int tmp = array[first];
        array[first] = array[second];
        array[second] = tmp;
    }
}
