package com.hkg.test.stream;

import java.util.Arrays;
import java.util.Collection;

public class ReduceAndCollect {

    public static void main(String[] args) {

        String[] strings = new String[] {"abc", "abcd", "abcde"};

        Collection<String> words = Arrays.asList(strings);

        String concatenated = words.stream()
                .reduce("", (a, b) -> a + "" + b);
        System.out.println(concatenated);
    }
}
