package com.epam.javacourses2016.task15;

import com.epam.javacourses2016.Point2D;
import com.epam.javacourses2016.Segment;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by GiulioRM on 12/13/2016.
 */
public class FileWithLines implements SolverTask15.IFileWithLines {

    private File file;
    public FileWithLines(File file) {
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

            while (scanner.hasNextDouble()) {
                Point2D firstPoint = new Point2D(scanner.nextDouble(), scanner.nextDouble());
                Point2D secondPoint = new Point2D(scanner.nextDouble(), scanner.nextDouble());
                Line line = new Line(new Segment(firstPoint, secondPoint));
                lines.add(line);
            }
        } catch (Exception e) {
        }
        return lines;
    }

    public void writeToFile(Set<Line> result) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Line line : result) {
                for (Point2D point : line.getPoints()) {
                    writer.write(point.getX() + " " + point.getY() + " ");
                }
                writer.write("\n");
            }
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
    }
}
