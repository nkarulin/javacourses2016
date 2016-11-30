package com.epam.javacourses2016.task16;

import com.epam.javacourses2016.Point2D;

import java.io.*;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * На клетчатой бумаге нарисован круг.
 * Вывести в файл описания всех клеток, целиком лежащих внутри круга.
 * Выводить в порядке возрастания расстояния от клетки до центра круга.
 * Использовать класс SortedMap.
 */
public class SolverTask16 implements Serializable {
    /**
     * Осуществляет анализ точек, находя среди них попавших внутрь круга.
     *
     * @param center Точка, в которой расположен центр круга.
     * @param radius Радиус круга.
     * @param output Файл для вывода результатов.
     * @return Файл с результатами анализа.
     */
    IFileWithPoints analyze(Point2D center, int radius, File output) {
        SortedMap<Point2D, Double> points = new TreeMap<>();
        for (int x = (int) (center.getX() - radius); x < (int) (center.getX() + radius); x++) {
            for (int y = (int) (center.getY() - radius); y < (int) (center.getY() + radius); y++) {
                Ceil ceil = new Ceil(new Point2D(x, y));
                if (ceil.isInsideCircle(center, radius)) {
                    points.put(ceil.getCenter(), ceil.getDistanceTo(center.getX(), center.getY()));
                }
            }
        }
        return new IFile(writeFile(output, points));
    }

    public File writeFile(File file, SortedMap<Point2D, Double> points) {
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
        SortedMap<Point2D, Double> getPoints();
    }

    public class IFile implements IFileWithPoints {

        private File file;
        private SortedMap<Point2D, Double> points;

        public IFile(File file) {
            this.file = file;
            points = new TreeMap<>();

            if (file.length() != 0) {
                try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
                    points = (SortedMap<Point2D, Double>) objectInputStream.readObject();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public File getFile() {
            return file;
        }

        @Override
        public SortedMap<Point2D, Double> getPoints() {
            return points;
        }
    }
}
