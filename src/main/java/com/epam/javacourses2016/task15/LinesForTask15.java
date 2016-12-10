package com.epam.javacourses2016.task15;


public class LinesForTask15 {
    private double k;
    private double b;
    private int number;
    private int id;

    public LinesForTask15(double k, double b, int number, int id) {
        this.k = k;
        this.b = b;
        this.number = number;
        this.id = id;
    }

    public double getK() {
        return k;
    }

    public void setK(double k) {
        this.k = k;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addNumber() {
        this.number++;
    }

}

