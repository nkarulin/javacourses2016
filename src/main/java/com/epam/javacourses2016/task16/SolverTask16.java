package com.epam.javacourses2016.task16;

import com.epam.javacourses2016.Point2D;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

/**
 * На клетчатой бумаге нарисован круг.
 * Вывести в файл описания всех клеток, целиком лежащих внутри круга.
 * Выводить в порядке возрастания расстояния от клетки до центра круга.
 * Использовать класс SortedMap.
 */
public class SolverTask16 {

    IFileWithPoints analyze(Point2D center, int radius, File output) {
        Map<Point2D, Double> points = new TreeMap<>();
        for (int x = (int) (center.getX() - radius); x < (int) (center.getX() + radius); x++) {
            for (int y = (int) (center.getY() - radius); y < (int) (center.getY() + radius); y++) {
                Cell cell = new Cell(new Point2D(x, y));
                if (cell.isInCircle(center, radius)) {
                    points.put(cell.getCenter(), cell.distanceToPoint(center.getX(), center.getY()));
                }
            }
        }
        return new MyFile(writeFile(output, points));
    }

    public File writeFile(File file, Map<Point2D, Double> points) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(points);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
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
        Map<Point2D, Double> getPoints();
    }
}
