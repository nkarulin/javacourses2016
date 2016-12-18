package com.epam.javacourses2016.Task17;

import com.epam.javacourses2016.Point2D;
import com.epam.javacourses2016.Segment;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SolverTask17Test {

    @Test(enabled = false, dataProvider = "segments")
    public void testSegmentsIntersection(ArrayList<double[][]> segments, double[][] points) {
        SolverTask17 solver = new SolverTask17();

        Set<Segment> resultSegments = arrayToSet(segments);
        Set<Point2D> resultPoints = arrayToPoints(points);
        Set<Point2D> solverPoints = solver.analyze(resultSegments);

        Assert.assertEquals(solverPoints, resultPoints);
    }

    @DataProvider(name = "segments")
    public Object[][] segments() {
        return new Object[][]{
                {new ArrayList<double[][]>() {
                    {
                        add(new double[][]{{1, 1}, {3, 3}});
                        add(new double[][]{{3, 1}, {1, 3}});
                    }
                }, new double[][]{{2, 2,}}},
                {new ArrayList<double[][]>() {
                    {
                        add(new double[][]{{1, 1}, {3, 3}});
                        add(new double[][]{{3, 1}, {1, 3}});
                        add(new double[][]{{1, 4}, {3, 6}});
                        add(new double[][]{{1, 6}, {3, 4}});
                    }
                }, new double[][]{{2, 2,}, {2, 5}}}
        };
    }

    private Set<Point2D> arrayToPoints(double[][] points) {
        Set<Point2D> resultPoints = new HashSet<>();

        for (double[] point : points) {
            resultPoints.add(new Point2D(point[0], point[1]));
        }

        return resultPoints;
    }

    private Set<Segment> arrayToSet(ArrayList<double[][]> array) {
        Set<Segment> segments = new HashSet<>();

        for (double[][] points : array) {
            Point2D a = new Point2D(points[0][0], points[0][1]);
            Point2D b = new Point2D(points[1][0], points[1][1]);
            Segment segment = new Segment(a, b);
            segments.add(segment);
        }

        return segments;
    }
}
