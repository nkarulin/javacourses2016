package com.epam.javacourses2016.task16;

import com.epam.javacourses2016.Point2D;

import java.io.*;
import java.util.SortedMap;

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
        return null;
    }

    public void writeIntoFile(SortedMap<Point2D, Double> result) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Point2D point2D : result.keySet()) {
                writer.write(point2D.getX() + " " + point2D.getY() + " " + result.get(point2D) + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
