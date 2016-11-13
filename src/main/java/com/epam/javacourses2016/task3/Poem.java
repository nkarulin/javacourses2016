package com.epam.javacourses2016.task3;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * Стихотворение.
 */
public class Poem {

    private final String author;
    private final List<String> lines;

    public Poem(List<String> lines, String author) {
        this.author = author;
        this.lines = lines;
    }

    public List<String> getLines() {
        return lines;
    }

    public String getAuthor() {
        return author;
    }

}
