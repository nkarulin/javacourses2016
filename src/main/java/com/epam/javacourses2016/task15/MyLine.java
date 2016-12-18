package com.epam.javacourses2016.task15;

import com.epam.javacourses2016.Point2D;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.awt.geom.Line2D;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by n on 15.12.2016.
 */
public class MyLine implements SolverTask15.ILine {
    Point2D first;
    Point2D second;
    Set<Point2D> points;

    public MyLine(Point2D first, Point2D second) {
        this.first = first;
        this.second = second;
        points = new HashSet<>();
        points.add(first);
        points.add(second);
    }
    public MyLine(){
        points = new HashSet<>();
    }

    @Override
    public Set<Point2D> getPoints() {
        return null;
    }
    public boolean intersect(Point2D point) {
        return new Line2D.Double(first.getX(), first.getY(), second.getX(), second.getY()).ptLineDist(point.getX(), point.getY()) <= 0.01;
    }

    public Point2D getFirst() {
        return first;
    }

    public void setFirst(Point2D first) {
        this.first = first;
    }

    public Point2D getSecond() {
        return second;
    }

    public void setSecond(Point2D second) {
        this.second = second;
    }

    public boolean equals(MyLine line) {
        return (line.getFirst() == first && line.getSecond() == second);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyLine)) return false;

        MyLine myLine = (MyLine) o;

        return getPoints() != null ? getPoints().equals(myLine.getPoints()) : myLine.getPoints() == null;

    }

    @Override
    public int hashCode() {
        return getPoints() != null ? getPoints().hashCode() : 0;
    }
}
