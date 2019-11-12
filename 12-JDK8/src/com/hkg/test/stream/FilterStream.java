package com.hkg.test.stream;

import java.util.Random;
import java.util.stream.Stream;

public class FilterStream {

    public static void main(String[] args) {
        // filter, limit and distinct

        final  Random random = new Random();
        Stream<Integer> randoms =  Stream.generate(random::nextInt);

        randoms.filter(n -> n > 0)
                .distinct()
                .limit(5)
                .forEach(System.out::println);

    }
}
