package com.epam.javacourses2016.Task17;

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

    /**
     * Осуществляет анализ переданных отрезков.
     *
     * @param segments Множество отрезков.
     * @return Множество точек пересечения, имеющих минимальную абсциссу.
     */
   public Set<Point2D> analyze(Set<Segment> segments) {
        List<RangedLine> lines = new ArrayList<>();
        Map<RangedLine, Set<Point2D>> intersections = new TreeMap<RangedLine, Set<Point2D>>();
        segments.forEach(seg -> {
            RangedLine line = new RangedLine(seg);
            lines.add(line);
        });
     /*           .sorted((line1, line2) -> {
                    double x1 = line1.getRange().getA().getX();
                    double x2 = line2.getRange().getA().getX();
                    return x1 > x2 ? 1 : x1 < x2 ? -1 : 0;
                })*///.collect(Collectors.toList());


        double minX = Double.MAX_VALUE;
        while(lines.size() > 0) {
            RangedLine first = lines.get(0);

           /* double xRange = first.getRange().getB().getX() - first.getRange().getB().getX();
            double y1 = first.getRange().getA().getY();
            double y2 = first.getRange().getB().getY();
            double beginY = y1 >= y2 ? y2 : y1; */

            int i = 1;
            while(i < lines.size()) {
                RangedLine line = lines.get(i);
                Point2D intersection = first.intersection(line);

                if (intersection != null ) {
                    if(intersection.getX() < minX)
                        minX = intersection.getX();
                    Set<Point2D> setToAdd = null;
                    if(!intersections.containsKey(first)) {
                        setToAdd = new HashSet<>();
                        // newSet.add(intersection);
                        intersections.put(first, setToAdd);
                    } else  setToAdd = intersections.get(first);

                    setToAdd.add(intersection);
                }
                i++;
            }
            lines.remove(first);
        }
        Set<Point2D> result = new HashSet<>();
        final double min = minX;
        for(RangedLine line : intersections.keySet()) {
            Set<Point2D> set = intersections.get(line);
            if (set != null)
                result.addAll(set.stream().filter(item -> item != null && item.getX() <= min).collect(Collectors.toList()));
        }
        return result;
    }
}
