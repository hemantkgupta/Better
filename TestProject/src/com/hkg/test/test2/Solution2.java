package com.hkg.test.test2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ghemant on 3/2/17.
 */
public class Solution2 {

    public static void main(String[] args) {


        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        ArrayList<Integer>  first =  new ArrayList<>();
        first.add(1);
        first.add(2);
        first.add(3);
        first.add(4);
        A.add(first);
        ArrayList<Integer>  second =  new ArrayList<>();
        second.add(5);
        second.add(6);
        second.add(7);
        second.add(8);
        A.add(second);
        ArrayList<Integer>  third =  new ArrayList<>();
        third.add(9);
        third.add(10);
        third.add(11);
        third.add(12);
        A.add(third);
        //System.out.println(rotateArray(first, 2));
        //System.out.println(performOps(first))
        // System.out.println(alternateReverseOrder(A));
        //spiralOrder(A);
        ArrayList<Integer>  test =  new ArrayList<>();
        test.add(1);
        test.add(2);
        test.add(5);
        test.add(-7);
        test.add(3);
        test.add(7);
        System.out.println(maxset(test));

    }
    public static ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ret = new ArrayList<Integer>(A.size());
        int size = A.size();
        for (int i = 0; i < size; i++) {
           // int index = (i+B) % size;
           // System.out.println("the index is "+ index);
           // System.out.println("the value is "+ A.get(i));
            ret.add(A.get((i+B)%A.size()));
        }
        return ret;
    }



    public static ArrayList<Integer> alternateReverseOrder(final List<ArrayList<Integer>> a) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        boolean forward = true;
            for (int i = 0; i <a.size() ; i++) {
                if (forward) {
                    for (int j = 0; j < a.get(i).size(); j++) {
                        result.add(a.get(i).get(j));
                    }
                    forward = !forward;
                } else {
                    for (int j = a.get(i).size() - 1 ; j >= 0; j--) {
                        result.add(a.get(i).get(j));
                    }
                    forward = ! forward;
                }
            }

        return result;
    }

    public static ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int  noOfPass = a.size() / 2 ; // no of rows
        //for (int i = 0; i < noOfPass ; i++) {
            printTopRow(a,0, 1);
            printRightColumn(a, 3, 1);
            printBottomRow(a, 2, 1);
            printLeftColumn(a, 0, 1);
        //}

        return result;
    }

    public static void printRightColumn(List<ArrayList<Integer>> a, int columnIndex, int passCounter ) {
        System.out.println("Printing right column");
        int trim = passCounter;
        for (int i = 0 + trim; i < a.size() - trim  ; i++) {
            System.out.print(a.get(i).get(columnIndex) + " ");
        }
        System.out.println("");
    }

    public static void printLeftColumn(List<ArrayList<Integer>> a, int columnIndex, int passCounter ) {
        System.out.println("Printing left column");
        int trim = passCounter;
        for (int i = a.size() -1 - trim;  i >= 0 + trim  ; i--) {
            System.out.print(a.get(i).get(columnIndex) + " ");
        }
        System.out.println("");
    }

    public static void printTopRow(List<ArrayList<Integer>> a, int rowNum, int passCounter) {
        System.out.println("Printing top row");
        List<Integer> list = a.get(rowNum);
        //int size = list.size() - 2 * passCounter;
        int trim = passCounter -1;

        for (int i = 0+trim; i < list.size()-trim ; i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println("");
    }

    public static void printBottomRow(List<ArrayList<Integer>> a, int rowNum, int passCounter) {
        System.out.println("Printing bottom row");
        List<Integer> list = a.get(rowNum);
        int trim = passCounter - 1;

        for (int i = list.size() - 1 - trim; i >= 0 + trim; i--) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println("");
    }

    public static ArrayList<Integer> performOps(ArrayList<Integer> A) {
        ArrayList<Integer> B = new ArrayList<Integer>();
        for (int i = 0; i < 2 * A.size(); i++) B.add(0);
        for (int i = 0; i < A.size(); i++) {
            B.set(i, A.get(i));
            int val = (A.size() - i) % A.size();
            System.out.println("the index is "+ val);
            B.set(i + A.size(), A.get((A.size() - i) % A.size()));
        }
        return B;
    }


    public static int maxset(ArrayList<Integer> a) {
        // If negative item found update current startIndex to -1
        // Also reset the currentSum
        // if positive item found increase startIndex
        // increase the currentSum and check it with maxSum
        //
        int currentStartIndex = -1;
        int currentEndIndex = -1;
        int currentSum = 0;
        int maxSum = 0;
        int maxStartIndex = 0;
        int maxEndIndex = 0;
        for (int i = 0; i < a.size(); i++) {
            int currentElement = a.get(i);
            if (currentElement < 0) {
                currentStartIndex = -1;
                currentEndIndex = -1;
                currentSum = 0;
            } else {
                    if (currentStartIndex == -1) {
                        //sub-array starts from here
                        currentStartIndex = i;
                        currentEndIndex = i;
                    }
                    currentSum += currentElement;
                    if (currentSum > maxSum) {
                        maxSum = currentSum;
                        maxStartIndex = currentStartIndex;
                        maxEndIndex = i;
                    }
                    currentEndIndex = i;
                // }
            }

        }
        System.out.println("the currentStartIndex "+ currentStartIndex);
        System.out.println("the endIndex "+ currentEndIndex);

        System.out.println("the maxStartIndex "+ maxStartIndex);
        System.out.println("the maxEndIndex "+ maxEndIndex);
        return maxSum;
    }


}