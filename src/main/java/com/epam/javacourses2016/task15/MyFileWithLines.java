package com.epam.javacourses2016.task15;

import com.epam.javacourses2016.Point2D;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by n on 15.12.2016.
 */
public class MyFileWithLines implements SolverTask15.IFileWithLines {
    File myFile;

    @Override
    public File getFile() {
        return myFile;
    }

    @Override
    public Set<SolverTask15.ILine> getLines() {

        Set<SolverTask15.ILine> lines = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(myFile))) {
            String lineString;
            while ((lineString = reader.readLine()) != null) {
                SolverTask15.ILine line = readOneLine(lineString);
                lines.add(line);
            }

        } catch (Exception e) {
            e.getStackTrace();
        }

        return lines;
    }

    public void writeLines(File file, Set<MyLine> lines) {
        myFile = file;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (MyLine line : lines) {
                writeOneLine(line, writer);
                writer.write('\n');
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    private void writeOneLine(MyLine line, BufferedWriter writer) throws IOException {

        String str = "";

        for (Point2D point : line.getPoints()) {
            str += String.format("%f %f ", point.getX(), point.getY());
        }

        writer.write(str);
    }

    private SolverTask15.ILine readOneLine(String string) {
        Scanner scanner = new Scanner(string);
        ArrayList<Double> pointsCoordinates = new ArrayList<>();
        MyLine myLine = new MyLine();
        while (scanner.hasNextDouble()) {
            pointsCoordinates.add(scanner.nextDouble());
        }

        for (int i = 0; i < pointsCoordinates.size(); i += 2) {
            Point2D point = new Point2D(pointsCoordinates.get(i), pointsCoordinates.get(i + 1));
            myLine.getPoints().add(point);
        }
        return myLine;
    }
}
