package com.epam.javacourses2016.task17;

import com.epam.javacourses2016.Point2D;
import com.epam.javacourses2016.Segment;

/**
 * Created by GiulioRM on 11/23/2016.
 */
public class RangedLine extends Line {

    private Segment range;

    public RangedLine(Segment range) {

        this.range = range;
        getLineCoefficients();
    }

    public boolean pointBelongsToArea(Point2D point) {

        if (point == null || Double.isInfinite(point.getX()) || Double.isInfinite(point.getY()) ||
                Double.isNaN(point.getX()) ||Double.isNaN(point.getY()))
            return false;

        double x1 = this.getRange().getA().getX();
        double x2 = this.getRange().getB().getX();
        double y1 = this.getRange().getA().getY();
        double y2 = this.getRange().getB().getY();

        double firstX = 0;
        double secondX = 0;
        double firstY = 0;
        double secondY = 0;
        if (x1 > x2) {
            firstX = x2;
            secondX = x1;
        }
        else {
            firstX = x1;
            secondX = x2;
        }

        if (y1 > y2) {
            firstY = y2;
            secondY = y1;
        }
        else {
            firstY = y1;
            secondY = y2;
        }

        return point.getX() >= firstX && point.getX() <= secondX &&
                point.getY() >= firstY && point.getY() <= secondY;

    }

    public Point2D intersection(Line line) {
        Point2D intersection = super.intersection(line);
        if (intersection == null)
            return intersection;

        return pointBelongsToArea(intersection) ? intersection : null;
    }

    public boolean pointBelongs(Point2D point) {
        return super.belongs(point);
    }
    public boolean belongs(Point2D point) {
        return super.belongs(point) && pointBelongsToArea(point);
    }

    public Segment getRange() {
        return range;
    }

    public void getLineCoefficients() {
        double x1 = range.getA().getX();
        double x2 = range.getB().getX();
        double y1 = range.getA().getY();
        double y2 = range.getB().getY();

        if (x1 - x2 == 0)
        {
            this.b = 0;
        } else {
            this.b = (y2 * x1 - y1*x2)/(x1 - x2);
        }

        if (x1 == 0) {
            this.a = 0;
        }
        else {
            this.a = (y1 - this.b)/x1;
        }
    }


}
