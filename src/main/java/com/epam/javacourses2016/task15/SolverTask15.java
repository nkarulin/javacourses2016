package com.epam.javacourses2016.task15;

import com.epam.javacourses2016.Point2D;
import com.epam.javacourses2016.Segment;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
        List<Point2D> pointsList = points.stream().collect(Collectors.toList());
        int ind = 1;
        for(int i = 0; i < pointsList.size(); i++) {
            for(int j = i + 1; j < pointsList.size(); j++) {
                Line line = new Line(new Segment(pointsList.get(i), pointsList.get(j)));
                if (line.belongs(pointsList.get(j)))
                    lines.add(line);
            }
        }
        FileWithLines file = new FileWithLines(output);
        try {
            file.writeToFile(lines);
        }
        catch (Exception ex) {
            ex.printStackTrace();
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
