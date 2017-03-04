package search.basic;

/**
 * Created by ghemant on 3/4/17.
 */
public class SRCH1BinaryIterative {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 6, 8, 10};
        /*System.out.println("The result is at index "+ binarySearch(array, 0));
        System.out.println("The result is at index "+ binarySearch(array, 3));
        System.out.println("The result is at index "+ binarySearch(array, 5));
        System.out.println("The result is at index "+ binarySearch(array, 11));*/

        int[] array2 = {2, 4, 10, 10, 10, 10, 20};
        //System.out.println("The result is at index "+ binarySearch(array2, 10));
        //System.out.println("The first result is at index "+ binarySearchFirstOccurence(array2, 10));
        //System.out.println("The last result is at index "+ binarySearchLastOccurence(array2, 10));
        //System.out.println("The result count is "+ binarySearchCount(array2, 10));

        int[] array3 = { 5, 6, 7, 8, 9, 1, 2};
        //System.out.println("The minimum is at index: "+ findPivotInSortedUniqueElements(array3, 0, array3.length-1));
        System.out.println("The element is at index: "+ findInCircularSortedUniqueElements(array3, 7, 0, array3.length-1));
    }

    public static int binarySearch(int[] array, int x){
        int lowIndex = 0;
        int highIndex = array.length-1;
        while( lowIndex <= highIndex){
            //System.out.println("The lowIndex is: "+ lowIndex + " the highIndex is: "+ highIndex);
            int mid = (lowIndex+highIndex)/2;
            if (x == array[mid]){
                return mid;
            }else if (x < array[mid]){
                highIndex = mid-1;
            } else{
                lowIndex = mid+1;
            }
        }
        return -1;
    }

    public static int binarySearchFirstOccurence(int[] array, int x){
        int lowIndex = 0;
        int highIndex = array.length-1;
        int resultIndex = -1;
        while( lowIndex <= highIndex){
            //System.out.println("The lowIndex is: "+ lowIndex + " the highIndex is: "+ highIndex);
            int mid = (lowIndex+highIndex)/2;
            if (x == array[mid]){
                resultIndex = mid;
                highIndex = mid-1;
            }else if (x < array[mid]){
                highIndex = mid-1;
            } else{
                lowIndex = mid+1;
            }
        }
        return resultIndex;
    }

    public static int binarySearchLastOccurence(int[] array, int x){
        int lowIndex = 0;
        int highIndex = array.length-1;
        int resultIndex = -1;
        while( lowIndex <= highIndex){
            //System.out.println("The lowIndex is: "+ lowIndex + " the highIndex is: "+ highIndex);
            int mid = (lowIndex+highIndex)/2;
            if (x == array[mid]){
                resultIndex = mid;
                lowIndex = mid+1;
            }else if (x < array[mid]){
                highIndex = mid-1;
            } else{
                lowIndex = mid+1;
            }
        }
        return resultIndex;
    }

    public static int binarySearchCount(int[] array, int x){
        int lowIndex = 0;
        int highIndex = array.length-1;
        int count = 0;
        while( lowIndex <= highIndex){
            //System.out.println("The lowIndex is: "+ lowIndex + " the highIndex is: "+ highIndex);
            int mid = (lowIndex+highIndex)/2;
            if (x == array[mid]){
                count++;
                int current = mid+1;
                while (x == array[current] && current <= array.length-1){
                    current++;
                    count++;
                }
                current = mid-1;
                while (x == array[current] && current >= 0){
                    current--;
                    count++;
                }

                return count;
            }else if (x < array[mid]){
                highIndex = mid-1;
            } else{
                lowIndex = mid+1;
            }
        }
        return count;
    }

    public static int findPivotInSortedUniqueElements(int[] array, int lowIndex, int highIndex){

        while (lowIndex <= highIndex){
            System.out.println("The lowIndex is: "+ lowIndex + " the highIndex is: "+ highIndex);
            if (array[lowIndex] <= array[highIndex]){
                return lowIndex;
            }
            int n = array.length;
            int mid = (lowIndex+highIndex)/2;
            int next = (mid+1)%n;
            int previous = (mid+n-1)%n;
            System.out.println("the mid is: "+ mid + " next is:"+ next + " and previous is: "+ previous);

            if (array[mid] <= array[next] &&
                    array[mid] <= array[previous]){
                return mid;
            } else if (array[mid] <= array[highIndex]){
                highIndex = mid-1;
            } else if (array[mid] >= array[lowIndex]){
                lowIndex = mid+1;
            }
        }

        return -1;
    }

    public static int findInCircularSortedUniqueElements(int[] array, int x, int lowIndex, int highIndex){

        while(lowIndex <= highIndex){
            System.out.println("The lowIndex is: "+ lowIndex + " the highIndex is: "+ highIndex);

            int mid = (lowIndex+highIndex)/2;
            if (array[mid] == x){
                return  mid;
            }
            System.out.println("the mid is "+ mid);
            if (array[mid] <= array[highIndex]){

                if(x > array[mid] && x <= array[highIndex]){
                    lowIndex = mid + 1;
                } else {
                    highIndex = mid - 1;
                }

            } else {

                if(x < array[mid] && x >= array[lowIndex]){
                    highIndex = mid - 1;
                } else {
                    lowIndex = mid + 1;
                }

            }
        }

        return -1;

    }
}
