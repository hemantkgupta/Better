package com.hkg.test.stream;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class LazyEvaluation {

    public static void main(String[] args) {

        final Random random = new Random();

        Supplier<Integer> supp = () -> {
            Integer result = random.nextInt();
            System.out.println("Suppling result "+result);
            return result;
        };

        System.out.println("Test 1");
        Stream<Integer> randoms  =  Stream.generate(supp);
        System.out.println("First stream built");
        randoms.filter(n -> n >=0).limit(3).forEach(System.out::println);

    }
}
