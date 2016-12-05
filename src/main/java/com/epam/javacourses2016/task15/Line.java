package com.epam.javacourses2016.task15;

import com.epam.javacourses2016.Point2D;
import com.epam.javacourses2016.Segment;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Рамиль on 30.11.2016.
 */
public class Line extends Segment implements SolverTask15.ILine {

    private Set<Point2D> points;
    private final Double coefA;
    private final Double coefB;
    private final Double coefC;

    public Line(Point2D a, Point2D b) {
        super(a,b);
        points = new HashSet<>();
        points.add(a);
        points.add(b);
        this.coefA = a.getY() - b.getY();
        this.coefB = b.getX() - b.getX();
        this.coefC = a.getX()*b.getY() - b.getX()*a.getY();
    }

    @Override
    public Set<Point2D> getPoints() {
        return points;
    }

    public boolean containsDot(Point2D point) {
        if (coefA*point.getX() + coefB*point.getY() + coefC == 0) {
            if (!points.contains(point)) {
                points.add(point);
                return true;
            }
        }
        return false;
    }

    public Double getCoefB() {
        return coefB;
    }

    public Double getCoefA() {
        return coefA;
    }

    public Double getCoefC() {
        return coefC;
    }
}
