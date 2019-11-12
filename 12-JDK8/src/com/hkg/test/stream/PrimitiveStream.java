package com.hkg.test.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimitiveStream {

    public static void main(String[] args) {

        int[] integers = new int[] {1, 2, 3, 4};

        IntStream integerStream = Arrays.stream(integers);

        Integer sum = integerStream.reduce(0, (a, b) -> a + b);

        System.out.println(sum);

        integerStream  = IntStream.of(20, 98, 12, 7, 35);

        sum = integerStream.reduce(0, (a, b)-> a+b);

        System.out.println(sum);

        System.out.println(IntStream.range(1, 10).sum());

        System.out.println(IntStream.rangeClosed(1, 10).sum());

        // Boxing
        Stream<Integer> streamIntegers = IntStream.rangeClosed(1, 10).boxed();

        // Unboxing
        IntStream intStream = Arrays.asList(35,45).stream().mapToInt(i -> i);

        LongStream longstream = Arrays.asList(35l, 45l).stream().mapToLong(i -> i);

        LongStream longStream2 = IntStream.range(1, 5).mapToLong(i -> i);

        System.out.println(sum);

        IntStream.iterate(0, i -> i + 2).limit(3).forEach(System.out::println);

        // Replace for loop by below construct
        IntStream.range(0,5).forEachOrdered(System.out::println);

        OptionalDouble optionalDouble = Arrays.asList(35,45).stream().mapToInt(i -> i).average();

        System.out.println(optionalDouble.getAsDouble());




    }
}
