package com.epam.javacourses2016.task15;

import com.epam.javacourses2016.Point2D;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
        for (Point2D a : points) {
            for (Point2D b : points) {
                if (a.getX() != b.getX() && a.getY() != b.getY()) {
                    Line line = new Line(a, b);
                    lines.add(line);
                }
            }
        }
        Set<ILine> result = new HashSet<>();
        for (Line line : lines) {
         for (Point2D point : points) {
             line.containsDot(point);
             if (line.getPoints().size() > 2) {
                 result.add(line);
             }
         }
        }
        return new IFile(writeFile(output, result));
    }

    private File writeFile(File file, Set<ILine> lines) {
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
