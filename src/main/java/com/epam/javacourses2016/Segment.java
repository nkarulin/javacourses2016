package com.epam.javacourses2016;

import java.util.Comparator;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Segment)) return false;

        Segment segment = (Segment) o;

        if (getA() != null ? !getA().equals(segment.getA()) : segment.getA() != null) return false;
        return getB() != null ? getB().equals(segment.getB()) : segment.getB() == null;

    }

    @Override
    public int hashCode() {
        int result = getA() != null ? getA().hashCode() : 0;
        result = 31 * result + (getB() != null ? getB().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Segment{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

}
