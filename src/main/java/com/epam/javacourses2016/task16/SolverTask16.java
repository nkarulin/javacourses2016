package com.epam.javacourses2016.task16;

import com.epam.javacourses2016.Point2D;

import java.io.File;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * На клетчатой бумаге нарисован круг.
 * Вывести в файл описания всех клеток, целиком лежащих внутри круга.
 * Выводить в порядке возрастания расстояния от клетки до центра круга.
 * Использовать класс SortedMap.
 */
public class SolverTask16 {
    /**
     * Осуществляет анализ точек, находя среди них попавших внутрь круга.
     *
     * @param center Точка, в которой расположен центр круга.
     * @param radius Радиус круга.
     * @param output Файл для вывода результатов.
     * @return Файл с результатами анализа.
     */
    IFileWithPoints analyze(Point2D center, int radius, File output) {
        //TODO
        SortedMap<Point2D, Double> points = new TreeMap<>();
        for (int x = (int) (center.getX() - radius); x < (int) (center.getX() + radius); x++) {
            for (int y = (int) (center.getY() - radius); y < (int) (center.getY() + radius); y++) {
                Cell cell = new Cell(new Point2D(x, y));
                if (cell.isInsideCircle(center, radius)) {
                    points.put(cell.getCenter(), cell.getDistanceToPoint(center.getX(), center.getY()));
                }
            }
        }
        return null;
    }

    /**
     * Представляет файл, содержащий информацию о найденных точках.
     */
    interface IFileWithPoints {

        /**
         * @return Файл с результатами анализа.
         */
        File getFile();

        /**
         * Извлекает из файла информацию о хранящихся в нем точках.
         * @return Множество пар: точка + расстояние до центра.
         */
        SortedMap<Point2D, Double> getPoints();
    }
}
