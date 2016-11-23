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

    private Set<Point2D> intersections(Segment area) {
        return null;
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

        return null;
    }
}
