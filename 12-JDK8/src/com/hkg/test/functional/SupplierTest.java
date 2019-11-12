package com.hkg.test.functional;

import java.util.function.Supplier;

public class SupplierTest {

    public static void main(String[] args) {

        Supplier<String> stringSupplier = () -> "Hello World!";
        System.out.println(stringSupplier.get());
    }
}
