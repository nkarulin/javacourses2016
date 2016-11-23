package com.epam.javacourses2016.task1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.lang.reflect.Array;
import java.net.URL;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;


public class Task1Test {

    /**
    Creates an example of a file for usage in tests.

    @param lines Lines to be placed to the file. May be null or empty,
                 in this case an empty string will be placed to the file.


    @param prefix A string, used in generation of a file name. May be {@code null }
    @param suffix A string, used in generation of a file name. May be {@code null },
                  in this case default {@code *.tmp} will be used.
    @return A File object created or throws an exception if any failures occured.
    @throws IOException
                 This exception will be checked further in tests.

    **/
    private File createFile(List<String> lines, String prefix, String suffix) throws IOException{
        File in = Files.createTempFile(prefix, suffix != null ? suffix : "tmp").toFile();
        String empty = "";
        if (lines != null && lines.size() > 0)
            try (FileWriter write = new FileWriter(in)) {
                for (String line : lines) {
                        write.write(line != null ? line  : empty);
                        write.write("\r\n");
                }
            }

        return in;
    }

    @Test(enabled = false)
    public void testEmptyLinesList() throws IOException {
        List<String> lines = new ArrayList<>();
        SolverTask1 solver = new SolverTask1();

        File in = createFile(lines, "task1", "in");

        File out = Files.createTempFile("task1", "out").toFile();

        Assert.assertEquals(solver.reverseFile(in, out), lines);

        Collections.reverse(lines);
        try (BufferedReader reader = new BufferedReader(new FileReader(out))) {
            for (String line : lines) {
                Assert.assertEquals(reader.readLine(), line);
            }
        }
    }

    @Test(enabled = false, dataProvider = "lines")
    public void testTask1(String[] linesArray) throws IOException {
        List<String> lines = Arrays.asList(linesArray);
        SolverTask1 solver = new SolverTask1();

        File in = createFile(lines, "task1", "in");

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
