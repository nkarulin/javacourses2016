package com.epam.javacourses2016.task10;

import com.epam.javacourses2016.task9.SolverTask9;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import static org.testng.Assert.*;

public class SolverTask10Test {
    @Test(enabled = true, dataProvider = "lines")
    public void testCountNumberWords(String[] linesArray, Object[][] result) throws Exception {
        List<String> lines = Arrays.asList(linesArray);
        SolverTask10 task10 = new SolverTask10();

        File input = Files.createTempFile("task10", "input").toFile();

        try (FileWriter write = new FileWriter(input)) {
            for (String line : lines) {
                write.write(line + '\n');

            }
        }
        Assert.assertEquals(task10.countNumberWords(input), convertToMap(result));
    }

    public HashMap<String, Integer> convertToMap(Object[][] arr) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arr[1].length; i++) {
            map.put((String) arr[0][i], (Integer) arr[1][i]);
        }
        return map;
    }

    @DataProvider(name = "lines")
    private Object[][] lines() {
        return new Object[][]{
                {
                        new String[]{
                                "Stack Overflow is a community of 6.3 million programmers",
                                "Stack Overflow is the best community for developers"
                        },
                        new Object[][]{{
                                "a", "Stack", "developers", "for", "is", "best", "community", "the",
                                "Overflow", "million", "of", "programmers", "6.3"
                        },
                                {1, 2, 1, 1, 2, 1, 2, 1, 2, 1, 1, 1, 1}
                        }

                },
                {
                        new String[]{"Hello", "There", "", "My old friend", "hello", "friend"},
                        new Object[][]{{"old", "There", "friend", "hello", "Hello", "My"}, {1, 1, 2, 1, 1, 1}}
                }
        };
    }
}