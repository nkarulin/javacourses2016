package com.epam.javacourses2016.task17;

import com.epam.javacourses2016.Point2D;
import com.epam.javacourses2016.Segment;

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
    public Set<Point2D> analyze(Set<Segment> segments) {
       if (segments.isEmpty() || segments.size() <= 1) {
            return null;
        }
        TreeMap<Segment,Double> sortedSegments = new TreeMap<>((o1, o2) -> {
            double x11 = o1.getA().getX();
            double x12 = o1.getB().getX();
            double x21 = o2.getA().getX();
            double x22 = o2.getB().getX();

            double minX1;
            if (x11 < x12) {
                minX1 = x11;
            } else {
                minX1 = x12;
            }
            double minX2;
            if (x21 < x22) {
                minX2 = x21;
            } else {
                minX2 = x22;
            }
            if (minX1 == minX2) {
                return 1;
            }
            return Double.compare(minX1, minX2);
        });

        for (Segment segment : segments) {
            sortedSegments.put(segment, getMinX(segment));
        }
        double minX = Double.MAX_VALUE;
        Set<Point2D> minAbscissPoints = new HashSet();
        A:
        for (Map.Entry<Segment,Double> firstEntry : sortedSegments.entrySet()) {
            for (Map.Entry<Segment,Double> secondEntry : sortedSegments.entrySet()) {
                if (!firstEntry.equals(secondEntry)) {
                    if (firstEntry.getValue() > minX && secondEntry.getValue() > minX) {
                        break A;
                    }
                    Point2D point = findInterstionPoint(firstEntry.getKey(), secondEntry.getKey());
                    if (point != null) {
                        if (point.getX() < minX) {
                            minX = point.getX();
                            minAbscissPoints.clear();
                            minAbscissPoints.add(point);
                        } else if (point.getX() == minX) {
                            minAbscissPoints.add(point);
                        }
                    }
                }
            }
        }
        return minAbscissPoints;
    }

    private double getMinX(Segment segment) {
        double x1 = segment.getA().getX();
        double x2 = segment.getB().getX();
        double minX1;
        if (x1 < x2) {
            minX1 = x1;
        } else {
            minX1 = x2;
        }
        return minX1;
    }

    public Point2D findInterstionPoint(Segment firstSegment, Segment secondSegment) {

        double x11 = firstSegment.getA().getX();
        double x12 = firstSegment.getB().getX();
        double y11 = firstSegment.getA().getY();
        double y12 = firstSegment.getB().getY();

        double x21 = secondSegment.getA().getX();
        double x22 = secondSegment.getB().getX();
        double y21 = secondSegment.getA().getY();
        double y22 = secondSegment.getB().getY();

        double d = (x11 - x12) * (x21 - x22) - (y11 - y12) * (y21 - y22);
        double x = ((x11 * y12 - y11 * x12) * (x21 - x22) - (x11 - x12) * (x21 * y22 - y21 * x22)) / d;
        double y = ((x11 * y12 - y11 * x12) * (y21 - y22) - (y11 - y12) * (x21 * y22 - y21 * x22)) / d;

        boolean isIntersect = (((x11 <= x) && (x12 >= x) && (x21 <= x) && (x22 >= x)) || ((y11 <= y) && (y12 >= y) && (y21 <= y) && (y22 >= y)));

        Point2D point = null;
        if (isIntersect) {
            point = new Point2D(x, y);
        }
        return point;
    }

}
