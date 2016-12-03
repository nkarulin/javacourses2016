package com.epam.javacourses2016.task3;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task3Test {

    @DataProvider(name = "poems")
    private Object[][] poems() {
        return new Object[][]{
                {"poem1_sorted.txt", "Пушкин", new String[]{"poem1.txt", "poem2.txt"}},
                {"poem2_sorted.txt", "Крылов", new String[]{"poem3.txt", "poem2.txt"}},
                {"poem3_sorted.txt", "Бродский", new String[]{"poem1.txt", "poem3.txt"}},
        };
    }

    @Test(enabled = true, dataProvider = "poems")
    public void testTask3(String poemOut, String author, String[] poems) throws IOException {
        SolverTask3 solver = new SolverTask3();

        Set<Poem> poemsSet = new HashSet<>();
        for (String poem : poems) {
            String path = this.getClass().getResource(poem).getPath();
            poemsSet.add(loadPoem(path));
        }

        List<String> sortedPoem = new ArrayList<>();
        String path = this.getClass().getResource(poemOut).getPath();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(path)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sortedPoem.add(line);
            }
        }

        Assert.assertEquals(solver.sortPoems(poemsSet, author), sortedPoem);
    }

    static Poem loadPoem(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)))) {
            String author = reader.readLine();
            List<String> lines = new ArrayList<>();

            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            return new Poem(lines, author);
        }
    }
}