package com.epam.javacourses2016.task3;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.*;

public class Task3Test {

    @DataProvider(name = "poems")
    private Object[][] poems() {
        return new Object[][] {
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
            poemsSet.add(loadPoem(poem));
        }

        List<String> sortedPoem = new ArrayList<>();
        poemOut = this.getClass().getResource(poemOut).getPath();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(poemOut)))) {
            String str;
            while ((str = reader.readLine())!=null){
                sortedPoem.add(str);
            }

        }

        Assert.assertEquals(solver.sortPoems(poemsSet, author), sortedPoem);
    }

    Poem loadPoem(String filePath) throws IOException {
        filePath = this.getClass().getResource(filePath).getPath();
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