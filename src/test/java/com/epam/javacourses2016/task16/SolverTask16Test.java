package com.epam.javacourses2016.task16;

import com.epam.javacourses2016.Point2D;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by kodoo on 13.11.16.
 */
public class SolverTask16Test {
    @Test(enabled = false, dataProvider = "circle")
    public void testAnalyze(Point2D center, int radius, int result, String fileName) throws Exception {
        SolverTask16 solver = new SolverTask16();
        String path = this.getClass().getResource(fileName).getPath();
        Map<Point2D, Double> map = loadPoints(path);

        //solver.analyze(center, radius, file);
    }

    @DataProvider(name = "circle")
    public Object[][] circle() {
        return new Object[][]{
                {new Point2D(0, 0), 2, 4, "fileToWriteResult.txt"},
                {new Point2D(1, 0), 2},
                {new Point2D(1, 1), 2}
        };
    }

    static SortedMap<Point2D, Double> loadPoints(String filePath) throws IOException {
        SortedMap<Point2D, Double> map = new TreeMap<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextInt()) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                double range = scanner.nextInt();

                Point2D point = new Point2D(x, y);
                map.put(point, range);
            }
        }
        return map;
    }
}