package com.hkg.test.functional;

import java.util.function.Function;
import java.util.function.IntFunction;

public class FunctionTest {

    public static void main(String[] args) {

        Function<Integer, String> function = num -> Integer.toHexString(num);
        System.out.println(function.apply(26));

        IntFunction<String> intFunction = num -> Integer.toHexString(num);
        System.out.println(intFunction.apply(26));

        IntFunction<String> intFunction2 = Integer::toHexString;
        System.out.println(intFunction2.apply(26));

    }



}
