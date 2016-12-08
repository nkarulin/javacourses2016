package com.epam.javacourses2016.task15;

import com.epam.javacourses2016.Point2D;

import java.util.HashSet;
import java.util.Set;

public class Line implements SolverTask15.ILine{
    private Point2D first;
    private Point2D second;
    private double x1 = first.getX();
    private double x2 = second.getX();
    private double y1 = first.getY();
    private double y2 = second.getY();
    private Set<Point2D> points = new HashSet<>();

    public Line(Point2D first, Point2D second) {
        this.first = first;
        this.second = second;
        points.add(first);
        points.add(second);
    }

    public boolean isMorePoints(Point2D point) {
        if ((point.getX() == x1) && (point.getY() == y1)) {
            return false;
        }
        return (point.getX() - x1) * (y2 - y1) - (point.getY() - y1) * (x2 - x1) == 0;
    }

    @Override
    public Set<Point2D> getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        return (first.equals(line.first) && second.equals(line.second))
                || (first.equals(line.second) && second.equals(line.first));
    }

    @Override
    public int hashCode() {
        int result = 1;
        int hash = first.hashCode() + second.hashCode();
        result = 31 * result + hash;
        return result;
    }
}
