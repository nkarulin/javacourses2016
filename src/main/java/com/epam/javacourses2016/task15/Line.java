package com.epam.javacourses2016.task15;

import com.epam.javacourses2016.Point2D;
import com.epam.javacourses2016.Segment;
import com.epam.javacourses2016.task17.RangedLine;

import java.util.*;

/**
 * Created by GiulioRM on 12/13/2016.
 */
public class Line implements SolverTask15.ILine{

    private java.util.Set<Point2D> points;
    private RangedLine rangedLine;

    public Line(Segment segment) {
        points = new HashSet<>();
        points.add(segment.getA());
        points.add(segment.getB());
        rangedLine = new RangedLine(segment);
    }

    public boolean belongs(Point2D point) {
        return rangedLine.pointBelongs(point);
    }
    @Override
    public Set<Point2D> getPoints() {
        return points;
    }
}
