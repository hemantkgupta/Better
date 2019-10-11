package com.hkg.test.functional;

import java.util.function.BinaryOperator;

public class BinaryOperatorTest {

    public static void main(String[] args) {

        BinaryOperator<Integer> binaryOperator = (a, b) -> a+b;
        System.out.println(binaryOperator.apply(3, 4));
    }
}
