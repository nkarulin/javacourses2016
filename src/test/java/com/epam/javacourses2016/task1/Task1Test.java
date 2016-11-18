package com.epam.javacourses2016.task1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.lang.reflect.Array;
import java.net.URL;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Task1Test {

    @Test(enabled = true, dataProvider = "lines")
    public void testTask1(String[] linesArray) throws IOException {
        List<String> lines = Arrays.asList(linesArray);
        SolverTask1 solver = new SolverTask1();

        File in = Files.createTempFile("task1", "in").toFile();

        try (FileWriter write = new FileWriter(in)) {
            for (String line : lines) {
                write.write(line +'\n');

            }
        }

        File out = Files.createTempFile("task1", "out").toFile();

        Assert.assertEquals(solver.reverseFile(in, out), lines);

        Collections.reverse(lines);
        try (BufferedReader reader = new BufferedReader(new FileReader(out))) {
            for (String line : lines) {
                Assert.assertEquals(reader.readLine(), line);
            }
        }
    }

    @DataProvider(name = "lines")
    private Object[][] lines() {
        return new Object[][] {
                { new String[] {
                        "Join the Stack Overflow Community",
                        "Stack Overflow is a community of 6.3 million programmers, just like you, helping each other.",
                        "Join them; it only takes a minute:",
                        "Sign up"
                }
                },
                { new String[] {
                        "Hello",
                        "There",
                        "",
                        "My old friend"
                }
                }
        };
    }

}
