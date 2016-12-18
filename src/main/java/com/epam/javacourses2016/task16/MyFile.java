package com.epam.javacourses2016.task16;

import com.epam.javacourses2016.Point2D;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.SortedMap;
import java.util.TreeMap;

public class MyFile implements SolverTask16.IFileWithPoints {

    private File file;
    private SortedMap<Point2D, Double> points;

    public MyFile(File file) {
        this.file = file;
        points = new TreeMap<>();

        if (file.length() != 0) {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
                points = (SortedMap<Point2D, Double>) objectInputStream.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public File getFile() {
        return file;
    }

    @Override
    public SortedMap<Point2D, Double> getPoints() {
        return points;
    }
}