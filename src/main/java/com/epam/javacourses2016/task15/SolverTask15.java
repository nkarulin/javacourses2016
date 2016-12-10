package com.epam.javacourses2016.task15;

import com.epam.javacourses2016.Point2D;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(output));
            Set<Line> lines = new HashSet<>();
            for (Point2D first : points) {
                for (Point2D second : points) {
                    if (!((first.getY() == second.getY()) && (first.getX() == second.getX()))) {
                        Line line = new Line(first, second);
                        for (Point2D point : points) {
                            if (((first.getY() != point.getY()) || (first.getX() != point.getX())) &&
                                    ((second.getY() != point.getY()) || (second.getX() != point.getX())))
                                line.add(point);

                        }
                        if (line.size() > 2) {
                            lines.add(line);
                        }
                    }
                }
            }
            for (Line line : lines
                    ) {
                bw.write(Double.toString(line.getStart().getX()));
                bw.write(" ");
                bw.write(Double.toString(line.getStart().getY()));
                bw.write(" ");
                bw.write(Double.toString(line.getEnd().getX()));
                bw.write(" ");
                bw.write(Double.toString(line.getEnd().getY()));
                bw.write(System.lineSeparator());
            }
            bw.close();
            IFileWithLines filewithline = new FileWithLines(output);
            return filewithline;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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