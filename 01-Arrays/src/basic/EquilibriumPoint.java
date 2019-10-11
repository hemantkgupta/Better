package basic;

import java.util.Scanner;

public class EquilibriumPoint {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int T = s.nextInt();

        while(T > 0) {
            int N = s.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N ; i++) {
                arr[i] = s.nextInt();
            }
            equilibriumPoint(arr);
            T--;
        }


    }

    private static void equilibriumPoint(int[] arr) {
        if (arr.length == 1){
            System.out.println("1");
        } else {

        }


    }


}
