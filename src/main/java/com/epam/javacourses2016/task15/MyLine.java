package com.epam.javacourses2016.task15;

import com.epam.javacourses2016.Point2D;

import java.awt.geom.Line2D;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MyLine implements SolverTask15.ILine {

    Point2D a;
    Point2D b;
    Set<Point2D> points = new HashSet<>();

    public MyLine() {

    }

    public MyLine(Point2D a, Point2D b) {
        this.a = a;
        this.b = b;
        points.add(a);
        points.add(b);
    }

    public boolean intersect(Point2D point) {
        return new Line2D.Double(a.getX(), a.getY(), b.getX(), b.getY()).ptLineDist(point.getX(), point.getY()) <= 0.01;
    }

    public Point2D getA() {
        return a;
    }

    public void setA(Point2D a) {
        this.a = a;
    }

    public Point2D getB() {
        return b;
    }

    public void setB(Point2D b) {
        this.b = b;
    }

    public boolean equals(MyLine line) {
        return (line.getA() == a && line.getB() == b);
    }

    @Override
    public Set<Point2D> getPoints() {
        return points;
    }
}