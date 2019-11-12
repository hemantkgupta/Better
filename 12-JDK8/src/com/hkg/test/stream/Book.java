package com.hkg.test.stream;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private List<String> words;

    public Book() {
        this.words = new ArrayList<>();
    }

    public List<String> getWords() {
        return words;
    }

}
