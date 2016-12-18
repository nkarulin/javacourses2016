package com.epam.javacourses2016.task16;

import com.epam.javacourses2016.Point2D;
/**
 * Created by n on 17.12.2016.
 */
public class Cell {
    private final Point2D CENTER;
    private final double HEIGHT = 1;
    private final double WIDTH = 1;

    public Cell(Point2D center) {
        this.CENTER = center;
    }

    public Point2D getCenter() {
        return CENTER;
    }

    public Double distanceToPoint(Double x, Double y) {
        return Math.sqrt(Math.pow(x - CENTER.getX(), 2) + Math.pow(y - CENTER.getY(), 2));
    }

    public boolean isInCircle(Point2D center, int radius) {
        boolean topRight =  Math.sqrt(Math.pow((CENTER.getX() + WIDTH / 2) - center.getX(), 2) + Math.pow((CENTER.getY() + HEIGHT / 2) - center.getY(), 2)) < Math.pow(radius, 2);
        boolean topLeft =  Math.sqrt(Math.pow((CENTER.getX() - WIDTH / 2) - center.getX(), 2) + Math.pow((CENTER.getY() + HEIGHT / 2) - center.getY(), 2)) < Math.pow(radius, 2);
        boolean botRight =  Math.sqrt(Math.pow((CENTER.getX() + WIDTH / 2) - center.getX(), 2) + Math.pow((CENTER.getY() - HEIGHT / 2) - center.getY(), 2)) < Math.pow(radius, 2);
        boolean botLeft =  Math.sqrt(Math.pow((CENTER.getX() - WIDTH / 2) - center.getX(), 2) + Math.pow((CENTER.getY() - HEIGHT / 2) - center.getY(), 2)) < Math.pow(radius, 2);
        return topRight && topLeft && botRight && botLeft;

    }
}