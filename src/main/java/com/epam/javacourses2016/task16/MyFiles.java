package com.epam.javacourses2016.task16;

import com.epam.javacourses2016.Point2D;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class MyFiles implements SolverTask16.IFileWithPoints {
    private File file;

    public MyFiles(File file) {
        this.file = file;
    }

    @Override
    public File getFile() {
        return file;
    }

    @Override
    public SortedMap<Point2D, Double> getPoints() {
        SortedMap<Point2D, Double> points = new TreeMap<>();
        try(Scanner scanner = new Scanner(new FileReader(file))) {
            ArrayList<Double> params = new ArrayList<>(3);
            while (scanner.hasNext()) {
                params.add(scanner.nextDouble());
                if (params.size() == 3) {
                    points.put(new Point2D(params.get(0), params.get(1)), params.get(2));
                    params.clear();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return points;
    }

    public void writeIntoFile(SortedMap<Cell, Double> result) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Cell cell : result.keySet()) {
                writer.write(cell.getCenterOfCell().getX() + " "
                        + cell.getCenterOfCell().getY() + " "
                        + result.get(cell) + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
