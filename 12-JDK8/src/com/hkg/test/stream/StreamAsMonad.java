package com.hkg.test.stream;

import java.util.HashSet;
import java.util.Set;

public class StreamAsMonad {
    public static void main(String[] args) {

        // <R> Stream<R> flatMap (Function<T, Stream<R>> f)
        // Applies function f to every element
        // f retruns a new stream for each element
        // Merges all streams to one

        Set<Book> bookSet = new HashSet<>();
        Book book1 = new Book();
        book1.getWords().add("1111");
        book1.getWords().add("3333");

        Book book2 = new Book();
        book2.getWords().add("1111");
        book2.getWords().add("2222");

        bookSet.add(book1);
        bookSet.add(book2);

        bookSet.stream()
                .flatMap(book -> book.getWords().stream())
                .distinct()
                .forEach(System.out::println);

    }
}
