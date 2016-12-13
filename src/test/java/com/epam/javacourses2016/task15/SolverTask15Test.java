package com.epam.javacourses2016.task15;

import com.epam.javacourses2016.Point2D;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.*;

/**
 * Created by kodoo on 13.11.16.
 */
public class SolverTask15Test {

    @Test(enabled = true, dataProvider = "points")
    public void testAnalyze(double[][] points, ArrayList<double[][]> result) throws Exception {

        SolverTask15 solver = new SolverTask15();

        File in = Files.createTempFile("task1", "in").toFile();
        Set<Point2D> setOfPoints = pointsToSet(points);

        SolverTask15.IFileWithLines someFile = solver.analyze(setOfPoints, in);
        Set<SolverTask15.ILine> lines = someFile.getLines();
        lines.size();
    }

    public Set<Point2D> pointsToSet(double[][] points) {
        Set<Point2D> setPoints = new HashSet<>();

        for (double[] d : points) {
            setPoints.add(new Point2D(d[0], d[1]));
        }

        return setPoints;
    }

    @DataProvider(name = "points")
    public Object[][] points() {
        return new Object[][]{
                {new double[][]{{1, 1}, {2, 2}},
                        new ArrayList<double[][]>() {{
                        }}},
                {new double[][]{{1, 1}, {2, 2}, {3, 3}},
                        new ArrayList<double[][]>() {{
                            add(new double[][]{{1, 1}, {2, 2}, {3, 3}});
                        }}},
                {new double[][]{{1, 1}, {2, 2}, {3, 3}, {3, 1}},
                        new ArrayList<double[][]>() {{
                            add(new double[][]{{1, 1}, {2, 2,}, {3, 3}});
                        }}},
                {new double[][]{{1, 1}, {2, 2}, {3, 3}, {3, 1}, {1, 3}},
                        new ArrayList<double[][]>() {{
                            add(new double[][]{{1, 1}, {2, 2,}, {3, 3}});
                            add(new double[][]{{1, 3}, {2, 2,}, {3, 1}});
                        }}},
        };
    }
}