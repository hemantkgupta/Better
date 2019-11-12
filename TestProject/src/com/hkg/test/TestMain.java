package com.hkg.test;

import java.util.ArrayList;

/**
 * Created by ghemant on 3/2/17.
 */
public class TestMain {
    public static void main(String[] args) {
        System.out.println("Hi");
        System.out.println((generate(5)));

    }
    public static ArrayList<ArrayList<Integer>> generate(int a) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();


        int[][] A = new int[a][a];
        for(int rowIndex=0; rowIndex<a; rowIndex++){
            A[rowIndex][0] = 1;
        }

        for(int rowIndex=1; rowIndex<a; rowIndex++){
            for(int columnIndex=1;columnIndex<a; columnIndex++){
                A[rowIndex][columnIndex] = A[rowIndex-1][columnIndex] + A[rowIndex-1][columnIndex-1];
            }
        }

        printMatrix(A);

        if (a==0){
            return result;
        }
        for(int rowIndex=0; rowIndex<a; rowIndex++){
            ArrayList<Integer> aRowList = new ArrayList<>();
            for(int columnIndex=0;columnIndex<=rowIndex; columnIndex++){
                aRowList.add(columnIndex, A[rowIndex][columnIndex]);
            }
            result.add(aRowList);
        }

        return result;

    }

    public static void printMatrix(int[][] A){
        for(int rowIndex=0; rowIndex<A.length; rowIndex++){
            for(int columnIndex=0;columnIndex<A.length; columnIndex++){
                System.out.print(A[rowIndex][columnIndex]+ " ");
            }
            System.out.println("");
        }
    }
}
