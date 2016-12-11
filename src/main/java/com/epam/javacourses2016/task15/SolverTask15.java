package com.epam.javacourses2016.task15;

import com.epam.javacourses2016.Point2D;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * На плоскости задано N точек.
 * Вывести в файл описания всех прямых, которые проходят более чем через 2 точки из заданных.
 */
public class SolverTask15 {
    /**
     * Осуществляет анализ переданных точек, вычисляя линии, которые проходят более чем через 2 точки.
     * @param points Множество точек на плоскости.
     * @param output Файл для вывода результатов.
     * @return Файл с результатами анализа.
     */
    IFileWithLines analyze(Set<Point2D> points, File output) {
        Set<Line> lines = new HashSet<>();
        ArrayList<Point2D> allPoints = new ArrayList<>(points);
        int checkedPoints = 0;
        for (Point2D point : points) {
            checkedPoints++;
            for (int i = checkedPoints; i < points.size(); i++) {
                Line newLine = new Line(point, allPoints.get(i));
                if (checkPoints(newLine, points)) {
                    lines.add(newLine);
                }
            }
        }
        MyFile file = new MyFile(output);
        file.writeIntoFile(lines);
        return file;
    }

    boolean checkPoints(Line line, Set<Point2D> points) {
        for (Point2D point : points) {
            if (line.isMorePoints(point)) {
                return true;
            }
        }
        return false;
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
         * @return Множество линий, найденных в результате анализа.
         */
        Set<ILine> getLines();
    }

    /**
     * Прямая, заданная точками, входящими в исходное множество.
     */
    interface ILine {

        /** @return Точки, через которые проходит прямая */
        Set<Point2D> getPoints();
    }
}
