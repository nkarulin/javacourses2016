package com.epam.javacourses2016.task17;

import com.epam.javacourses2016.Point2D;
import com.epam.javacourses2016.Segment;

import java.awt.geom.Line2D;
import java.util.*;

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
    Set<Point2D> analyze(Set<Segment> segments) {
        if (segments.isEmpty() || segments.size() <= 1) {
            return null;
        }

        TreeMap<Point2D, Double> intersectionPoints = new TreeMap<>(new Comparator<Point2D>() {
            @Override
            public int compare(Point2D o1, Point2D o2) {
                return Double.compare(o1.getX(), o2.getX());
            }
        });

        for (Segment firstSegment : segments) {
            for (Segment secondSegment : segments) {
                if (!isIntersect(firstSegment, secondSegment)) {
                    continue;
                }
                Point2D point = findInterstionPoint(firstSegment, secondSegment);
                intersectionPoints.put(point, point.getX());
            }

        }

        Set<Point2D> minAbscissPoints = new HashSet<>();
        Double minX = intersectionPoints.get(intersectionPoints.firstKey());
        for (Map.Entry<Point2D, Double> e : intersectionPoints.entrySet()) {
            if (e.getValue() == minX) {
                minAbscissPoints.add(e.getKey());
            } else {
                break;
            }
        }
        return minAbscissPoints;

    }

    public boolean isIntersect(Segment firstSegment, Segment secondSegment) {
        boolean isIntersect = Line2D.linesIntersect(firstSegment.getA().getX(), firstSegment.getA().getY(),
                firstSegment.getB().getX(), firstSegment.getB().getY(),
                secondSegment.getA().getX(), secondSegment.getA().getY(),
                secondSegment.getB().getX(), secondSegment.getB().getY());
        return isIntersect;

    }

    public Point2D findInterstionPoint(Segment firstSegment, Segment secondSegment) {

        double a1 = firstSegment.getA().getY() - firstSegment.getB().getY();
        double a2 = secondSegment.getA().getY() - secondSegment.getB().getY();
        double b1 = firstSegment.getA().getX() - firstSegment.getB().getX();
        double b2 = secondSegment.getA().getX() - secondSegment.getB().getX();

        double d = a1 * b2 - a2 * b1;

        double c1 = firstSegment.getB().getY() * firstSegment.getA().getY() - firstSegment.getB().getX() * firstSegment.getA().getY();
        double c2 = secondSegment.getB().getY() * secondSegment.getA().getY() - secondSegment.getB().getX() * secondSegment.getA().getY();

        double xi = (b1 * c2 - b2 * c1) / d;
        double yi = (a2 * c1 - a1 * c2) / d;

        return new Point2D(xi, yi);
    }

}
