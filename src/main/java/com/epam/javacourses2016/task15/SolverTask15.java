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
     *
     * @param points Множество точек на плоскости.
     * @param output Файл для вывода результатов.
     * @return Файл с результатами анализа.
     */
    IFileWithLines analyze(Set<Point2D> points, File output) {

        Set<MyLine> lines = new HashSet<>();
        ArrayList<Point2D> arrayOfPoints = new ArrayList<>(points);

        for (int i = 0; i < points.size(); i++) {
            for (int j = i; j < points.size() - 1; j++) {
                MyLine line = new MyLine(arrayOfPoints.get(j), arrayOfPoints.get(j + 1));

                for (Point2D point : points) {
                    if (line.intersect(point)) {
                        line.points.add(point);
                    }
                }

                boolean canAdd = true;
                for (MyLine testLine : lines) {
                    if (testLine.getPoints().containsAll(line.points)) {
                        canAdd = false;
                    }
                }

                if (canAdd && line.getPoints().size() > 2) {
                    lines.add(line);
                }
            }
        }

        MyFileWithLines fileWithLines = new MyFileWithLines();
        fileWithLines.writeLines(output, lines);
        return fileWithLines;
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
