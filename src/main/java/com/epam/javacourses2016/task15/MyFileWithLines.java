package com.epam.javacourses2016.task15;

import com.epam.javacourses2016.Point2D;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MyFileWithLines implements SolverTask15.IFileWithLines {
    File myFile;

    private void writeOneLine(MyLine line, BufferedWriter writer) throws IOException {

        String str = "";
        int pointCounter = 3;

        for (Point2D point : line.getPoints()) {
            str += String.format("%f %f ", point.getX(), point.getY());
        }

        writer.write(str);
    }

    public void writeLines(File file, Set<MyLine> lines) {
        myFile = file;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            int iterator = 1;
            for (MyLine line : lines) {
                writeOneLine(line, writer);
                writer.write('\n');
                iterator++;
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    @Override
    public File getFile() {
        return null;
    }

    @Override
    public Set<SolverTask15.ILine> getLines() {

        Set<SolverTask15.ILine> lines = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(myFile))) {
            String lineString;
            while ((lineString = reader.readLine()) != null) {
                SolverTask15.ILine line = getLine(lineString);
                lines.add(line);
            }

        } catch (Exception e) {

        }

        return lines;
    }

    private SolverTask15.ILine getLine(String string) {
        Scanner scanner = new Scanner(string);
        ArrayList<Double> pointsCoords = new ArrayList<>();
        MyLine myLine = new MyLine();
        while (scanner.hasNextDouble()) {
            pointsCoords.add(scanner.nextDouble());
        }

        for (int i = 0; i < pointsCoords.size(); i += 2) {
            Point2D point = new Point2D(pointsCoords.get(i), pointsCoords.get(i + 1));
            myLine.getPoints().add(point);
        }
        return myLine;
    }
}