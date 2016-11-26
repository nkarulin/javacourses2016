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
        return point.getX() >= this.range.getA().getX() &&
               point.getX() <= this.range.getB().getX() &&
               point.getY() >= this.range.getA().getX() &&
               point.getY() <= this.range.getB().getX();
    }

    public Point2D intersection(Line line) {
        Point2D intersection = super.intersection(line);
        return pointBelongsToArea(intersection) ? intersection : null;
    }

    public boolean belongs(Point2D point) {
        return super.belongs(point) && pointBelongsToArea(point);
    }

    public Segment getRange() {
        return range;
    }

    private void getLineCoefficients() {
        double x1 = range.getA().getX();
        double x2 = range.getB().getX();
        double y1 = range.getA().getY();
        double y2 = range.getB().getY();

        this.a = (x2 - x1) / (y2 - y1);
        this.b = y1 - a * x1;
    }
}
