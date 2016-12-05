package com.epam.javacourses2016.task17;

import com.epam.javacourses2016.Point2D;
import com.epam.javacourses2016.Segment;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

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
        TreeSet<Segment> sortedSegments = new TreeSet<>((seg1, seg2) -> {
            double x1 = seg1.getA().getX();
            double x2 = seg1.getB().getX();
            double x3 = seg2.getA().getX();
            double x4 = seg2.getB().getX();
            double minX1;
            if (x1 < x2) {
                minX1 = x1;
            } else {
                minX1 = x2;
            }
            double minX2;
            if (x3 < x4) {
                minX2 = x3;
            } else {
                minX2 = x4;
            }
            int result = Double.compare(minX1, minX2);
            return result == 0 ? 1 : result;
        });
        segments.forEach(sortedSegments::add);

        double minX = Double.MAX_VALUE;
        Set<Point2D> result = new HashSet<>();

        for (Segment first : sortedSegments) {
            for (Segment second : sortedSegments) {
                if (getMinX(first) > minX && getMinX(second) > minX) {
                    break;
                }
                Point2D intersectionPoint = getIntersectionPoint(first, second);
                if (intersectionPoint != null) {
                    if (intersectionPoint.getX() > minX) {
                        break;
                    } else {
                        minX = intersectionPoint.getX();
                        result.add(intersectionPoint);
                    }
                }
            }
        }
        return result;
    }

    Point2D getIntersectionPoint(Segment first, Segment second) {
        double firstX1 = first.getA().getX();
        double firstX2 = first.getB().getX();
        double firstY1 = first.getA().getY();
        double firstY2 = first.getB().getY();

        double secondX1 = second.getA().getX();
        double secondX2 = second.getB().getX();
        double secondY1 = second.getA().getY();
        double secondY2 = second.getB().getY();

        double d = (firstX1 - firstX2) * (secondX1 - secondX2) - (firstY1 - firstY2) * (secondY1 - secondY2);
        double x = ((firstX1 * firstY2 - firstY1 * firstX2) * (secondX1 - secondX2)
                - (firstX1 - firstX2) * (secondX1 * secondY2 - secondY1 * secondX2)) / d;
        double y = ((firstX1 * firstY2 - firstY1 * firstX2) * (secondY1 - secondY2)
                - (firstY1 - firstY2) * (secondX1 * secondY2 - secondY1 * secondX2)) / d;

        boolean isIntersect = (((firstX1 <= x) && (firstX2 >= x) && (secondX1 <= x) && (secondX2 >= x))
                            || ((firstY1 <= y) && (firstY2 >= y) && (secondY1 <= y) && (secondY2 >= y)));
        if (isIntersect) {
            return new Point2D(x, y);
        }
        return null;

    }

    private double getMinX(Segment segment) {
        double x1 = segment.getA().getX();
        double x2 = segment.getB().getX();

        double minX;
        if (x1 < x2) {
            minX = x1;
        } else {
            minX = x2;
        }

        return minX;
    }

}
