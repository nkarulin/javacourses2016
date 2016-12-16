package com.epam.javacourses2016.task13;

/**
 * Created by Vasya on 25.11.2016.
 */
public class Edge {
    private int first;
    private int second;


    public Edge(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public boolean is(int first, int second) {
        if ((this.first == first && this.second == second) || (this.first == second && this.second == first)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        return (((first == edge.first) && (second == edge.second)) || ((first == edge.second) && (second == edge.first)));

    }

    @Override
    public int hashCode() {
        int result = first;
        result = 31 * result + 7 * second;
        return result;
    }
}
