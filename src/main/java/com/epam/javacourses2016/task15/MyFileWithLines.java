package com.epam.javacourses2016.task15;

import com.epam.javacourses2016.Point2D;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MyFileWithLines implements SolverTask15.IFileWithLines {

    private File file;

    public MyFileWithLines(File file) {
        this.file = file;
    }

    public void write(Set<MyLine> lines){

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (MyLine line: lines) {
                StringBuilder sb = new StringBuilder();
                for (Point2D point : line.getPoints()) {
                    sb.append(String.format("%f %f ", point.getX(), point.getY()));
                }
                sb.append('\n');
                writer.write(sb.toString());
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }


    @Override
    public File getFile() {
        return file;
    }

    @Override
    public Set<SolverTask15.ILine> getLines() {
        Set<SolverTask15.ILine> lines = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String str;
            while ((str = reader.readLine()) != null) {
                Scanner scanner = new Scanner(str);

                MyLine line = new MyLine(new Point2D(scanner.nextDouble(),scanner.nextDouble()), new Point2D(scanner.nextDouble(),scanner.nextDouble()));

                while (scanner.hasNextDouble()) {
                    line.getPoints().add(new Point2D(scanner.nextDouble(),scanner.nextDouble()));
                }

                lines.add(line);
            }

        } catch (Exception e) {
            e.getStackTrace();
        }

        return lines;
    }
}
