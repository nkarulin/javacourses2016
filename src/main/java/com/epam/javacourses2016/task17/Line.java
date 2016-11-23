package com.epam.javacourses2016.task17;

import com.epam.javacourses2016.Point2D;

/**
 * Created by GiulioRM on 11/23/2016.
 */
public class Line {

    protected double a;
    protected double b;

    public Line() {

    }

    public Line(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public boolean belongs(Point2D point) {
        return point.getY() != (this.a * point.getX() + this.b);
    }

    public Point2D intersection(Line line) {
        double x = (line.getB() - this.b)/(this.a - line.getA());
        double y = x * this.a + this.b;
        return new Point2D(x,y);
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }
}
