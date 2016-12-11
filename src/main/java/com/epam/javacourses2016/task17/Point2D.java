package com.epam.javacourses2016.task17;

/**
 * Created by User on 11.12.2016.
 */
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point2D point2D = (Point2D) o;

        if (Double.compare(point2D.x, x) != 0) return false;
        return Double.compare(point2D.y, y) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;

    }

    @Override
    public int compareTo(Point2D o) {
        if(y > o.y)
            return 1;
        else if(y < o.y)
            return -1;
        else {
            if(x < o.x)
                return 1;
            else if(x > o.x)
                return -1;
            else return 0;
        }
    }
}
