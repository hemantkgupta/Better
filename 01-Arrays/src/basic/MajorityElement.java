package basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 Given an array A of N elements. Find the majority element in the array.
 A majority element in an array A of size N is an element that appears more than N/2 times in the array.

 Input:
 The first line of the input contains T denoting the number of testcases.
 The first line of the test case will be the size of array and second line will be the elements of the array.

 Output:
 For each test case the output will be the majority element of the array.
 Output "-1" if no majority element is there in the array.

 Constraints:
 1 <= T<= 100
 1 <= N <= 10000000
 0 <= Ai <= 1000000

 Example:
 Input:
 2
 5
 3 1 3 3 2
 3
 1 2 3

 Output:
 3
 -1

 Explanation:
 Testcase 1: Since, 3 is present more than N/2 times, so it is the majority element.

 */
public class MajorityElement {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int T = s.nextInt();

        while(T > 0) {
            int N = s.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N ; i++) {
                arr[i] = s.nextInt();
            }
            printMajority(arr);
            T--;
        }


    }


    public static void printMajority(int[] a) {
        int cand = findCandidate(a);
        if (isMajority(a, cand))
            System.out.println(cand);
        else
            System.out.println("-1");
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
