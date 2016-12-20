package com.epam.javacourses2016.task16;

import com.epam.javacourses2016.Point2D;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

import static org.testng.Assert.*;

/**
 * Created by kodoo on 13.11.16.
 */
public class SolverTask16Test {
    @Test(enabled = true, dataProvider = "points")
    public void testAnalyze(Point2D center, int radius,
                            Set<Point2D> points, Set<Point2D> result) throws Exception {

        File output = Files.createTempFile("task16", "in").toFile();

        SolverTask16 solver = new SolverTask16();
        SolverTask16.IFileWithPoints file = solver.analyze(points, center, radius, output);

        Set<Point2D> actualSet = file.getPoints().keySet();
        Point2D[] actual = actualSet.toArray(new Point2D[actualSet.size()]);
        Point2D[] resultArr = result.toArray(new Point2D[result.size()]);

        Comparator<Point2D> comparator = (item1, item2) -> { return item1.getX() == item2.getX() ?
                item1.getY() > item2.getY() ? 1 : item1.getY() < item2.getY() ? -1 : 0 :
                item1.getX() > item2.getX() ? 1 : -1; };
        Arrays.sort(actual, comparator);
        Arrays.sort(resultArr, comparator);
        if (actual.length != resultArr.length)
            Assert.fail();
        for(int i = 0; i < resultArr.length; i++) {
            if (comparator.compare(resultArr[i], actual[i]) != 0)
                Assert.fail();
        }
    }

    @DataProvider(name = "points")
    public Object[][] points() {



        return new Object[][]{
                {
                    new Point2D(0.0, 0.0),
                    5,
                    new HashSet<Point2D>() {{ this.add(new Point2D(-2.5, -3.5));
                                                this.add(new Point2D(-2.5, -4.5));
                            this.add(new Point2D(-3.5, -3.5)); }},
                    new HashSet<Point2D>() {{ this.add(new Point2D(-2.5, -3.5)); }}

                },
                {
                        new Point2D(0.0, 0.0),
                        5,
                        new HashSet<Point2D>() {{ this.add(new Point2D(2.0, 2.0));
                            this.add(new Point2D(4.0, 4.0));
                            this.add(new Point2D(4.0, 6.0)); }},
                        new HashSet<Point2D>() {{ this.add(new Point2D(2.0, 2.0)); }}
                },
                {
                        new Point2D(0.0, 0.0),
                        1,
                        new HashSet<Point2D>() {{ this.add(new Point2D(2.0, 2.0));
                            this.add(new Point2D(4.0, 4.0));
                            this.add(new Point2D(4.0, 6.0)); }},
                        new HashSet<Point2D>()
                }

        };
    }

}