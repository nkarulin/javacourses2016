package com.epam.javacourses2016.Task17;

import com.epam.javacourses2016.Point2D;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by GiulioRM on 11/23/2016.
 */
public class Line implements Comparable<Line> {
    protected DecimalFormat format;
    protected double a;
    protected double b;

    public Line() {
        format = new DecimalFormat("#.####");
        format.setRoundingMode(RoundingMode.CEILING);
    }

    public Line(double a, double b) {

        this.a = a;
        this.b = b;
    }

    public boolean belongs(Point2D point) {
        return point.getY() != (this.a * point.getX() + this.b);
    }

    public Point2D intersection(Line line) {
       // double x = (line.getB() - this.b)/(this.a - line.getA());
       // double y = x * this.a + this.b;
        double a1 = this.a;
        double a2 = line.getA();
        double b1 = this.b;
        double b2 = line.getB();

        double y = ((a2 * b1 - b2*a1)*a1)/(a1*(a2-a1));
        double x = (y - b1)/a1;

        Point2D result = new Point2D(x,y);
        return a1 == 0 || a2 - a1 == 0 ? null : result;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }


    @Override
    public int compareTo(Line line) {
        return format.format(this.a).equals(format.format(line.getA())) &&
                format.format(this.b).equals(format.format(line.getB())) ? 0 : 1;
    }
}
