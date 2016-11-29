package com.epam.javacourses2016.task16;

import com.epam.javacourses2016.Point2D;

import java.io.*;
import java.util.*;

public class FileWithPointsImpl implements SolverTask16.IFileWithPoints {

    File myFile;

    @Override
    public File getFile() {
        return myFile;
    }

    @Override
    public SortedMap<Point2D, Double> getPoints() {
        SortedMap<Point2D, Double> points = new TreeMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(myFile))) {
            String cellString;
            while ((cellString = reader.readLine()) != null) {
                points.putAll(readPoints(cellString));
            }

        } catch (Exception e) {
            e.getStackTrace();
        }

        return points;
    }

    private Map<Point2D, Double> readPoints(String points) throws IOException {
        Scanner scanner = new Scanner(points);
        Map<Point2D, Double> cellsPoints = new HashMap<>();
        Double distanceToCenter = scanner.nextDouble();

        double xCoord = 0;
        double yCoord = 0;
        int index = 0;

        while (scanner.hasNextDouble()) {
            if (index == 0) {
                xCoord = scanner.nextDouble();
                index++;
            } else {
                yCoord = scanner.nextDouble();
                cellsPoints.put(new Point2D(xCoord, yCoord), distanceToCenter);
                index = 0;
            }
        }

        return cellsPoints;
    }

    public void writeFile(Map<SolverTask16.Cell, Integer> cells, File file) {
        myFile = file;
        MyCellComparator comparator = new MyCellComparator();
        SortedMap<SolverTask16.Cell, Integer> treeCells = new TreeMap<>(comparator);
        treeCells.putAll(cells);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (SolverTask16.Cell cell : treeCells.keySet()) {
                writeOneCell(cell, writer);
                writer.write('\n');
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

    }

    private void writeOneCell(SolverTask16.Cell cell, Writer writer) throws IOException {
        String distanceToCell = Double.toString(cell.distanceToCenter);

        writer.write(distanceToCell + " ");
        writeOnePoint(cell.a, writer);
        writeOnePoint(cell.b, writer);
        writeOnePoint(cell.c, writer);
        writeOnePoint(cell.d, writer);
    }

    private void writeOnePoint(Point2D point, Writer writer) throws IOException {
        String str = String.format("%f %f", point.getX(), point.getY());
        writer.write(str);
    }

    private class MyCellComparator implements Comparator<SolverTask16.Cell> {
        @Override
        public int compare(SolverTask16.Cell o1, SolverTask16.Cell o2) {
            return Double.compare(o1.getDistanceToCenter(), o2.getDistanceToCenter());
        }
    }
}
