package com.epam.javacourses2016.task16;

import com.epam.javacourses2016.Point2D;

import java.io.*;
import java.util.*;

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

    IFileWithPoints analyze(Point2D center, int radius, File output) throws IOException {
        SortedMap<Point2D, Double> doubleSortedMap = new TreeMap<>(new Comparator<Point2D>() {
            @Override
            public int compare(Point2D o1, Point2D o2) {
                if (o1.getX() < o2.getX())
                    return -1;
                if (o1.getX() > o2.getX())
                    return 1;
                if (o1.getY() < o2.getY())
                    return -1;
                if (o1.getY() > o2.getY())
                    return 1;
                return 0;
            }
        });
        SortedMap<Cell, Double> cellDoubleSortedMap = new TreeMap<>(new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                if(o1.getRadius() < o2.getRadius())
                    return -1;
                if(o1.getRadius() > o2.getRadius())
                    return 1;
                else {
                    if (o1.getCenter().getX() < o2.getCenter().getX())
                        return -1;
                    if (o1.getCenter().getX() > o2.getCenter().getX())
                        return 1;
                    if (o1.getCenter().getY() < o2.getCenter().getY())
                        return -1;
                    if (o1.getCenter().getY() > o2.getCenter().getY())
                        return 1;
                    return 0;
                }
            }
        });
        int x_nearest = (int) Math.round(center.getX());
        int y_nearest = (int) Math.round(center.getY());
        for(int x = x_nearest - radius; x < x_nearest + radius; x++) {
            for(int y= y_nearest - radius; y < y_nearest + radius; y++) {
                Point2D point1 = new Point2D(x,y);
                Point2D point2 = new Point2D(x+1,y);
                Point2D point3 = new Point2D(x,y+1);
                Point2D point4 = new Point2D(x+1,y+1);
                Cell cell = new Cell(point1,point2,point3,point4);
                if (cell.isInside(center, radius)) {
                    Point2D cellcenter = new Point2D(x+0.5,y+0.5);
                    double dist = cellcenter.getDistanceTo(center);
                    cell.setCenter(cellcenter);
                    cell.setRadius(dist);
                    cellDoubleSortedMap.put(cell,dist);
                    doubleSortedMap.put(cell.getPoint1(), cell.getPoint1().getDistanceTo(center));
                    doubleSortedMap.put(cell.getPoint2(), cell.getPoint2().getDistanceTo(center));
                    doubleSortedMap.put(cell.getPoint3(), cell.getPoint3().getDistanceTo(center));
                    doubleSortedMap.put(cell.getPoint4(), cell.getPoint4().getDistanceTo(center));
                }
            }
        }
        FileWithPoints fileWithPoints = new FileWithPoints(output,doubleSortedMap);
        writeToFile(fileWithPoints,cellDoubleSortedMap);
        return fileWithPoints;
    }

    private void writeToFile(FileWithPoints fileWithPoints, SortedMap<Cell,Double> cellDoubleSortedMap) throws IOException {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileWithPoints.getFile()))) {
            for(Map.Entry<Cell,Double> cellDoubleEntry : cellDoubleSortedMap.entrySet()) {
                bufferedWriter.write(String.valueOf(cellDoubleEntry.getKey()) + "\n");
            }
        }
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

    public class FileWithPoints implements IFileWithPoints {

        private File file;
        private SortedMap<Point2D, Double> points;

        public FileWithPoints(File file, SortedMap<Point2D,Double> points) {
            this.file = file;
            this.points = points;
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

    class Cell  {

        private Point2D point1;
        private Point2D point2;
        private Point2D point3;
        private Point2D point4;
        private Point2D center;
        private double radius;

        public Cell(Point2D point1, Point2D point2, Point2D point3, Point2D point4) {
            this.point1 = point1;
            this.point2 = point2;
            this.point3 = point3;
            this.point4 = point4;
        }

        public Point2D getPoint1() {
            return point1;
        }

        public Point2D getPoint2() {
            return point2;
        }

        public Point2D getPoint3() {
            return point3;
        }

        public Point2D getPoint4() {
            return point4;
        }

        public Point2D getCenter() {
            return center;
        }

        public void setCenter(Point2D center) {
            this.center = center;
        }

        public boolean isInside(Point2D center, int radius) {
            return point1.compareWithRadius(center, radius) &&
                    point2.compareWithRadius(center, radius) &&
                    point3.compareWithRadius(center, radius) &&
                    point4.compareWithRadius(center, radius);
        }

        public void setRadius(double radius) {
            this.radius = radius;
        }

        public double getRadius() {
            return radius;
        }

        @Override
        public String toString() {
            return point1 +
                    " " + point2 +
                    " " + point3 +
                    " " + point4 +
                    " " + radius;
        }

    }
}
