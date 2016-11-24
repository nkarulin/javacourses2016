package com.epam.javacourses2016.task15;

import com.epam.javacourses2016.Point2D;
import javafx.print.Collation;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sun.misc.PerformanceLogger;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.*;

/**
 * Created by kodoo on 13.11.16.
 */
public class SolverTask15Test {
    @Test(enabled = true, dataProvider = "lines")
    public void testAnalyze(Double[] arr) throws Exception {
        SolverTask15 task15 = new SolverTask15();
        Set<Point2D> points = convertToSet(arr);
        File out = Files.createTempFile("task15", "out").toFile();
        SolverTask15.IFileWithLines analyze = task15.analyze(points, out);
        Set<SolverTask15.ILine> lines = analyze.getLines();
        Set<SolverTask15.ILine> outputLines = new HashSet<>();
        if (out.length() != 0) {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(out))) {
                outputLines = (Set<SolverTask15.ILine>) objectInputStream.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        Assert.assertEquals(lines, outputLines);
    }

    public Set<Point2D> convertToSet(Double[] arr) {
        Set<Point2D> set = new HashSet<>();
        for (int i = 0; i < arr.length - 1; i++) {
            set.add(new Point2D(arr[i], arr[i + 1]));
            i++;
        }
        return set;
    }

    @DataProvider(name = "lines")
    private Object[][] cars() {
        return new Object[][]{
                {new Double[]{0.0, 0.0, 0.0, 1.0, -1.0, 0.0, 1.0, 0.5, 0.0, 1.0, 0.0, 1.0, 2.0, 3.0, -2.0, -1.0, -10.0, 0.0, 10.0, 1.0}}
        };
    }

}