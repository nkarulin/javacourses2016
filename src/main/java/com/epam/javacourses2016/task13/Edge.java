package com.epam.javacourses2016.task13;

public class Edge {
    private int firstVertex;
    private int secondVertex;

    Edge(int firstVertex, int secondVertex) {
        this.firstVertex = firstVertex;
        this.secondVertex = secondVertex;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        return firstVertex == edge.firstVertex && secondVertex == edge.secondVertex;
    }

    @Override
    public int hashCode() {
        int result = firstVertex;
        result = 31 * result + secondVertex;
        return result;
    }
}
