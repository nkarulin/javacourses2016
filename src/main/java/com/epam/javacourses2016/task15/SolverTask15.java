package com.epam.javacourses2016.task15;

import com.epam.javacourses2016.Point2D;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

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
        //TODO
        List<LinesForTask15> list = new ArrayList<>();
        double x1, x2, y1, y2, k, b;
        for (Point2D p : points) {
            x1 = p.getX();
            y1 = p.getY();
            for (Point2D p2 : points) {
                x2 = p2.getX();
                y2 = p2.getY();
                k = (y2 - y1) / (x2 - x1);
                b = (x2 * y1 - x1 * y2) / (x2 - x1);
                if (!existInList(k, b, list)) {
                    addLine(k, b, list);
                }
            }
        }
        Iterator<LinesForTask15> iterator = list.iterator();
        LinesForTask15 l;
        while (iterator.hasNext()){
            l=iterator.next();
            if (l.getNumber()<3){
                iterator.remove();
            }
        }
        return null;
    }

    private boolean existInList(double k, double b, List<LinesForTask15> list) {
//        return list.stream()
////                .filter((item -> item.k == k) & (item -> item.b == b))
//                .forEach(item -> item.addNumber())
////                .anyMatch;
        return false;

    }

    private void addLine(double k, double b, List<LinesForTask15> list) {
        list.add(new LinesForTask15(k, b, 1, list.size()));
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
