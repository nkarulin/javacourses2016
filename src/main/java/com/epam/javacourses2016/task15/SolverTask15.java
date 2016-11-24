package com.epam.javacourses2016.task15;

import com.epam.javacourses2016.Point2D;

import java.awt.geom.Line2D;
import java.io.*;
import java.util.*;

/**
 * На плоскости задано N точек.
 * Вывести в файл описания всех прямых, которые проходят более чем через 2 точки из заданных.
 */
public class SolverTask15 implements Serializable{
    /*/**
     * Осуществляет анализ переданных точек, вычисляя линии, которые проходят более чем через 2 точки.
     * @param points Множество точек на плоскости.
     * @param output Файл для вывода результатов.
     * @return Файл с результатами анализа.
     */
    IFileWithLines analyze(Set<Point2D> points, File output) {
        Map<Line, Integer> linesMap = new HashMap<>();
        for (Point2D firstPoint : points) {
            for (Point2D secondPoint : points) {
                if (firstPoint.equals(secondPoint)) {
                    continue;
                }
                Line line = new Line(firstPoint, secondPoint);
                linesMap.put(line, 2);
            }
        }
        Set<ILine> resultMap = new HashSet<>();
        for (Map.Entry<Line, Integer> lineEntry : linesMap.entrySet()) {
            for (Point2D point : points) {
                if (!lineEntry.getKey().getA().equals(point) && !lineEntry.getKey().getB().equals(point)) {
                    if (intersects(lineEntry.getKey(), point)) {
                        if (!resultMap.contains(lineEntry.getKey())) {
                            resultMap.add(lineEntry.getKey());
                        }
                    }
                }
            }
        }
        return new IFile(writeFile(output,resultMap));
    }

    private boolean intersects(Line line, Point2D point) {
        return Line2D.ptLineDist(line.getA().getX(), line.getA().getY(), line.getB().getX(), line.getB().getY(), point.getX(), point.getY()) == 0.0;
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

    public class IFile implements IFileWithLines {

        private File file;
        private Set<ILine> lines;

        public IFile(File file) {
            this.file = file;
            lines = new HashSet<>();
            if (file.length() != 0) {
                try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
                    lines = (Set<ILine>) objectInputStream.readObject();
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
        public Set<ILine> getLines() {

            return lines;
        }


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

     class Line implements ILine, Serializable {

        private final long serialVersionUID = Line.class.getName().hashCode();

        private final Point2D a;
        private final Point2D b;
        private Set<Point2D> points;

        public Line(Point2D a, Point2D b) {
            this.a = a;
            this.b = b;
            points = new HashSet<>();
            points.add(a);
            points.add(b);
        }

        public Point2D getA() {
            return a;
        }

        public Point2D getB() {
            return b;
        }

         public void serialize(OutputStream stream) throws IOException {
             ObjectOutputStream out = new ObjectOutputStream(stream);
             out.writeObject(this);
             stream.flush();
         }
         public Line deserialize(InputStream stream) throws IOException, ClassNotFoundException {
             ObjectInputStream in = new ObjectInputStream(stream);
             return (Line)in.readObject();

         }

        @Override
        public Set<Point2D> getPoints() {
            return points;
        }

        @Override
        public String toString() {
            return a.getX()+","+a.getY()+","+b.getX()+","+b.getY();
        }
    }

    public File writeFile(File file, Set<ILine> lines) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))){
            objectOutputStream.writeObject(lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}
