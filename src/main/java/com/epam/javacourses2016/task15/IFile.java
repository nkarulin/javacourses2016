package com.epam.javacourses2016.task15;

import com.epam.javacourses2016.Point2D;

import java.io.*;
import java.util.*;

/**
 * Created by Рамиль on 30.11.2016.
 */
public class IFile implements SolverTask15.IFileWithLines {

    private File file;

    @Override
    public File getFile() {
        return file;
    }

    @Override
    public Set<SolverTask15.ILine> getLines() {
        Set<SolverTask15.ILine> lines = new HashSet<>();
        try (Scanner scanner = new Scanner(new FileReader(file))) {
            ArrayList<Double> lineDots = new ArrayList<>();
            while (scanner.hasNext()) {
                if (scanner.hasNextDouble()) {
                    lineDots.add(scanner.nextDouble());
                }
                final int MAX_LINE_COORDINATES = 4;
                if (lineDots.size() == MAX_LINE_COORDINATES) {
                    final int A_X_LINE_COORDINATE = 0;
                    final int A_Y_LINE_COORDINATE = 1;
                    final int B_X_LINE_COORDINATE = 2;
                    final int B_Y_LINE_COORDINATE = 3;
                    Point2D a = new Point2D(lineDots.get(A_X_LINE_COORDINATE), lineDots.get(A_Y_LINE_COORDINATE));
                    Point2D b = new Point2D(lineDots.get(B_X_LINE_COORDINATE), lineDots.get(B_Y_LINE_COORDINATE));
                    Line line = new Line(a,b);
                    lines.add(line);
                    lineDots.clear();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public void writeLines(File file, Set<Line> lines) {
        this.file = file;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Line line : lines) {
                for (Point2D point : line.getPoints()) {
                    writer.write(point.getX() + " " + point.getY() + " ");
                }
                writer.write('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
