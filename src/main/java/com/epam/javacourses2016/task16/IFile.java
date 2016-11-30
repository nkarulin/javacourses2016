package com.epam.javacourses2016.task16;

import com.epam.javacourses2016.Point2D;

import java.io.*;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by Рамиль on 30.11.2016.
 */
public class IFile implements SolverTask16.IFileWithPoints {

    private File file;
    private SortedMap<Point2D, Double> points;

    public IFile(File file) {
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
