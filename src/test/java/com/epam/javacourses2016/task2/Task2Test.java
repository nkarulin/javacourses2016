package com.epam.javacourses2016.task2;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task2Test {

    @Test(enabled = true, dataProvider = "directory")
    public void testTask2(String directory) { //общее навзвание, другие люди свои тесты тодже сюда вписывают,  зза этого будет конфликт на мастере
        SolverTask2 solver = new SolverTask2();
        File file = new File(directory);

        Set<File> solverSet = solver.getFiles(file);
        Set<File> testSet = getFiles(file);

        System.out.println(testSet);
        Assert.assertEquals(solverSet, testSet);
    }

    @DataProvider(name = "directory")
    public Object[][] directory() {
        return new Object[][]{
                {"src/main/java/com/epam/javacourses2016/task1"},
                {"src/main/java/com/epam/javacourses2016"},
        };
    }
    @DataProvider(name = "dirs")
    private Object[][] dirs() {
        return new Object[][] {
                { new String[] {
                        "dir1",
                        "dir2",
                        "file1.txt",
                        "file2.txt"
                }
                },
                { new String[] {
                        "dir1",
                        "dir2",
                        "dir1//file1.txt",
                        "file1.txt"
                }
                }
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

    @Test(enabled = true, dataProvider = "dirs")
    public void testTask2_fromKA(String[] filesArray) throws IOException {
        String tempDirectory = "src//main//java//com//epam//javacourses2016//tempdirector//";
        File tempDir = new File(tempDirectory);
        tempDir.mkdirs();
        List<String> files = Arrays.asList(filesArray);
        Set<File> set = new HashSet<>();
        for(String s : files) {
            Path p = Paths.get(tempDirectory + s);
            File f = p.toFile();
            if(s.indexOf(".") != -1) {
                f.createNewFile();
            }
            else f.mkdirs();
            set.add(f.getAbsoluteFile());
        }
        Set<File> newset = new SolverTask2().getFiles(tempDir.getAbsoluteFile());
        deleteFolder(tempDir);
        Assert.assertEquals(set,newset);
    }

    public static void deleteFolder(File folder) {
        File[] files = folder.listFiles();
        if(files != null) {
            for(File f: files) {
                if(f.isDirectory()) {
                    deleteFolder(f);
                } else {
                    f.delete();
                }
            }
        }
        folder.delete();
    }
}
