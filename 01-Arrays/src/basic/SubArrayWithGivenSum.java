package basic;

import java.util.Scanner;

public class SubArrayWithGivenSum {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();

        while (T > 0) {
            int N = s.nextInt();
            int[] arr = new int[N];
            int sum = s.nextInt();
            for (int i = 0; i < N; i++) {
                arr[i] = s.nextInt();
            }
            printSubArrayIndexWithGivenSum(sum, arr);
            T--;
        }
    }
    private static void printSubArrayIndexWithGivenSum(int sum, int[] arr){

        int windowSum = arr[0];
        int windowStartIndex = 0;
        int windowEndIndex = 0;
        boolean isSolutionFound = false;


        while (windowSum < sum && windowEndIndex < arr.length-1) {

            windowEndIndex++;
            windowSum += arr[windowEndIndex];

            while (windowSum > sum && windowStartIndex != windowEndIndex){
                    windowSum -= arr[windowStartIndex];
                    windowStartIndex++;

            }

            if (windowSum == sum) {
                isSolutionFound = true;
                break;

            }
        }

        if (isSolutionFound){
            System.out.println((windowStartIndex+1) +" "+ (windowEndIndex+1));
        }else{
            System.out.println("-1");
        }
    }

}
