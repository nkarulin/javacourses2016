package com.epam.javacourses2016.task17;

import com.epam.javacourses2016.Point2D;
import com.epam.javacourses2016.Segment;

import java.util.HashSet;
import java.util.Map;
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
        if (segments.isEmpty() || segments.size() <= 1) {
            return null;
        }
        TreeMap<Segment, Double> sortedSegments = new TreeMap<>((o1, o2) -> {
            int res = Double.compare(Math.min(o1.getA().getX(), o1.getB().getX()), Math.min(o2.getA().getX(), o2.getB().getX()));
            if (res == 0) return 1;
            else return res;
        });

        for (Segment segment : segments) {
            sortedSegments.put(segment, Math.min(segment.getA().getX(), segment.getB().getX()));
        }
        double minX = Double.MAX_VALUE;
        Set<Point2D> minAbscissPoints = new HashSet();
        mainLoop:
        for (Map.Entry<Segment, Double> firstEntry : sortedSegments.entrySet()) {
            for (Map.Entry<Segment, Double> secondEntry : sortedSegments.entrySet()) {
                if (!firstEntry.equals(secondEntry)) {
                    if (firstEntry.getValue() > minX && secondEntry.getValue() > minX) {
                        break mainLoop;
                    }
                    Point2D point = getInterstionPoint(firstEntry.getKey(), secondEntry.getKey());
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

    public Point2D getInterstionPoint(Segment firstSegment, Segment secondSegment) {

        double x1 = firstSegment.getA().getX();
        double y1 = firstSegment.getA().getY();
        double x2 = firstSegment.getB().getX();
        double y2 = firstSegment.getB().getY();

        double x3 = secondSegment.getA().getX();
        double y3 = secondSegment.getA().getY();
        double x4 = secondSegment.getB().getX();
        double y4 = secondSegment.getB().getY();

        double k1 = (y1 - y2) / (x1 - x2);
        double b1 = y1 - k1 * x1;

        double k2 = (y3 - y4) / (x3 - x4);
        double b2 = y3 - k2 * x3;

        double x = (b2 - b1)/(k1 - k2);
        double y = k1 * x + b1;

        boolean isFine = (((x1 <= x) && (x2 >= x) && (x3 <= x) && (x4 >= x)) || ((y1 <= y) && (y2 >= y) && (y3 <= y) && (y4 >= y)));

        if (isFine) return new Point2D(x,y);
        else return null;
    }
}
