package com.epam.javacourses2016.task17;

import com.epam.javacourses2016.Point2D;
import com.epam.javacourses2016.Segment;

import java.util.*;
import java.util.stream.Collectors;

/**
 * На плоскости задано N отрезков.
 * Найти точку (возможно несколько) пересечения двух отрезков, имеющую минимальную абсциссу.
 * Использовать класс TreeMap.
 */
public class SolverTask17 {

    private boolean pointBelongsToArea(Point2D point, Segment range) {
        return point.getX() >= range.getA().getX() &&
                point.getX() <= range.getB().getX() &&
                point.getY() >= range.getA().getX() &&
                point.getY() <= range.getB().getX();
    }

    public Point2D intersectionLine(double a1, double b1, double a2, double b2) {
        double x = (b2 - b1)/(a1 - a2);
        double y = x * a1 + b1;
        return new Point2D(x,y);
    }

    public Point2D intersectionSegment(double a1, double b1, double a2, double b2, Segment range) {
        Point2D intersection = intersectionLine(a1, b1, a2, b2);
        return pointBelongsToArea(intersection, range) ? intersection : null;
    }


    /**
     * Осуществляет анализ переданных отрезков.
     *
     * @param segments Множество отрезков.
     * @return Множество точек пересечения, имеющих минимальную абсциссу.
     */
      Set<Point2D> analyze(Set<Segment> segments) {
        Set<Point2D> intersects = new HashSet<>();
        List<RangedLine> lines = segments.stream().map(seg -> new RangedLine(seg))
     /*           .sorted((line1, line2) -> {
                    double x1 = line1.getRange().getA().getX();
                    double x2 = line2.getRange().getA().getX();
                    return x1 > x2 ? 1 : x1 < x2 ? -1 : 0;
                })*/.collect(Collectors.toList());

        Map<RangedLine, RangedLine> intersections = new TreeMap();

        while(lines.size() > 0) {
            RangedLine first = lines.get(0);

           /* double xRange = first.getRange().getB().getX() - first.getRange().getB().getX();
            double y1 = first.getRange().getA().getY();
            double y2 = first.getRange().getB().getY();
            double beginY = y1 >= y2 ? y2 : y1; */

            int i = 0;
            while(i < lines.size()) {
                RangedLine line = lines.get(i);
                 if (first.intersection(line) != null) {
                     if (!intersections.containsKey(first))
                         intersections.put(first, line);
                     else  {
                         RangedLine get = intersections.get(first);
                         if (line.getRange().getA().getX() < get.getRange().getA().getX()) {
                             intersections.remove(first);
                             intersections.put(first, line);
                         }
                         lines.remove(i);
                     }
                  }else i++;
            }
        }

        return null;
    }
}
