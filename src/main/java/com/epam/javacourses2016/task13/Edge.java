package com.epam.javacourses2016.task13;

/**
 * Created by GiulioRM on 12/13/2016.
 */
public class Edge {
    private int first;
    private int second;

    public Edge(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return this.first;
    }

    public void setFirst(int first) {
        this.first = first;
    }
    public int getSecond() {
        return this.second;
    }

    public void setSecond(int second) {
        this.second = second;
    }
}
