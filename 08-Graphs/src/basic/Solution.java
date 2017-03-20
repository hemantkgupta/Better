package basic;

import java.util.*;

/**
 * Created by ghemant on 3/8/17.
 */

public class Solution {
    public static boolean marked[][];
    public static int countConnected;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        marked = new boolean[n][m];
        int maxConnected = 0;
        for(int grid_i=0; grid_i < n; grid_i++) {
            for (int grid_j = 0; grid_j < m; grid_j++) {
                if(grid[grid_i][grid_j] == 1 && marked[grid_i][grid_j]== false){
                    countConnected = 0;
                    markConnected(grid,grid_i,grid_j);
                    if (countConnected > maxConnected){
                        maxConnected = countConnected;
                    }
                }
            }
        }
        printBooleanMatrix(marked);
        System.out.println(maxConnected);
    }
    public static void markConnected(int[][] grid, int startRow, int startColumn){
        Queue<Pair> q = new LinkedList<>();
            marked[startRow][startColumn] = true;
            countConnected++;
            q.add(new Pair(startRow, startColumn));
            while (!q.isEmpty()){
                Pair pairToTest = q.remove();
                System.out.println("working for row: "+ pairToTest.rowIndex +"  and column: "+pairToTest.columnIndex);
                // for neigh  if in limit, not visitid and value 1
                if (checkAndMarkRight(grid, pairToTest)){
                    countConnected++;
                    q.add(new Pair(startRow,startColumn+1));
                }
                if (checkAndMarkLeft(grid, pairToTest)){
                    countConnected++;
                    q.add(new Pair(startRow,startColumn-1));
                }
                if(checkAndMarkDown(grid, pairToTest)){
                    countConnected++;
                    q.add(new Pair(startRow+1,startColumn));
                }
                if (checkAndMarkDiagonal(grid, pairToTest)){
                    countConnected++;
                    q.add(new Pair(startRow+1,startColumn+1));
                }
                if (checkAndMarkDiagonalBack(grid, pairToTest)){
                    countConnected++;
                    q.add(new Pair(startRow+1,startColumn-1));
                }
            }
    }
    public static boolean checkAndMarkDown(int[][] grid, Pair pair){
        int rowIndex = pair.getRowIndex();
        int columnIndex = pair.getColumnIndex();
        if (rowIndex+1 < grid.length
                && marked[rowIndex+1][columnIndex] == false
                && grid[rowIndex+1][columnIndex] == 1){
                    marked[rowIndex+1][columnIndex] = true;
                    System.out.println("checkAndMarkDown is True");
                    return true;
        }
        return false;
    }

    public static boolean checkAndMarkRight(int[][] grid, Pair pair){
        int rowIndex = pair.getRowIndex();
        int columnIndex = pair.getColumnIndex();
        if (columnIndex+1 < grid[0].length
                && marked[rowIndex][columnIndex+1] == false
                && grid[rowIndex][columnIndex+1] == 1){
            marked[rowIndex][columnIndex+1] = true;
            System.out.println("checkAndMarkRight is True");
            return true;
        }
        return false;
    }
    public static boolean checkAndMarkLeft(int[][] grid, Pair pair){
        int rowIndex = pair.getRowIndex();
        int columnIndex = pair.getColumnIndex();
        if (columnIndex-1 >= 0
                && marked[rowIndex][columnIndex-1] == false
                && grid[rowIndex][columnIndex-1] == 1){
            marked[rowIndex][columnIndex-1] = true;
            System.out.println("checkAndMarkLeft is True");
            return true;
        }
        return false;
    }

    public static boolean checkAndMarkDiagonal(int[][] grid, Pair pair){
        int rowIndex = pair.getRowIndex();
        int columnIndex = pair.getColumnIndex();
        if (rowIndex+1 < grid.length
                && columnIndex+1 < grid[0].length
                && marked[rowIndex+1][columnIndex+1] == false
                && grid[rowIndex+1][columnIndex+1] == 1){
            marked[rowIndex+1][columnIndex+1] = true;
            System.out.println("checkAndMarkDiagonal is True");
            return true;
        }
        return false;
    }
    public static boolean checkAndMarkDiagonalBack(int[][] grid, Pair pair){
        int rowIndex = pair.getRowIndex();
        int columnIndex = pair.getColumnIndex();
        if (rowIndex+1 < grid.length
                && columnIndex-1 >= 0
                && marked[rowIndex+1][columnIndex-1] == false
                && grid[rowIndex+1][columnIndex-1] == 1){
            marked[rowIndex+1][columnIndex-1] = true;
            System.out.println("checkAndMarkDiagonalBack is True");
            return true;
        }
        return false;
    }

    public static void printBooleanMatrix(boolean[][] table){

        for (int i = 0; i < table.length ; i++)
        {
            for (int j = 0; j < table[0].length; j++)
            {
                System.out.print(table[i][j]+" ");
            }
            System.out.println();
        }

    }

    static class Pair {
        int rowIndex;
        int columnIndex;

        public Pair(int rowIndex, int columnIndex) {
            this.rowIndex = rowIndex;
            this.columnIndex = columnIndex;
        }

        public int getRowIndex() {
            return rowIndex;
        }

        public void setRowIndex(int rowIndex) {
            this.rowIndex = rowIndex;
        }

        public int getColumnIndex() {
            return columnIndex;
        }

        public void setColumnIndex(int columnIndex) {
            this.columnIndex = columnIndex;
        }
    }
}