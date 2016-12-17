package com.epam.javacourses2016;

public class Point2D implements Comparable<Point2D> {

    private final double x;
    private final double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public int compareTo(Point2D point2D) {
        return this.getX() == point2D.getX() ?
                this.getY() > point2D.getY() ? 1 : this.getY() < point2D.getY() ? -1 : 0 :
                this.getX() > point2D.getX() ? 1 : -1;
    }
}
