package com.epam.javacourses2016.task16;

import com.epam.javacourses2016.Point2D;

public class Cell {
    private Point2D centerOfCell;
    private final double CELL_SIZE = 1;
    private double distanceToCenter;

    public Cell(Point2D centerOfCell, Point2D centerOfCircle) {
        this.centerOfCell = centerOfCell;
        distanceToCenter = getDistanceToPoint(centerOfCircle.getX(), centerOfCircle.getY());
    }

    public Double getDistanceToCenter() {
        return distanceToCenter;
    }

    public Point2D getCenterOfCell() {
        return centerOfCell;
    }

    private Double getDistanceToPoint(Double x, Double y) {
        return Math.sqrt(Math.pow(x - centerOfCell.getX(), 2) + Math.pow(y - centerOfCell.getY(), 2));
    }

    public boolean isInsideCircle(Point2D center, int radius) {
        boolean isTopRight =  Math.sqrt(Math.pow((centerOfCell.getX() + CELL_SIZE / 2) - center.getX(), 2)
                + Math.pow((centerOfCell.getY() + CELL_SIZE / 2) - center.getY(), 2)) < Math.pow(radius, 2);
        boolean isTopLeft =  Math.sqrt(Math.pow((centerOfCell.getX() - CELL_SIZE / 2) - center.getX(), 2)
                + Math.pow((centerOfCell.getY() + CELL_SIZE / 2) - center.getY(), 2)) < Math.pow(radius, 2);
        boolean isBotRight =  Math.sqrt(Math.pow((centerOfCell.getX() + CELL_SIZE / 2) - center.getX(), 2)
                + Math.pow((centerOfCell.getY() - CELL_SIZE / 2) - center.getY(), 2)) < Math.pow(radius, 2);
        boolean isBotLeft =  Math.sqrt(Math.pow((centerOfCell.getX() - CELL_SIZE / 2) - center.getX(), 2)
                + Math.pow((centerOfCell.getY() - CELL_SIZE / 2) - center.getY(), 2)) < Math.pow(radius, 2);
        return isTopRight && isTopLeft && isBotRight && isBotLeft;
    }
}
