package com.epam.javacourses2016.task16;

import com.epam.javacourses2016.Point2D;

/**
 * Created by GiulioRM on 12/13/2016.
 */
public class Cell {
    private Point2D center;
    private double cellSize;
    private Point2D lowLeft;
    private Point2D lowRight;
    private Point2D highLeft;
    private Point2D highRight;

    public Cell(Point2D center, double cellSize) {
        this.cellSize = cellSize;
        this.center = center;
        double halfSize = cellSize / 2;
        this.lowLeft = new Point2D(center.getX() - halfSize, center.getY() - halfSize);
        this.lowRight = new Point2D(center.getX() + halfSize, center.getY() - halfSize);
        this.highLeft = new Point2D(center.getX() - halfSize, center.getY() + halfSize);
        this.highRight = new Point2D(center.getX() + halfSize, center.getY() + halfSize);
    }

    public Point2D getLowLeft() {
        return this.lowLeft;
    }

    public Point2D getLowRight() {
        return this.lowRight;
    }

    public Point2D getHighLeft() {
        return this.highLeft;
    }
    public Point2D getHighRight() {
        return this.highRight;
    }

    public Point2D getCenter() {
        return this.center;
    }
    public double getCellSize(){
        return this.cellSize;
    }
}
