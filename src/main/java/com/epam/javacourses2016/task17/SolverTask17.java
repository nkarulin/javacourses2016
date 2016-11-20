package com.epam.javacourses2016.task17;

import com.epam.javacourses2016.Point2D;
import com.epam.javacourses2016.Segment;
import sun.reflect.generics.tree.Tree;

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
    Set<Point2D> analyze(Set<Segment> segments) {
        for (int i = 0; i < segments.size(); i++) {
            for (int j = 0; j < segments.size(); j++) {

            }
        }

        return null;
    }

    private Point2D getIntersectionPoint(Point2D a, Point2D b, Point2D c, Point2D d) {
        double x;
        double y;
        double x1 = a.getX();
        double x2 = b.getX();
        double x3 = c.getX();
        double x4 = d.getX();

        double y1 = a.getY();
        double y2 = b.getY();
        double y3 = c.getY();
        double y4 = d.getY();
        double k1 = (x2 - x1) / (y2 - y1);
        double k2 = (x4 - x3) / (y4 - y3);

        if (k1 == k2) {
            return null;
        }

        x = ((x1 * y2 - x2 * y1) * (x4 - x3) - (x3 * y4 - x4 * y3) * (x2 - x1)) /
                ((y1 - y2) * (x4 - x3) - (y3 - y4) * (x2 - x1));
        y = ((y3 - y4) * x - (x3 * y4 - x4 * y3)) / (x4 - x3);

        if (onLine(x1, x2, x3, x4, x) || onLine(y1, y2, y3, y4, y)) {
            return null;
        }
        return new Point2D(x, y);
    }

    private boolean onLine(double x1, double x2, double x3, double x4, double x) {
        if ((x1 <= x) && (x2 >= x) && (x3 <= x) && (x4 >= x)) {
            return true;
        }
        return false;
    }
}
