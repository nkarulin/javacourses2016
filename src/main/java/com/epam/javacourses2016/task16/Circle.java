package com.epam.javacourses2016.task16;

import com.epam.javacourses2016.Point2D;

import java.awt.*;

/**
 * Created by GiulioRM on 12/13/2016.
 */
public class Circle {
    private int radius;
    private Point2D center;

    public Circle(int radius, Point2D center) {
        this.radius = radius;
        this.center = center;
    }

    public boolean belongs(Point2D point) {
        double left = Math.pow((point.getX() - center.getX()), 2) +
                Math.pow((point.getY() - center.getY()), 2);
        double right = Math.pow(radius, 2);
        return left <= right;
    }

    public boolean belongs(Cell cell) {

        //(x - a)^2 + (y - b)^2 =  r^2
        return belongs(cell.getHighLeft()) && belongs(cell.getHighRight())
                && belongs(cell.getLowLeft())  && belongs(cell.getLowRight());
    }
}
