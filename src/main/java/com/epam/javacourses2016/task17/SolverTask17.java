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
        List<Segment> sortbyX = new LinkedList<>();

        sortbyX.addAll(segments);
        Collections.sort(sortbyX, new Comparator<Segment>() {
            @Override
            public int compare(Segment o1, Segment o2) {
                return ((int) Math.round(minabscissa(o1)) - (int) Math.round(minabscissa(o2)));
            }
        });
        Set<Point2D> result = new HashSet<>();
        while (sortbyX.size() > 1) {
            Iterator<Segment> iterator = sortbyX.iterator();
            Segment first = iterator.next();
            iterator.remove();
            Segment second;
            while (iterator.hasNext() && (maxabscissa(first) >= minabscissa(second = iterator.next()))) {
                if (!first.equals(second) && intersection(first, second)) {
                    Point2D point = intersectionPoint(first, second);
                    if (result.isEmpty() || point.getX() == result.iterator().next().getX()) {
                        result.add(point);

                    } else {

                        if (point.getX() < result.iterator().next().getX()) {
                            result.clear();
                            result.add(point);
                        }
                    }
                }
            }

        }
        return result;
    }

    private double minabscissa(Segment segment) {
        return segment.getA().getX() < segment.getB().getX() ? segment.getA().getX() : segment.getB().getX();
    }

    private double maxabscissa(Segment segment) {
        return segment.getA().getX() > segment.getB().getX() ? segment.getA().getX() : segment.getB().getX();
    }


    /**
     * @param first  первый отрезок
     * @param second второй отрезок
     * @return точку пересечения этих отрезков
     */
    private Point2D intersectionPoint(Segment first, Segment second) {

        Point2D firstVector = new Point2D(first.getB().getX() - first.getA().getX(), first.getB().getY() - first.getA().getY());
        Point2D secondVector = new Point2D(second.getB().getX() - second.getA().getX(), second.getB().getY() - second.getA().getY());
        double firstVectorMultiply = (secondVector.getY() * second.getA().getX() - secondVector.getX() * second.getA().getY()) -
                secondVector.getY() * first.getA().getX() + secondVector.getX() * first.getA().getY();
        double secondVectorMultiply = (secondVector.getY() * second.getA().getX() - secondVector.getX() * second.getA().getY()) -
                secondVector.getY() * first.getB().getX() + secondVector.getX() * first.getB().getY();

        return new Point2D(first.getA().getX() + (firstVectorMultiply / (firstVectorMultiply - secondVectorMultiply))
                * firstVector.getX(), first.getA().getY() + (firstVectorMultiply / (firstVectorMultiply - secondVectorMultiply))
                * firstVector.getY());

    }

    /**
     * Осуществляет проверку пересечения двух отрезков.
     * Необходимое и достаточное условие пересечение - если каждого из отрезков лежат в различных полуплоскостях.
     *
     * @param first  первый отрезок
     * @param second второй отрезок
     * @return true, если пересекаются, false, если не пересекаются
     */
    private boolean intersection(Segment first, Segment second) {
        Point2D firstVector = new Point2D(first.getB().getX() - first.getA().getX(), first.getB().getY() - first.getA().getY());
        Point2D secondVector = new Point2D(second.getB().getX() - second.getA().getX(), second.getB().getY() - second.getA().getY());
        double firstVectorMultiply = (secondVector.getY() * second.getA().getX() - secondVector.getX() * second.getA().getY()) -
                secondVector.getY() * first.getA().getX() + secondVector.getX() * first.getA().getY();
        double secondVectorMultiply = (secondVector.getY() * second.getA().getX() - secondVector.getX() * second.getA().getY()) -
                secondVector.getY() * first.getB().getX() + secondVector.getX() * first.getB().getY();
        double thirdVectorMultiply = (firstVector.getY() * first.getA().getX() - firstVector.getX() * first.getA().getY()) -
                firstVector.getY() * second.getA().getX() + firstVector.getX() * second.getA().getY();
        double fourthVectorMultiply = (firstVector.getY() * first.getA().getX() - firstVector.getX() * first.getA().getY()) -
                firstVector.getY() * second.getB().getX() + firstVector.getX() * second.getB().getY();

        return !(firstVectorMultiply * secondVectorMultiply >= 0 || thirdVectorMultiply * fourthVectorMultiply >= 0);

    }

}