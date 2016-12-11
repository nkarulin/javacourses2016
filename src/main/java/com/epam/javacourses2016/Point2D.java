package com.epam.javacourses2016;

public class Point2D implements Comparable<Point2D>{

    private final double x;
    private final double y;
    private double radius;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Point2D(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public boolean compareWithRadius(Point2D center, int radius) {
        double temp_R = Math.sqrt( Math.pow(x-center.getY(),2) + Math.pow(y-center.getY(),2));
        return temp_R <= radius;
    }

    public double getDistanceTo(Point2D center) {
        radius = Math.sqrt( Math.pow(x-center.getY(),2) + Math.pow(y-center.getY(),2));
        return radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point2D)) return false;

        Point2D point2D = (Point2D) o;

        if (Double.compare(point2D.getX(), getX()) != 0) return false;
        return Double.compare(point2D.getY(), getY()) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getX());
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getY());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
    @Override
    public String toString() {
        return   x +
                " " + y +
                " ";
    }

    @Override
    public int compareTo(Point2D o) {
        if(radius < o.radius)
            return -1;
        if(radius > o.radius)
            return 1;
        else {
            if (x < o.getX())
                return -1;
            if (x > o.getX())
                return 1;
            if (y < o.getY())
                return -1;
            if (y > o.getY())
                return 1;
            return 0;
        }
    }
}
