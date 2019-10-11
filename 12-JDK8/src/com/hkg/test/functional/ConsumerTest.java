package com.hkg.test.functional;

import java.util.function.Consumer;

public class ConsumerTest {

    public static void main(String[] args) {

        Consumer<String> stringConsumer = s -> System.out.println(s.toLowerCase());
        stringConsumer.accept("Hello World!");
    }
}
