package basic;

import java.util.*;
import java.lang.*;
import java.io.*;

public class MissingNumberInArray {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        System.out.println("The number of test cases are "+ T);
        List<Long> arrayData = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            long N =  s.nextInt();
            System.out.println("The N is "+ N);
            for (int j = 0; j < N-1; j++) {
                arrayData.add(s.nextLong());
            }
            System.out.println("The list length is "+ arrayData.size());
            System.out.println(arrayData);
            printMissingNumber(arrayData);
            arrayData.clear();
        }

    }

    private static void printMissingNumber(List<Long> arrayData) {
        int N = arrayData.size() + 1;
        long sum = 0;
        for (int i = 0; i < N -1; i++) {
            sum += arrayData.get(i);
        }
        long expected_sum = (N* (N+1))/2;
        System.out.println((expected_sum - sum));
    }
}

