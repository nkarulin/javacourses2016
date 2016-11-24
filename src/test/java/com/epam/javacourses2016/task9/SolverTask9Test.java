package com.epam.javacourses2016.task9;

import com.epam.javacourses2016.task1.SolverTask1;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

import static org.testng.Assert.*;

public class SolverTask9Test {
    @Test(enabled = true, dataProvider = "lines")
    public void testGetUniqueWords(String[] linesArray, String[] result) throws IOException {
        List<String> lines = Arrays.asList(linesArray);
        SolverTask9 task9 = new SolverTask9();

        File input = Files.createTempFile("task9", "input").toFile();

        try (FileWriter write = new FileWriter(input)) {
            for (String line : lines) {
                write.write(line + '\n');

            }
        }

        Assert.assertEquals(task9.getUniqueWords(input), convertToSet(result));
    }

    public HashSet<String> convertToSet(String[] arr) {
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        return set;
    }

    @DataProvider(name = "lines")
    private Object[][] lines() {
        return new Object[][]{
            {
                        new String[]{
                                "Stack Overflow is a community of 6.3 million programmers",
                                "Stack Overflow is the best community for developers"
                        },
                        new String[]{
                                "a", "stack", "developers", "for", "is", "best", "community", "the", "overflow", "million", "of", "programmers", "6.3"
                        }

            },
                {new String[]{"Hello", "There", "", "My old friend"}, new String[]{"old", "there", "friend", "hello", "my"}}
        };
    }
}