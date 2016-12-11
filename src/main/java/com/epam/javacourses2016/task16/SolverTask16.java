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
    SortedMap<Cell, Double> cellDoubleSortedMap;
    IFileWithPoints analyze(Point2D center, int radius, File output) throws IOException {
        SortedMap<Point2D, Double> doubleSortedMap = new TreeMap<>();
        cellDoubleSortedMap = new TreeMap<>();

        double x_diff = center.getX() - (int)center.getX();
        double y_diff = center.getY() - (int)center.getY();
        int cell_count = 0;
        Point2D beginPoint;
        double x_begin;
        double y_begin;
        if(Math.abs(x_diff)>=0.25 && Math.abs(x_diff) <= 0.75 && Math.abs(y_diff)>=0.25 && Math.abs(y_diff)<=0.75) {
            cell_count = 2*radius-1;
            x_begin = ((int)(center.getX()/0.5))*0.5 - 0.5*cell_count/2;
            y_begin = ((int)(center.getX()/0.5))*0.5 - 0.5*cell_count/2;
            beginPoint = new Point2D(x_begin,y_begin);
        }
        else {
            cell_count = 2*radius-2;
            x_begin = (int) Math.round(center.getX()) - 0.5*cell_count/2;
            y_begin = (int) Math.round(center.getY()) - 0.5*cell_count/2;
            beginPoint = new Point2D(x_begin,y_begin);
        }
        int j = 0;
        for(int i = 1; i <= cell_count*cell_count; i++) {
            Point2D point1 = new Point2D(beginPoint.getX()-0.5,beginPoint.getY()-0.5);
            Point2D point2 = new Point2D(beginPoint.getX()+0.5,beginPoint.getY()-0.5);
            Point2D point3 = new Point2D(beginPoint.getX()+0.5,beginPoint.getY()+0.5);
            Point2D point4 = new Point2D(beginPoint.getX()-0.5,beginPoint.getY()+0.5);
            Cell cell = new Cell(point1,point2,point3,point4);
            if (cell.isInside(center, radius)) {
                Point2D cellcenter = new Point2D(beginPoint.getX(),beginPoint.getY());
                double dist = cellcenter.getDistanceTo(center);
                cell.setCenter(cellcenter);
                cellDoubleSortedMap.put(cell,dist);
                doubleSortedMap.put(cell.getPoint1(), cell.getPoint1().getDistanceTo(center));
                doubleSortedMap.put(cell.getPoint2(), cell.getPoint2().getDistanceTo(center));
                doubleSortedMap.put(cell.getPoint3(), cell.getPoint3().getDistanceTo(center));
                doubleSortedMap.put(cell.getPoint4(), cell.getPoint4().getDistanceTo(center));
            }
            j++;
            if( j / cell_count == 1) {
                beginPoint = new Point2D(x_begin,y_begin+1);
                j = 0;
            } else beginPoint = new Point2D(beginPoint.getX()+1,beginPoint.getY());
            System.out.println(i);
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

    class Cell implements Comparable<Cell> {

        private Point2D point1;
        private Point2D point2;
        private Point2D point3;
        private Point2D point4;
        private Point2D center;

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

        @Override
        public String toString() {
            return point1 +
                    " " + point2 +
                    " " + point3 +
                    " " + point4 +
                    " " + center.getRadius();
        }

        @Override
        public int compareTo(Cell o) {
            return center.compareTo(o.getCenter());
        }
    }
}
