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

    static IFileWithPoints analyze(Point2D center, int radius) {
        SortedMap<Integer, Cell> cells = new TreeMap<>();
        int cellCount = 0;

        for (int indexX = -radius; indexX < radius; indexX++) {
            for (int indexY = -radius; indexY < radius; indexY++) {

                Point2D point1 = new Point2D(indexX, indexY);
                Point2D point2 = new Point2D(indexX + 1, indexY);
                Point2D point3 = new Point2D(indexX, indexY + 1);
                Point2D point4 = new Point2D(indexX + 1, indexY + 1);

                if (insideCircle(point1, radius, center) && insideCircle(point2, radius, center) &&
                        insideCircle(point3, radius, center) && insideCircle(point4, radius, center)) {

                    Cell newCell = new Cell(point1, point2, point3, point4);
                    newCell.countDistance(center);
                    cells.put(cellCount, newCell);
                    cellCount++;
                }
            }
        }

        return null;
    }

    static class Cell {
        Point2D a;
        Point2D b;
        Point2D c;
        Point2D d;
        double distanceToCenter;

        public Cell(Point2D a, Point2D b, Point2D c, Point2D d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }

        public void countDistance(Point2D point) {
            double distance1 = distance(point, a);
            double distance2 = distance(point, b);
            double distance3 = distance(point, c);
            double distance4 = distance(point, d);

            distanceToCenter = (distance1 > distance2) ?
                    distance1 : (distance2 > distance3) ?
                    distance2 : (distance3 > distance4) ?
                    distance3 : distance4;

        }

        private double distance(Point2D point1, Point2D point2) {
            double value = Math.sqrt(Math.pow(point1.getX() - point2.getX(), 2) +
                    Math.pow(point1.getY() - point2.getY(), 2));

            return value;
        }
    }

    public static void main(String[] args) {
        Point2D point = new Point2D(0, 0);
        analyze(point, 1);
    }

    private static boolean insideCircle(Point2D point, int radius, Point2D center) {
        boolean inside = true;
        double value = Math.pow(point.getX() - center.getX(), 2) + Math.pow(point.getY() - center.getY(), 2);
        if (value > Math.pow(radius, 2)) {
            inside = false;
        }
        return inside;
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
         *
         * @return Множество пар: точка + расстояние до центра.
         */
        SortedMap<Point2D, Double> getPoints();
    }
}
