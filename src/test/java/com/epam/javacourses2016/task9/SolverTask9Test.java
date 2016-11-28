package com.epam.javacourses2016.task9;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;

public class SolverTask9Test {

    @Test(dataProvider = "text")
    public void testGetUniqueWords(String fileName, String fileResult) throws Exception {
        SolverTask9 solver = new SolverTask9();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        File resultFile = new File(classLoader.getResource(fileResult).getFile());

        HashSet<String> uniqueWords = new HashSet<>();

        try (Scanner scanner = new Scanner(new FileReader(resultFile))) {
            while (scanner.hasNextLine()) {
                Scanner scanner2 = new Scanner(scanner.nextLine());
                while (scanner2.hasNext()) {
                    uniqueWords.add(scanner2.next().toLowerCase());
                }
            }
        }

        Assert.assertEquals(solver.getUniqueWords(file), uniqueWords);
    }

    @DataProvider(name = "text")
    public Object[][] text() {
        return new Object[][]{
                {"com/epam/javacourses2016/task9/text1.txt", "com/epam/javacourses2016/task9/text1_unique.txt"},
                {"com/epam/javacourses2016/task9/text2.txt", "com/epam/javacourses2016/task9/text2_unique.txt"},
                {"com/epam/javacourses2016/task9/text3.txt", "com/epam/javacourses2016/task9/text3_unique.txt"},
        };
    }

}