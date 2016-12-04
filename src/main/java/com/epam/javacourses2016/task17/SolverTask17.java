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
        if (segments == null) {
            return null;
        }
        if (segments.size() <= 1) {
            return null;
        }

        TreeMap<Segment, Integer> segmentsMap = new TreeMap<>(new MyComparator());
        //I don't know where i need map value, so here magic number for TreeMap;
        int magicNumber = 0;

        for (Segment segment : segments) {
            segmentsMap.put(segment, magicNumber);
            magicNumber++;
        }

        Set<Point2D> resultSet = new HashSet<>();
        double minX = Double.MAX_VALUE;

        mainLoop:
        for (Segment segmentOne : segmentsMap.keySet()) {
            for (Segment segmentTwo : segmentsMap.keySet()) {
                if (segmentOne.equals(segmentTwo)) {
                    continue;
                }
                //If minX of both segments higher than minX(intersection)
                // => there won't be lower or same minX because array sorted
                // => we can stop search
                if (getMinX(segmentOne) > minX && getMinX(segmentTwo) > minX) {
                    break mainLoop;
                }

                Point2D intersectionPoint = getIntersectionPoint(segmentOne, segmentTwo);
                if (intersectionPoint != null) {
                    if (intersectionPoint.getX() > minX) {
                        break;
                    } else {
                        minX = intersectionPoint.getX();
                        resultSet.add(intersectionPoint);
                    }
                }
            }
        }
/*
        for (int i = 0; i < segments.size(); i++) {
            for (int j = i + 1; j < segments.size(); j++) {
                Segment first = segmentsMap.get(i);
                Segment second = segmentsMap.get(j);

                Point2D intersectionPoint = getIntersectionPoint(first, second);
                if (intersectionPoint != null) {
                    if (intersectionPoint.getX() < minX) {
                        resultSet.clear();
                        resultSet.add(intersectionPoint);
                        minX = intersectionPoint.getX();
                    } else if (intersectionPoint.getX() == minX) {
                        resultSet.add(intersectionPoint);
                    }
                }
            }
        }
*/
        return resultSet;
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

    class MyComparator implements Comparator<Segment> {
        @Override
        public int compare(Segment o1, Segment o2) {
            double x1 = o1.getA().getX();
            double x2 = o1.getB().getX();
            double x3 = o2.getA().getX();
            double x4 = o2.getB().getX();

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

            int compareResult = Double.compare(minX1, minX2);
            if (compareResult == 0) {
                compareResult = 1;
            }
            return compareResult;
        }
    }

    private Point2D getIntersectionPoint(Segment first, Segment second) {

        double x;
        double y;
        double x1 = first.getA().getX();
        double x2 = first.getB().getX();
        double x3 = second.getA().getX();
        double x4 = second.getB().getX();

        double y1 = first.getA().getY();
        double y2 = first.getB().getY();
        double y3 = second.getA().getY();
        double y4 = second.getB().getY();

        double k1 = (x1 - x2) / (y3 - y4);
        double k2 = (y1 - y2) / (x3 - x4);

        if (k1 == k2) {
            return null;
        }

        x = ((x1 * y2 - y1 * x2) * (x3 - x4) - (x1 - x2) * (x3 * y4 - y3 * x4)) /
                ((x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4));
        y = ((x1 * y2 - y1 * x2) * (y3 - y4) - (y1 - y2) * (x3 * y4 - y3 * x4)) /
                ((x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4));

        if (!(onLine(x1, x2, x3, x4, x) || onLine(y1, y2, y3, y4, y))) {
            return null;
        }

        return new Point2D(x, y);
    }

    private boolean onLine(double p1, double p2, double p3, double p4, double p) {
        if ((p1 <= p) && (p2 >= p) && (p3 <= p) && (p4 >= p)) {
            return true;
        }
        return false;
    }
}
