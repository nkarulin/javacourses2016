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

/**
 * На клетчатой бумаге нарисован круг.
 * Вывести в файл описания всех клеток, целиком лежащих внутри круга.
 * Выводить в порядке возрастания расстояния от клетки до центра круга.
 * Использовать класс SortedMap.
 */
public class SolverTask16 {
    private static final double CELL_SIZE = 0.5;

    /**
     * Осуществляет анализ точек, находя среди них попавших внутрь круга.
     *
     * @param center Точка, в которой расположен центр круга.
     * @param radius Радиус круга.
     * @param output Файл для вывода результатов.
     * @return Файл с результатами анализа.
     */
    IFileWithPoints analyze(Point2D center, int radius, File output) {
        SortedMap<Point2D, Double> result = new TreeMap<Point2D, Double>(new Comparator<Point2D>() {
            @Override
            public int compare(Point2D o1, Point2D o2) {
                //int result = (int) (length(o1, center) * 10 - 10 * length(o2, center)) / 10;
                int res = (int) (length(o1, center) * 100 - length(o2, center) * 100);
                return o1.getX() == o2.getX() && o1.getY() == o2.getY() ? 0 : res != 0 ? res : -1;
            }
        });

        if (within(center, radius, center))
            result.put(center, Double.valueOf(0));

        for (double side = 2 * CELL_SIZE; side < radius * 2; side += CELL_SIZE * 2) {
            result.putAll(intersectionWithSquare(center, radius, side));
        }
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(output));
            for (Map.Entry<Point2D, Double> entry : result.entrySet()) {

                bw.write(Double.toString(entry.getKey().getX()));
                bw.write(" ");
                bw.write(Double.toString(entry.getKey().getY()));
                bw.write(" ");
                bw.write(Double.toString(entry.getValue()));
                bw.write(System.lineSeparator());
            }
            bw.close();
            IFileWithPoints file = new FileWithPoints(output);
            return file;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Возвращает клетки из пересечения окружности и квадрата
     *
     * @param center Точка, в которой расположен центр круга.
     * @param radius Радиус круга.
     * @param side   Сторона квадрата.
     * @return Множество пар: точка + расстояние до центра.
     */

    SortedMap<Point2D, Double> intersectionWithSquare(Point2D center, int radius, double side) {
        SortedMap<Point2D, Double> result = new TreeMap<Point2D, Double>(new Comparator<Point2D>() {
            @Override
            public int compare(Point2D o1, Point2D o2) {
                int res = (int) (length(o1, center) * 100 - length(o2, center) * 100);
                return o1.getX() == o2.getX() && o1.getY() == o2.getY() ? 0 : res != 0 ? res : -1;
            }
        });
        for (double x = center.getX() - side / 2; x < center.getX(); x += CELL_SIZE) {
            Point2D candidateX = new Point2D(x, center.getY() + side / 2);
            if (within(center, radius, candidateX)) {
                Double len = length(center, candidateX);
                result.put(candidateX, len);
                result.put(new Point2D(x, center.getY() - side / 2), len);
                result.put(new Point2D(Math.abs(x)+2*center.getX(), candidateX.getY()), len);
                result.put(new Point2D(Math.abs(x)+2*center.getX(), center.getY() - side / 2), len);
            }

        }
        Point2D candidateX = new Point2D(center.getX(), center.getY() + side / 2);
        if (within(center, radius, candidateX)) {
            Double len = length(center, candidateX);
            result.put(candidateX, len);
            result.put(new Point2D(center.getX(), center.getY() - side / 2), len);
        }
        for (double y = center.getY() - side / 2+CELL_SIZE; y < center.getY(); y += CELL_SIZE) {
            Point2D candidateY = new Point2D(center.getX() + side / 2, y);
            if (within(center, radius, candidateY)) {
                Double len = length(center, candidateY);
                result.put(candidateY, len);
                result.put(new Point2D(center.getX() - side / 2, y), len);
                result.put(new Point2D(candidateY.getX(),Math.abs(y)+2*center.getY()), len);
                result.put(new Point2D(center.getX() - side / 2, Math.abs(y)+2*center.getY()), len);
            }

        }
        Point2D candidateY = new Point2D(center.getX()-side/2, center.getY());
        if (within(center, radius, candidateY)) {
            Double len = length(center, candidateY);
            result.put(candidateY, len);
            result.put(new Point2D(center.getX()+side/2, candidateY.getY()), len);
        }
        return result;
    }

    /**
     * Проверяет, входит ли клетка в круг
     *
     * @param center    Точка, в которой расположен центр круга.
     * @param radius    Радиус круга.
     * @param candidate Файл для вывода результатов.
     * @return true, если точка полностью внутри круга, иначе false
     */
    private boolean within(Point2D center, int radius, Point2D candidate) {
        if (length(center, candidate) >= radius) return false;
        Cell cell = new Cell(candidate, CELL_SIZE);
        return length(cell.getLowerLeftCorner(), center) < radius &&
                length(cell.getLowerRightCorner(), center) < radius &&
                length(cell.getUpperLeftCorner(), center) < radius &&
                length(cell.getUpperRightCorner(), center) < radius;
    }

    /**
     * @param first  первая точка отрезка
     * @param second вторая точка отрезка
     * @return возвращает длину отрезка
     */
    private double length(Point2D first, Point2D second) {
        return Math.sqrt(Math.pow(second.getY() - first.getY(), 2) + Math.pow(second.getX() - first.getX(), 2));
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