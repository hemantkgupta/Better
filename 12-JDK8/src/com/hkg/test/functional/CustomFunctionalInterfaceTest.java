package com.hkg.test.functional;

public class CustomFunctionalInterfaceTest {

    public static void main(String[] args) {

        Calculate calculateSum = (a, b) -> a + b;
        Calculate calculateDifference = (a, b) -> Math.abs(a-b);

        System.out.println(calculateSum.calc(2,3));
        System.out.println(calculateDifference.calc(2,3));

    }
}
