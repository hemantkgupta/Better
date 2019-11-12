package basic;

import java.util.Scanner;

public class Kadane {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();

        while(T > 0) {
            int N = s.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N ; i++) {
                arr[i] = s.nextInt();
            }
            System.out.println(kadane(arr));
            T--;
        }
    }

    public static int kadane(int[] ar) {
        int maxSoFar = ar[0];
        int maxSumEndingHere = ar[0];
        for (int i = 1; i < ar.length; i++) {
            //Get the contiguous segment
            maxSumEndingHere = Math.max(ar[i], ar[i] + maxSumEndingHere);
            //Compare it with max
            maxSoFar = Math.max(maxSoFar, maxSumEndingHere);
        }
        return maxSoFar;
    }

}
