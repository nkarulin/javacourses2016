package com.epam.javacourses2016.task15;

import com.epam.javacourses2016.Point2D;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

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
        HashSet<Line> lines = new HashSet<>();
        FileWithLines file = new FileWithLines(output);

        points.stream().forEach((p1) -> {
            points.stream().forEach((p2) -> {
                if (!p1.equals(p2)){
                    lines.add(new Line(p1, p2));
                }
            });
        });

        lines.stream().forEach((l) -> {
            points.stream().forEach((p) -> {
                if (l.contains(p)) l.addPoint(p);
            });
            if (l.getPoints().size() > 2) file.addLine(l);
        });

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

    private class FileWithLines implements IFileWithLines{
        private File file;
        private Set<ILine> lines;

        public FileWithLines(File file) {
            lines = new HashSet<>();
            this.file = file;
        }

        public void addLine(Line line){
            lines.add(line);
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

    /**
     * Прямая, заданная точками, входящими в исходное множество.
     */
    interface ILine {

        /** @return Точки, через которые проходит прямая */
        Set<Point2D> getPoints();
    }

    private class Line implements ILine {
        //коэффициенты уравнения прямой вида ax + b
        private Double a;
        private Double b;
        private HashSet<Point2D> points;

        public Line(Point2D first, Point2D second) {
            this.a = (first.getY() - second.getY())/(first.getX() - second.getX());
            this.b = (second.getY() * first.getX() - first.getY() * second.getX())/(first.getX() - second.getX());
            points = new HashSet<>();
            points.add(first);
            points.add(second);
        }

        @Override
        public Set<Point2D> getPoints() {
            return points;
        }

        public boolean contains(Point2D point){
            if (a * point.getX() + b == point.getY()) return true;
            return false;
        }

        public void addPoint(Point2D point){
            points.add(point);
        }
    }
}
