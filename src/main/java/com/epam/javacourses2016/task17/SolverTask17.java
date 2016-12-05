package com.epam.javacourses2016.task17;

import com.epam.javacourses2016.Point2D;
import com.epam.javacourses2016.Segment;

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
        TreeMap<Integer, Point2D> crossedSeg = new TreeMap<>();
        Segment[] segArray = segments.toArray(new Segment[segments.size()]);
        for (int i = 0; i < segArray.length; i++) {
            for (int j = i+1; j < segArray.length; j++) {
                Point2D crossDot = crossDot(segArray[i], segArray[j]);
                if (crossDot != null) {
                    crossedSeg.put(j, crossDot);
                }
            }
        }
        Set<Point2D> minAbs = new HashSet<>();
        Point2D dotWithMinAbs = crossedSeg.firstEntry().getValue();
        for (Point2D dot : crossedSeg.values()) {
            if (dot.getX() <= dotWithMinAbs.getX()) {
                dotWithMinAbs = dot;
            }
        }
        minAbs.add(dotWithMinAbs);
        for (Point2D dot : crossedSeg.values()) {
            if (dot.getX() == dotWithMinAbs.getX()) {
                minAbs.add(dot);
            }
        }
        return minAbs;
    }
    Point2D crossDot(Segment s1, Segment s2) {
        double aS1 = s1.getA().getY() - s1.getB().getY();
        double bS1 = s1.getB().getX() - s1.getA().getX();
        double cS1 = -(s1.getA().getX()*s1.getB().getY() - s1.getB().getX()*s1.getA().getY());
        double aS2 = s2.getA().getY() - s2.getB().getY();
        double bS2 = s2.getB().getX() - s2.getA().getX();
        double cS2 = -(s2.getA().getX()*s2.getB().getY() - s2.getB().getX()*s2.getA().getY());
        double x;
        double y;
        if ((aS1*bS2)-(bS1*aS2) != 0) {
            x = ((cS1*bS2) - (bS1*cS2))/((aS1*bS2)-(bS1*aS2));
            y = ((aS1*cS2) - (cS1*aS2))/((aS1*bS2)-(bS1*aS2));
            if (!isDotBelongs(s1,s2, x, y)) {
                return null;
            }
        }
        else {
            return null;
        }
        return new Point2D(x,y);
    }

    boolean isDotBelongs(Segment s1, Segment s2, double x, double y) {
        if (((s1.getA().getX() <= x) && (s1.getB().getX() >= x) && (s2.getA().getX() <= x) && (s2.getB().getX()>=x)) ||
                ((s1.getA().getY() <= y) && (s1.getB().getY() >= y) && (s2.getA().getY() <= y) && (s2.getB().getY() >= y))) {
            return true;
        }
        return false;
    }
}