package com.epam.javacourses2016.task17;

import com.epam.javacourses2016.Point2D;
import com.epam.javacourses2016.Segment;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

/**
 * На плоскости задано N отрезков.
 * Найти точку (возможно несколько) пересечения двух отрезков, имеющую минимальную абсциссу.
 * Использовать класс TreeMap.
 */
public class SolverTask17 {

    /**
     * Осуществляет анализ переданных отрезков.
     *
     * @param segments Множество отрезков.
     * @return Множество точек пересечения, имеющих минимальную абсциссу.
     */
    public Set<Point2D> analyze(Set<Segment> segments) {
        TreeMap <Point2D, Double> points = new TreeMap<>(new MyComparator());
        Set <Point2D> output = new HashSet<>();
        segments.stream().forEach((s1) -> {
            Line line1 = new Line(s1.getA(), s1.getB());
            segments.stream().forEach((s2) -> {
                Line line2 = new Line(s2.getA(), s2.getB());
                if (line1.getA() != line2.getA()) {
                    Point2D point = new Point2D((line2.getB() - line1.getB())/(line1.getA() - line2.getA()), (line2.getB() * line1.getA() - line2.getA() * line1.getB())/(line1.getA() - line2.getA()));
                    double maxX = Math.max(s1.getA().getX(), Math.max(s1.getB().getX(), Math.max(s2.getA().getX(), s2.getB().getX())));
                    double minX = Math.min(s1.getA().getX(), Math.min(s1.getB().getX(), Math.min(s2.getA().getX(), s2.getB().getX())));
                    double maxY = Math.max(s1.getA().getY(), Math.max(s1.getB().getY(), Math.max(s2.getA().getY(), s2.getB().getY())));
                    double minY = Math.min(s1.getA().getY(), Math.min(s1.getB().getY(), Math.min(s2.getA().getY(), s2.getB().getY())));
                    if (point.getX() >= minX && point.getX() <= maxX && point.getY() >= minY && point.getY() <= maxY) {
                        points.put(point, point.getX());
                    }
                }
            });
        });
        output.add(points.firstKey());
        points.keySet().stream().forEach((k) -> {
            if (k.getX() == points.firstKey().getX()) output.add(k);
        });
        return output;
    }

    private class MyComparator implements Comparator<Point2D> {

        @Override
        public int compare(Point2D p1, Point2D p2) {
            return (int) (p1.getX() - p2.getX());
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }


    }

    private class Line {
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

        public Double getA() {
            return a;
        }

        public Double getB() {
            return b;
        }
    }
}
