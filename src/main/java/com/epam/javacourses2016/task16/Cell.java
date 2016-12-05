package com.epam.javacourses2016.task16;

import com.epam.javacourses2016.Point2D;

/**
 * Created by Рамиль on 30.11.2016.
 */
public class Cell {

    private final Point2D center;
    private final Point2D topLeftCorn;
    private final Point2D botLeftCorn;
    private final Point2D topRightCorn;
    private final Point2D botRightCorn;
    private static final double CELL_SIZE = 1.0;

    public Point2D getCenter() {
        return center;
    }

    public Cell(Point2D center) {
        this.center = center;
        topLeftCorn = new Point2D(center.getX() - (CELL_SIZE / 2), center.getY() + (CELL_SIZE / 2));
        botLeftCorn = new Point2D(center.getX() - (CELL_SIZE / 2), center.getY() - (CELL_SIZE / 2));
        topRightCorn = new Point2D(center.getX() + (CELL_SIZE / 2), center.getY() + (CELL_SIZE / 2));
        botRightCorn = new Point2D(center.getX() + (CELL_SIZE / 2), center.getY() - (CELL_SIZE / 2));
    }

    public Double getDistanceToCenter(Point2D center) {
        return Math.sqrt(Math.pow(center.getX() - center.getX(), 2) + Math.pow(center.getY() - center.getY(), 2));
    }

    public boolean isInCircle(Point2D circleCenter, int radius) {

        boolean isTopLeftInCircle = Math.pow(topLeftCorn.getX() - circleCenter.getX(), 2) +
                Math.pow(topLeftCorn.getY() - circleCenter.getY(), 2) < Math.pow(radius, 2);
        boolean isBotLeftInCircle = Math.pow(botLeftCorn.getX() - circleCenter.getX(), 2) +
                Math.pow(botLeftCorn.getY() - circleCenter.getY(), 2) < Math.pow(radius, 2);
        boolean isTopRightInCircle = Math.pow(topRightCorn.getX() - circleCenter.getX(), 2) +
                Math.pow(topRightCorn.getY() - circleCenter.getY(), 2) < Math.pow(radius, 2);
        boolean isBotRightInCircle = Math.pow(botRightCorn.getX() - circleCenter.getX(), 2) +
                Math.pow(botRightCorn.getY() - circleCenter.getY(), 2) < Math.pow(radius, 2);
        return isTopLeftInCircle && isBotLeftInCircle && isTopRightInCircle && isBotRightInCircle;
    }
}
