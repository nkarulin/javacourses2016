package com.epam.javacourses2016.task15;

import com.epam.javacourses2016.Point2D;
import javafx.print.Collation;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sun.misc.PerformanceLogger;

import java.io.*;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static org.testng.Assert.*;

/**
 * Created by kodoo on 13.11.16.
 */
public class SolverTask15Test {
    @Test(enabled = true, dataProvider = "points")
    public void testAnalyze(Double[] arr) throws Exception {
        SolverTask15 task15 = new SolverTask15();
        Set<Point2D> points = convertToSet(arr);
        File out = Files.createTempFile("task15", "out").toFile();
        SolverTask15.IFileWithLines analyze = task15.analyze(points, out);

        Assert.assertEquals(analyze.getLines(), readFile(out));
        // TODO: lines is correct isn't it?
    }

    private Set<SolverTask15.ILine> readFile(File file) {
        Set<SolverTask15.ILine> lines = new TreeSet<>();
        if (file.length() != 0) {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
                lines= (Set<SolverTask15.ILine>) objectInputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return lines;
    }

    private Set<Point2D> convertToSet(Double[] arr) {
        Set<Point2D> set = new HashSet<>();
        for (int i = 0; i < arr.length - 1; i++) {
            set.add(new Point2D(arr[i], arr[i + 1]));
            i++;
        }
        return set;
    }

    @DataProvider(name = "points")
    private Object[][] cars() {
        return new Object[][]{
                {new Double[]{1.0, 0.5, 0.0, 1.0, 0.0, 1.0, 2.0, 3.0, -2.0, -1.0, -10.0, 0.0, 10.0, 1.0}}
        };
    }

}