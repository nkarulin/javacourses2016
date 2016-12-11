package com.epam.javacourses2016.task15;

import com.epam.javacourses2016.Point2D;

import java.awt.*;
import java.io.*;
import java.util.*;

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
    IFileWithLines analyze(Set<Point2D> points, File output) throws IOException {
        Set<ILine> lines = new HashSet<>();
        Set<ILine> result = new LineSet();
        for(Point2D p1 : points) {
            for(Point2D p2 : points) {
                if(!p1.equals(p2)) {
                    ILine line = new Line(p1,p2);
                    Set<Point2D> set = new HashSet<>();
                    set.add(p1);
                    set.add(p2);
                    line.setPoint2DS(set);
                    lines.add(line);
                }
            }
        }

        for (ILine line : lines) {
            for (Point2D point2D : points) {
                if (!point2D.equals(line.getPoint2D1()) && !point2D.equals(line.getPoint2D2())) {
                    if (isLineContain(line, point2D)) {
                        line.addPointToSet(point2D);
                    }
                }
            }
            if (line.getPoints().size() > 2)
                result.add(line);

        }

        IFileWithLines fileWithLines = new FilesLines(output,result);
        printToFile(output,result);
        return fileWithLines;
    }

    private void printToFile(File file, Set<ILine> lines) throws IOException {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for(ILine line : lines) {
                for(Point2D point2D : line.getPoints()) {
                    bufferedWriter.write(point2D.getX() + " " + point2D.getY() + "; ");
                }
                bufferedWriter.write("\n");
            }
        }
    }

    private boolean isLineContain(ILine line, Point2D point2D) {
        return ( (line.getPoint2D1().getY() - line.getPoint2D2().getY())*point2D.getX() + (line.getPoint2D2().getX() - line.getPoint2D1().getX())*point2D.getY()
                + (line.getPoint2D1().getX() * line.getPoint2D2().getY() - line.getPoint2D2().getX() * line.getPoint2D1().getY()) ) == 0;
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

        void setPoint2DS(Set<Point2D> set);

        Point2D getPoint2D1();

        Point2D getPoint2D2();

        void addPointToSet(Point2D point2D);
    }

    class LineSet extends HashSet<ILine> {
        @Override
        public boolean add(ILine line) {
            for(ILine line1 : this) {
                if(isIdenticalHashSet(line1.getPoints(),line.getPoints()))
                    return false;
            }
            return super.add(line);
        }
        public boolean isIdenticalHashSet  (Set<Point2D> h1, Set<Point2D> h2) {
            if ( h1.size() != h2.size() ) {
                return false;
            }
            HashSet<Point2D> clone = new HashSet<Point2D>(h2); // just use h2 if you don't need to save the original h2
            Iterator it = h1.iterator();
            while (it.hasNext() ){
                Point2D point2D = (Point2D)it.next();
                if (clone.contains(point2D)){ // replace clone with h2 if not concerned with saving data from h2
                    clone.remove(point2D);
                } else {
                    return false;
                }
            }
            return true; // will only return true if sets are equal
        }
    }

    class Line implements ILine {

        private Point2D point2D1;
        private Point2D point2D2;

        protected Set<Point2D> point2DS;

        public Line( Point2D point2D1, Point2D point2D2) {
            this.point2D1 = point2D1;
            this.point2D2 = point2D2;
        }

        public Point2D getPoint2D1() {
            return point2D1;
        }

        public Point2D getPoint2D2() {
            return point2D2;
        }

        @Override
        public Set<Point2D> getPoints() {
            return point2DS;
        }

        public void addPointToSet(Point2D point2D) {
            point2DS.add(point2D);
        }

        public void setPoint2DS(Set<Point2D> point2DS) {
            this.point2DS = point2DS;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Line line = (Line) o;

            return !point2DS.containsAll(line.getPoints()) && (point2DS != null ? point2DS.equals(line.point2DS) : line.point2DS == null);
        }

        @Override
        public int hashCode() {
            return point2DS != null ? point2DS.hashCode() : 0;
        }
    }

    class FilesLines implements IFileWithLines {

        private Set<ILine> lines;

        private File file;

        public FilesLines(File file, Set<ILine> lines) {
            this.file = file;
            this.lines = lines;
        }

        @Override
        public File getFile() {
            return file;
        }

        @Override
        public Set<ILine> getLines() {
            return lines;
        }

    }
}
