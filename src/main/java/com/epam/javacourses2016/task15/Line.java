package com.epam.javacourses2016.task15;

import com.epam.javacourses2016.Point2D;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Vasya on 26.11.2016.
 */
public class Line implements SolverTask15.ILine {
    private Set<Point2D> points;
    private Point2D start;
    private Point2D end;

    public Line(Point2D first, Point2D second) {
        points = new HashSet<Point2D>();
        points.add(first);
        this.start = first;
        points.add(second);
        this.end = second;
    }

    /**
     * @param point точка, чья принадлежность проверяется
     * @return true если точка принадлежит линии, false если иначе
     */

    public boolean belongToLine(Point2D point) {
        Iterator<Point2D> iterator = points.iterator();
        Point2D p1 = iterator.next();
        Point2D p2 = iterator.next();
        Vector first = new Vector(p1, p2);
        Vector second = new Vector(p1, point);
        if (first.pseudoScalarMultiply(second) == 0) {
            return true;
        }
        return false;

    }

    public Point2D getStart() {
        return start;
    }

    public Point2D getEnd() {
        return end;
    }

    public int size() {
        return points.size();
    }

    /**
     * @param first  первая точка отрезка
     * @param second вторая точка отрезка
     * @return возвращает длину отрезка
     */
    private double length(Point2D first, Point2D second) {
        return Math.sqrt(Math.pow(second.getY() - first.getY(), 2) + Math.pow(second.getX() - first.getX(), 2));
    }

    /**
     * устанавливает крайние точки линии так,
     * чтобы они задавали отрезок максимальной длины
     *
     * @param point - кандидат на крайнюю точку
     */

    private void setBorderPoints(Point2D point) {
        if (length(this.start, point) > length(this.start, this.end)) {
            if (length(this.end, point) > length(this.start, point)) {
                this.start = point;
            } else {
                this.end = point;
            }
        } else {
            if (length(this.end, point) > length(this.start, this.end)) {
                this.start = point;
            }
        }
    }

    public boolean unique(Point2D point) {
        for (Point2D p : points) {
            if (p.getX() == point.getX() && p.getY() == point.getY()) return false;
        }
        return true;
    }

    public void add(Point2D point) {
        if (this.belongToLine(point) && this.unique(point)) {
            points.add(point);
            setBorderPoints(point);
        }

    }

    /**
     * @return Точки, через которые проходит прямая
     */
    @Override
    public Set<Point2D> getPoints() {
        return points;
    }




    @Override
    public int hashCode() {
        int result = 31*new Double(start.getX()+start.getY()).hashCode()+31*new Double(end.getX()+end.getY()).hashCode();
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Line other = (Line) obj;
        return  ((this.end.getX()==other.getEnd().getX()&&this.end.getY()==other.getEnd().getY()&&
                this.start.getX()==other.getStart().getX()&&this.start.getY()==other.getStart().getY()) ||
                (this.end.getX()==other.getStart().getX()&&this.end.getY()==other.getStart().getY()&&
                        this.start.getX()==other.getEnd().getX()&&this.start.getY()==other.getEnd().getY()));


    }

}