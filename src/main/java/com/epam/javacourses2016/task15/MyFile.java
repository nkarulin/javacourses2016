package com.epam.javacourses2016.task15;

import com.epam.javacourses2016.Point2D;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MyFile implements SolverTask15.IFileWithLines {
    private File file;

    public MyFile(File file) {
        this.file = file;
    }

    @Override
    public File getFile() {
        return file;
    }

    @Override
    public Set<SolverTask15.ILine> getLines() {
        Set<SolverTask15.ILine> lines = new HashSet<>();
        try (Scanner scanner = new Scanner(new FileReader(file))) {
            ArrayList<Double> params = new ArrayList<>(4);
            while (scanner.hasNextDouble()) {
                params.add(scanner.nextDouble());
                if (params.size() == 4) {
                    Point2D firstPoint = new Point2D(params.get(0), params.get(1));
                    Point2D secondPoint = new Point2D(params.get(2), params.get(3));
                    Line line = new Line(firstPoint, secondPoint);
                    lines.add(line);
                    params.clear();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return lines;
    }

    public void writeIntoFile(Set<Line> result) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Line line : result) {
                for (Point2D point : line.getPoints()) {
                    writer.write(point.getX() + " " + point.getY() + " ");
                }
                writer.write("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
