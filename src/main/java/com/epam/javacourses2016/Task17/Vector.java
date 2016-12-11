package com.epam.javacourses2016.Task17;

import com.epam.javacourses2016.Point2D;

/**
 * Created by Vasya on 26.11.2016.
 */
public class Vector {
    private final double a;
    private final double b;

    public Vector(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public Vector(Point2D first, Point2D second) {
        this.a = second.getX() - first.getX();
        this.b = second.getY() - first.getY();
    }
    /**
     * @param multiplier вектор на который умножается данный
     *@return  псевдоскалярное произведение векторов
     */
    public double pseudoScalarMultiply(Vector multiplier) {
        return this.a * multiplier.getB() - this.b * multiplier.getA();
    }
}