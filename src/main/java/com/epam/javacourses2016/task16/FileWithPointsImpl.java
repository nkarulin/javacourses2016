package com.epam.javacourses2016.task16;

import com.epam.javacourses2016.Point2D;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

class FileWithPointsImpl implements SolverTask16.IFileWithPoints {

    File myFile;

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

    @Override
    public File getFile() {
        return myFile;
    }

    @Override
    public SortedMap<Point2D, Double> getPoints() {
        SortedMap<Point2D, Double> points;
/*
        try (BufferedReader reader = new BufferedReader(new FileReader(myFile))) {
            String cellString;
            while ((cellString = reader.readLine()) != null) {
                getPoints(cellString);
                points.putAll(getPoints(cellString));
            }

        } catch (Exception e) {

        }
*/
        return null;
    }
/*
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
    }*/

    private void writeOneCell(SolverTask16.Cell cell, BufferedWriter writer) throws IOException {

        String str = String.format("%f %f %f %f %f", cell.distanceToCenter, cell.a, cell.b, cell.c, cell.d);
        writer.write(str);
    }

    private class MyCellComparator implements Comparator<SolverTask16.Cell> {
        @Override
        public int compare(SolverTask16.Cell o1, SolverTask16.Cell o2) {
            return Double.compare(o1.getDistanceToCenter(), o2.getDistanceToCenter());
        }
    }
}
