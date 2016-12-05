package com.epam.javacourses2016.task16;

import com.epam.javacourses2016.Point2D;
import com.epam.javacourses2016.task15.Line;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by Рамиль on 30.11.2016.
 */
public class MyFile implements SolverTask16.IFileWithPoints {

    private File file;

    @Override
    public File getFile() {
        return file;
    }

    @Override
    public SortedMap<Point2D, Double> getPoints() {
        SortedMap<Point2D, Double> cells = new TreeMap<>();
        try (Scanner scanner = new Scanner(new FileReader(file))) {
            ArrayList<Double> coords = new ArrayList<>();
            while (scanner.hasNext()) {
                if (scanner.hasNextDouble()) {
                    coords.add(scanner.nextDouble());
                }
                final int DOT_COORDINATES_AND_DIST = 3;
                if (coords.size() == DOT_COORDINATES_AND_DIST) {
                    final int X = 0;
                    final int Y = 1;
                    final int DIST = 2;
                    Point2D dot = new Point2D(coords.get(X), coords.get(Y));
                    cells.put(dot, coords.get(DIST));
                    coords.clear();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return cells;
    }

    public void writeCells(File file, SortedMap<Point2D, Double> cells) {
        this.file = file;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Point2D point : cells.keySet()) {
                writer.write(point.getX() + " " + point.getY() + " " + cells.get(point));
                writer.write('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
