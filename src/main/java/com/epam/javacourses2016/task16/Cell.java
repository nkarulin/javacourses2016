package com.epam.javacourses2016.task16;

import com.epam.javacourses2016.Point2D;

public class Cell {
    private Point2D center;
    private final double CELL_SIZE = 1;

    public Cell(Point2D center) {
        this.center = center;
    }

    public Point2D getCenter() {
        return center;
    }

    public Double getDistanceToPoint(Double x, Double y) {
        return Math.sqrt(Math.pow(x - center.getX(), 2) + Math.pow(y - center.getY(), 2));
    }

    public boolean isInsideCircle(Point2D center, int radius) {
        boolean isUpRigthCorner =  Math.sqrt(Math.pow((center.getX() + CELL_SIZE / 2) - center.getX(), 2)
                + Math.pow((center.getY() + CELL_SIZE / 2) - center.getY(), 2)) < Math.pow(radius, 2);
        boolean isUpLeftCorner =  Math.sqrt(Math.pow((center.getX() - CELL_SIZE / 2) - center.getX(), 2)
                + Math.pow((center.getY() + CELL_SIZE / 2) - center.getY(), 2)) < Math.pow(radius, 2);
        boolean isDownRightCorner =  Math.sqrt(Math.pow((center.getX() + CELL_SIZE / 2) - center.getX(), 2)
                + Math.pow((center.getY() - CELL_SIZE / 2) - center.getY(), 2)) < Math.pow(radius, 2);
        boolean isDownLeftCorner =  Math.sqrt(Math.pow((center.getX() - CELL_SIZE / 2) - center.getX(), 2)
                + Math.pow((center.getY() - CELL_SIZE / 2) - center.getY(), 2)) < Math.pow(radius, 2);
        return isUpRigthCorner && isUpLeftCorner && isDownRightCorner && isDownLeftCorner;
    }
}
