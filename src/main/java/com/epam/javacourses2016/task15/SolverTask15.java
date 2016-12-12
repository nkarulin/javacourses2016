package com.epam.javacourses2016.task15;

import com.epam.javacourses2016.Point2D;


import java.awt.geom.Line2D;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * На плоскости задано N точек.
 * Вывести в файл описания всех прямых, которые проходят более чем через 2 точки из заданных.
 */
public class SolverTask15 {
    /**
     * Осуществляет анализ переданных точек, вычисляя линии, которые проходят более чем через 2 точки.
     *
     * @param points Множество точек на плоскости.
     * @param output Файл для вывода результатов.
     * @return Файл с результатами анализа.
     */


    IFileWithLines analyze(Set<Point2D> points, File output) {
        Map<Line, Integer> linesMap = new HashMap<>();
        for (Point2D firstPoint : points) {
            for (Point2D secondPoint : points) {
                if (firstPoint.equals(secondPoint)) {
                    continue;
                }
                Line line = new Line(firstPoint, secondPoint);
                linesMap.put(line, 2);
            }
        }
        Set<ILine> resultSet = new TreeSet<>();
        for (Map.Entry<Line, Integer> lineEntry : linesMap.entrySet()) {
            for (Point2D point : points) {
                boolean isNotLineEnd = !lineEntry.getKey().getA().equals(point) && !lineEntry.getKey().getB().equals(point);
                if (isNotLineEnd && intersects(lineEntry.getKey(), point) && !resultSet.contains(lineEntry.getKey())) {
                    resultSet.add(lineEntry.getKey());
                }
            }
        }
        return new MyFile(writeFile(output, resultSet));

    }

    private boolean intersects(Line line, Point2D point) {
        return Line2D.ptLineDist(line.getA().getX(), line.getA().getY(), line.getB().getX(), line.getB().getY(), point.getX(), point.getY()) == 0.0;
    }

    private File writeFile(File file, Set<ILine> lines) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    /**
     * Представляет файл, содержащий информацию о найденных линиях.
     */
    interface IFileWithLines {

        /**
         * @return Файл с результатами анализа.
         */
        File getFile();

        /**
         * Извлекает из файла информацию о хранящихся в нем линиях.
         *
         * @return Множество линий, найденных в результате анализа.
         */
        Set<ILine> getLines();
    }

    /**
     * Прямая, заданная точками, входящими в исходное множество.
     */
    interface ILine {

        /**
         * @return Точки, через которые проходит прямая
         */
        Set<Point2D> getPoints();
    }
}
