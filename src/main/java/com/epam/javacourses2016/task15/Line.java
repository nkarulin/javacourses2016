package com.epam.javacourses2016.task15;


import com.epam.javacourses2016.Point2D;
import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Line implements SolverTask15.ILine,Serializable, Comparable {
    private static final long serialVersionUID = Line.class.getName().hashCode();

    private final Point2D a;
    private final Point2D b;
    private Set<Point2D> points;

    public Line(Point2D a, Point2D b) {
        this.a = a;
        this.b = b;
        points = new HashSet<>();
        points.add(a);
        points.add(b);
    }

    public Point2D getA() {
        return a;
    }

    public Point2D getB() {
        return b;
    }

    public void serialize(OutputStream stream) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(stream);
        out.writeObject(this);
        stream.flush();
    }

    public Line deserialize(InputStream stream) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(stream);
        return (Line) in.readObject();
    }

    public Set<Point2D> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "{" + a.getX() + "," + a.getY() + ";" + b.getX() + "," + b.getY() + "}";
    }

    public int compareTo(Object o) {
        Line line = (Line) o;
        return this.toString().compareTo(line.toString());
    }

}

