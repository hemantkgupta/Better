package com.hkg.test.functional;

import java.util.function.UnaryOperator;

public class UnaryOperatorTest {

    public static void main(String[] args) {

        UnaryOperator<String> unaryOperator = s -> s.toLowerCase();
        System.out.println(unaryOperator.apply("Hello World!"));


    }
}
