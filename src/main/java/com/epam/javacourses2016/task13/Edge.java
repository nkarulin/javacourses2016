package com.epam.javacourses2016.task13;

/**
 * Created by Ivan on 24/11/2016.
 */
public class Edge {

    private int first;
    private int second;

    public Edge(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + first;
        result = PRIME * result + second;
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
        Edge edge = (Edge) obj;
        if (first != edge.getFirst())
            return false;
        if (second != edge.getSecond())
            return false;
        return true;
    }
}
