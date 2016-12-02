package com.epam.javacourses2016.task2;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class Task2Test {

    @Test(enabled = false, dataProvider = "directory")
    public void testTask2(String directory) {
        SolverTask2 solver = new SolverTask2();
        File file = new File(directory);

        Set<File> solverSet = solver.getFiles(file);
        Set<File> testSet = getFiles(file);

        Assert.assertEquals(solverSet, testSet);
    }

    @DataProvider(name = "directory")
    public Object[][] directory() {
        return new Object[][]{
                {"src/main/java/com/epam/javacourses2016/task1"},
                {"src/main/java/com/epam/javacourses2016"},
        };
    }

    private Set<File> getFiles(File directory) {
        Set<File> files = new HashSet<>();

        for (File file : directory.listFiles()) {
            files.add(file);
            if (file.isDirectory()) {
                files.addAll(getFiles(file));
            }
        }

        return files;
    }
}
