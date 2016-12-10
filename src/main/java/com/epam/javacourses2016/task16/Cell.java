package com.epam.javacourses2016.task16;

import com.epam.javacourses2016.Point2D;

/**
 * Created by Vasya on 27.11.2016.
 */
public class Cell {
    private final double size;
    private final Point2D center;

    public Cell(Point2D center, double size) {
        this.size = size;
        this.center = center;
    }

    public Point2D getCenter() {
        return center;
    }

    public Point2D getLowerLeftCorner() {
        return new Point2D(this.center.getX() - size / 2, this.center.getY() - size / 2);
    }

    public Point2D getLowerRightCorner() {
        return new Point2D(this.center.getX() + size / 2, this.center.getY() - size / 2);
    }

    public Point2D getUpperLeftCorner() {
        return new Point2D(this.center.getX() + size / 2, this.center.getY() + size / 2);
    }

    public Point2D getUpperRightCorner() {
        return new Point2D(this.center.getX() + size / 2, this.center.getY() + size / 2);
    }
}