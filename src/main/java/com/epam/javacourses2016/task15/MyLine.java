package com.epam.javacourses2016.task15;

import com.epam.javacourses2016.Point2D;

import java.awt.geom.Line2D;
import java.util.HashSet;
import java.util.Set;

public class MyLine implements SolverTask15.ILine {
    private Point2D a;
    private Point2D b;
    private Set <Point2D> points;

    public MyLine(Point2D a, Point2D b){
        this.a = a;
        this.b = b;
        points = new HashSet<>();
        points.add(a);
        points.add(b);
    }

    @Override
    public Set<Point2D> getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object obj) {
        MyLine line = (MyLine) obj;
        return (line.getA() == a && line.getB() == b);
    }

    public boolean passesThrough(Point2D point){
        return  Line2D.ptLineDist(a.getX(), a.getY(), b.getX(), b.getY(), point.getX(), point.getY()) == 0.0;
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

    public void setPoints(Set<Point2D> points) {
        this.points = points;
    }
}
