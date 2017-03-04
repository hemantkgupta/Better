package search.basic;

/**
 * Created by ghemant on 3/4/17.
 */
public class SRCH2BinaryRecursive {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 6, 8, 10};
        System.out.println("The result is at index "+ binarySearch(array, 2, 0, array.length-1));

    }
    public static int binarySearch(int[] array, int x, int lowIndex, int highIndex){
        System.out.println("The lowIndex is: "+ lowIndex + " and the highIndex is: "+ highIndex);
        if (lowIndex > highIndex){
            return -1;
        }
        if (lowIndex == highIndex){
            if( x == array[lowIndex]){
                return lowIndex;
            } else {
                return -1;
            }
        }
        int mid = (lowIndex+highIndex)/2;
        System.out.println("The mid is: "+mid);
        if (x == array[mid]) {
            return mid;
        }else if (x > array[mid]){
           return binarySearch(array, x, mid+1, highIndex);
        }else{
            return binarySearch(array, x, lowIndex, mid-1);
        }
    }
}
