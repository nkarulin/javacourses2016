package com.epam.javacourses2016;


public class Point2D{

    private double x;
    private double y;

    public Point2D() {

    }

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public boolean compareWithRadius(Point2D center, int radius) {
        double temp_R = Math.sqrt( Math.pow(x-center.getY(),2) + Math.pow(y-center.getY(),2));
        return temp_R <= radius;
    }

    public double getDistanceTo(Point2D center) {
        return Math.sqrt( Math.pow(x-center.getY(),2) + Math.pow(y-center.getY(),2));
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

}
