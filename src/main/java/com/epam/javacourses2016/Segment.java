package com.epam.javacourses2016;

/**
 * Created by kodoo on 13.11.16.
 */
public class Segment {

    private final Point2D a;
    private final Point2D b;

    public Segment(Point2D a, Point2D b) {
        this.a = a;
        this.b = b;
    }

    public Point2D getA() {
        return a;
    }

    public Point2D getB() {
        return b;
    }


}
