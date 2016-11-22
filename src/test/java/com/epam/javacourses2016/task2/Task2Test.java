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

    @Test(enabled = true, dataProvider = "directories")
    public void testTask2(String[] filesArray) throws IOException {
        String tempDirectory = "resources\\tempdirector\\";
        File tempDir = new File(tempDirectory);
        tempDir.mkdirs();
        List<String> files = Arrays.asList(filesArray);
        Set<File> set = new HashSet<>();
        set.add(tempDir.getAbsoluteFile());
        for(String s : files) {
            Path p = Paths.get(tempDirectory + s);
            File f = p.toFile();
            if(s.indexOf(".") != -1) {
               // f.mkdirs();
                f.createNewFile();
            }
            else f.mkdirs();
            set.add(f.getAbsoluteFile());
        }
        Set<File> newset = new SolverTask2().getFiles(tempDir.getAbsoluteFile());
        Assert.assertEquals(set,newset);
        deleteFolder(tempDir);
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


    @DataProvider(name = "directories")
    private Object[][] directories() {
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


}
