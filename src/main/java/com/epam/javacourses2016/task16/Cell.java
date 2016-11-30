package com.epam.javacourses2016.task16;

import com.epam.javacourses2016.Point2D;

/**
 * Created by Рамиль on 30.11.2016.
 */
public class Cell {

    private final Point2D CENTER;
    private final Point2D TOP_LEFT_CORNER;
    private final Point2D BOT_LEFT_CORNER;
    private final Point2D TOP_RIGHT_CORNER;
    private final Point2D BOT_RIGHT_CORNER;
    private final double CELL_SIZE = 1.0;

    public Point2D getCenter() {
        return CENTER;
    }

    public Cell(Point2D center) {
        CENTER = center;
        TOP_LEFT_CORNER = new Point2D(CENTER.getX() - (CELL_SIZE / 2), CENTER.getY() + (CELL_SIZE / 2));
        BOT_LEFT_CORNER = new Point2D(CENTER.getX() - (CELL_SIZE / 2), CENTER.getY() - (CELL_SIZE / 2));
        TOP_RIGHT_CORNER = new Point2D(CENTER.getX() + (CELL_SIZE / 2), CENTER.getY() + (CELL_SIZE / 2));
        BOT_RIGHT_CORNER = new Point2D(CENTER.getX() + (CELL_SIZE / 2), CENTER.getY() - (CELL_SIZE / 2));
    }

    public Double getDistanceToCenter(Point2D center) {
        return Math.sqrt(Math.pow(center.getX() - CENTER.getX(), 2) + Math.pow(center.getY() - CENTER.getY(), 2));
    }

    public boolean isInCircle(Point2D circleCenter, int radius) {

        boolean isTopLeftInCircle = Math.pow(TOP_LEFT_CORNER.getX() - circleCenter.getX(), 2) +
                Math.pow(TOP_LEFT_CORNER.getY() - circleCenter.getY(), 2) < Math.pow(radius, 2);
        boolean isBotLeftInCircle = Math.pow(BOT_LEFT_CORNER.getX() - circleCenter.getX(), 2) +
                Math.pow(BOT_LEFT_CORNER.getY() - circleCenter.getY(), 2) < Math.pow(radius, 2);
        boolean isTopRightInCircle = Math.pow(TOP_RIGHT_CORNER.getX() - circleCenter.getX(), 2) +
                Math.pow(TOP_RIGHT_CORNER.getY() - circleCenter.getY(), 2) < Math.pow(radius, 2);
        boolean isBotRightInCircle = Math.pow(BOT_RIGHT_CORNER.getX() - circleCenter.getX(), 2) +
                Math.pow(BOT_RIGHT_CORNER.getY() - circleCenter.getY(), 2) < Math.pow(radius, 2);
        return isTopLeftInCircle && isBotLeftInCircle && isTopRightInCircle && isBotRightInCircle;
    }
}
