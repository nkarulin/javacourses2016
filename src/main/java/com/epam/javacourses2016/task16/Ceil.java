package com.epam.javacourses2016.task16;

import com.epam.javacourses2016.Point2D;

/**
 * Created by Ivan on 24/11/2016.
 */
public class Ceil {
    private final Point2D CENTER;
    private final double HEIGHT = 1;
    private final double WIDTH = 1;

    public Ceil(Point2D center) {
        this.CENTER = center;
    }

    public Point2D getCenter() {
        return CENTER;
    }

    public Double getDistanceTo(Double x, Double y) {
        return Math.pow(x - CENTER.getX(), 2) + Math.pow(y - CENTER.getY(), 2);
    }

    public boolean isInsideCircle(Point2D center, int radius) {
        boolean isUpRigthCorner = Math.pow((CENTER.getX() + WIDTH / 2) - center.getX(), 2) + Math.pow((CENTER.getY() + HEIGHT / 2) - center.getY(), 2) < Math.pow(radius, 2);
        boolean isUpLeftCorner = Math.pow((CENTER.getX() - WIDTH / 2) - center.getX(), 2) + Math.pow((CENTER.getY() + HEIGHT / 2) - center.getY(), 2) < Math.pow(radius, 2);
        boolean isDownRightCorner = Math.pow((CENTER.getX() + WIDTH / 2) - center.getX(), 2) + Math.pow((CENTER.getY() - HEIGHT / 2) - center.getY(), 2) < Math.pow(radius, 2);
        boolean isDownLeftCorner = Math.pow((CENTER.getX() - WIDTH / 2) - center.getX(), 2) + Math.pow((CENTER.getY() - HEIGHT / 2) - center.getY(), 2) < Math.pow(radius, 2);
        boolean isInside = isUpRigthCorner && isUpLeftCorner && isDownRightCorner && isDownLeftCorner;
        return isInside;
    }
}
